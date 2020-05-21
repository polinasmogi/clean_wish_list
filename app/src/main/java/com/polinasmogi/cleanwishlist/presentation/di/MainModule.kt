package com.polinasmogi.cleanwishlist.presentation.di

import com.polinasmogi.cleanwishlist.domain.logger.Logger
import com.polinasmogi.cleanwishlist.presentation.logger.LoggerImpl
import com.polinasmogi.cleanwishlist.presentation.viewmodel.WishViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

private val module: Module = module {
    viewModel { WishViewModel(get(), get(), get(), get()) }

    single<Logger> { LoggerImpl() }
}

val presentationModule = listOf(module)