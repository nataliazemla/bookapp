package org.example.bookapp.book.data.repository

import org.example.bookapp.book.data.mappers.toBook
import org.example.bookapp.book.data.network.RemoteBookDataSource
import org.example.bookapp.book.domain.Book
import org.example.bookapp.book.domain.BookRepository
import org.example.bookapp.core.domain.DataError
import org.example.bookapp.core.domain.Result
import org.example.bookapp.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { dto ->
                dto.results.map { it.toBook() }
            }
    }
}