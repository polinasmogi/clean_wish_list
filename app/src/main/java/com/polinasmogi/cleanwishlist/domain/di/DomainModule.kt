package com.polinasmogi.cleanwishlist.domain.di

import com.polinasmogi.cleanwishlist.domain.usecase.CreateWishUseCase
import com.polinasmogi.cleanwishlist.domain.usecase.DeleteWishUseCase
import com.polinasmogi.cleanwishlist.domain.usecase.GetWishUseCase
import org.koin.dsl.module

private val modules = module {
    single { CreateWishUseCase(get()) }
    single { DeleteWishUseCase(get()) }
    single { GetWishUseCase(get()) }
}

val domainModules = listOf(modules)