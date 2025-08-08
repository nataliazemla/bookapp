package org.example.bookapp.book.presentation.book_detail

import org.example.bookapp.book.domain.Book

sealed interface BookDetailAction {
    data object OnBackClick: BookDetailAction
    data object OnFavoriteClick: BookDetailAction
    data class OnSelectedBookChange(val book: Book?): BookDetailAction
}