package com.polinasmogi.cleanwishlist.data.repository

import com.polinasmogi.cleanwishlist.data.local.mapper.toWish
import com.polinasmogi.cleanwishlist.data.local.mapper.toWishEntity
import com.polinasmogi.cleanwishlist.data.local.source.WishDataSource
import com.polinasmogi.cleanwishlist.domain.entity.Wish
import com.polinasmogi.cleanwishlist.domain.repository.WishesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class WishesRepositoryImpl(private val dataSource: WishDataSource) : WishesRepository {

    override fun getWishes(): Flow<List<Wish>> = dataSource.getItems().map { it.toWish() }

    override suspend fun create(wish: Wish): Long = dataSource.insert(wish.toWishEntity())

    override suspend fun delete(wishId: Long): Boolean = dataSource.deleteWish(wishId)

}