package org.example.bookapp.book.domain

import org.example.bookapp.core.domain.DataError
import org.example.bookapp.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
}