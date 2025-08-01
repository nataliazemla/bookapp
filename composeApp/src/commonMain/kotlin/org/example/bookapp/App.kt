package org.example.bookapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.example.bookapp.book.presentation.book_list.BookListScreenRoot
import org.example.bookapp.book.presentation.book_list.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    BookListScreenRoot(
        viewModel = remember { BookListViewModel() },
        onBookClick = {}
    )
}