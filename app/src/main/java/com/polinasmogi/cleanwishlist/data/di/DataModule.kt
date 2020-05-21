package com.polinasmogi.cleanwishlist.data.di

import androidx.room.Room
import com.polinasmogi.cleanwishlist.data.local.db.WishDatabase
import com.polinasmogi.cleanwishlist.data.local.source.WishDataSource
import com.polinasmogi.cleanwishlist.data.repository.WishesRepositoryImpl
import com.polinasmogi.cleanwishlist.domain.repository.WishesRepository
import org.koin.dsl.module

private val databaseModule = module {
    single {
        Room.databaseBuilder(get(), WishDatabase::class.java, WishDatabase.DATABASE_NAME).build()
    }
    single { get<WishDatabase>().wishDao() }
}


private val repositoryModule = module {
    single<WishesRepository> { WishesRepositoryImpl(get()) }
    single { WishDataSource(get()) }
}

val dataModules = repositoryModule + databaseModule