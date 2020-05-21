package com.polinasmogi.cleanwishlist.data.local.dao

import androidx.room.*
import com.polinasmogi.cleanwishlist.data.local.entity.WishEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Query("SELECT * FROM wishes WHERE id = :id")
    abstract suspend fun getById(id: Long): WishEntity

    @Query("SELECT * FROM wishes ORDER BY title")
    abstract fun getAll(): Flow<List<WishEntity>>

    @Query("DELETE FROM wishes")
    abstract suspend fun deleteAll(): Int

    @Query("DELETE FROM wishes WHERE id = :id")
    abstract suspend fun deleteById(id: Long): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(wish: WishEntity): Long

    @Delete
    abstract suspend fun delete(wish: WishEntity): Int

}