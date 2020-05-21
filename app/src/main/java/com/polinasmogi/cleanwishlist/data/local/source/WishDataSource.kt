package com.polinasmogi.cleanwishlist.data.local.source

import com.polinasmogi.cleanwishlist.data.local.dao.WishDao
import com.polinasmogi.cleanwishlist.data.local.entity.WishEntity
import kotlinx.coroutines.flow.Flow

class WishDataSource(private val dao: WishDao) {

    fun getItems(): Flow<List<WishEntity>> = dao.getAll()

    suspend fun insert(wish: WishEntity): Long = dao.insert(wish)

    suspend fun getWish(wishId: Long): WishEntity = dao.getById(wishId)

    suspend fun deleteWish(wishId: Long): Boolean = dao.deleteById(wishId) > 0

}