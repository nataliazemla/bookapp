package org.example.bookapp.di

import org.example.bookapp.book.data.network.KtorRemoteBookDataSource
import org.example.bookapp.book.data.network.RemoteBookDataSource
import org.example.bookapp.book.data.repository.DefaultBookRepository
import org.example.bookapp.book.domain.BookRepository
import org.example.bookapp.book.presentation.SelectedBookViewModel
import org.example.bookapp.book.presentation.book_list.BookListViewModel
import org.example.bookapp.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
}