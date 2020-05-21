package com.polinasmogi.cleanwishlist.domain.repository

import com.polinasmogi.cleanwishlist.domain.entity.Wish
import kotlinx.coroutines.flow.Flow


interface WishesRepository {

    fun getWishes(): Flow<List<Wish>>

    suspend fun create(wish: Wish): Long

    suspend fun delete(wishId: Long): Boolean

}