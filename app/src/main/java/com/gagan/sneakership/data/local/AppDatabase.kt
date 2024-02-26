package com.gagan.sneakership.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CartItemEntity::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun appDao(): AppDao

    companion object {
        const val PRODUCTS_DATABASE = "products_database"
        const val PRODUCTS_TABLE = "products"
        const val CART_TABLE = "cart"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun get(context: Context): AppDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    PRODUCTS_DATABASE
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}