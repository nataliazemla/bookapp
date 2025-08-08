package org.example.bookapp.book.presentation.book_detail

import org.example.bookapp.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = false,
    val isFavorite: Boolean = false,
    val book: Book? = null,
)