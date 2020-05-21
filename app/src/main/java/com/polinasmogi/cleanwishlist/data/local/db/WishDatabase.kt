package com.polinasmogi.cleanwishlist.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.polinasmogi.cleanwishlist.data.local.dao.WishDao
import com.polinasmogi.cleanwishlist.data.local.entity.WishEntity

@Database(
    version = 1,
    entities = [WishEntity::class]
)
abstract class WishDatabase : RoomDatabase() {

    abstract fun wishDao(): WishDao

    companion object {
        const val DATABASE_NAME = "clean_wish_list.db"
    }

}

