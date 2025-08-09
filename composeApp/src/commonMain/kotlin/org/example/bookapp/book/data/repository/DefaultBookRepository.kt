package org.example.bookapp.book.data.repository

import androidx.sqlite.SQLiteException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.example.bookapp.book.data.database.FavouriteBookDao
import org.example.bookapp.book.data.mappers.toBook
import org.example.bookapp.book.data.mappers.toBookEntity
import org.example.bookapp.book.data.network.RemoteBookDataSource
import org.example.bookapp.book.domain.Book
import org.example.bookapp.book.domain.BookRepository
import org.example.bookapp.core.domain.DataError
import org.example.bookapp.core.domain.EmptyResult
import org.example.bookapp.core.domain.Result
import org.example.bookapp.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favouriteBookDao: FavouriteBookDao
) : BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        val localResult = favouriteBookDao.getFavouriteBook(bookId)

        return if (localResult == null) {
            remoteBookDataSource
                .getBookDetails(bookId)
                .map { it.description }
        } else {
            Result.Success(localResult.description)
        }
    }


    override fun getFavouriteBooks(): Flow<List<Book>> {
        return favouriteBookDao
            .getFavouriteBooks()
            .map { bookEntities ->
                bookEntities.map { it.toBook() }
            }
    }

    override fun isBookFavourite(id: String): Flow<Boolean> {
        return favouriteBookDao
            .getFavouriteBooks()
            .map { bookEntities ->
                bookEntities.any { it.id == id }
            }
    }

    override suspend fun markAsFavourite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favouriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavourites(id: String) {
        favouriteBookDao.deleteFavouriteBook(id)
    }
}