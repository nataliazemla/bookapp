package org.example.bookapp.book.data.network

import org.example.bookapp.book.data.dto.BookWorkDto
import org.example.bookapp.book.data.dto.SearchResponseDto
import org.example.bookapp.core.domain.DataError
import org.example.bookapp.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}