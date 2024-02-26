package com.gagan.sneakership.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gagan.sneakership.utils.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Query("SELECT * FROM ${AppDatabase.CART_TABLE}")
    fun getCartItems(): List<CartItemEntity>

    @Query("SELECT * FROM ${AppDatabase.CART_TABLE} WHERE id = :id")
    suspend fun getCartItemById(id: Int): CartItemEntity?

    @Query("SELECT COUNT(*) FROM ${AppDatabase.CART_TABLE}")
    suspend fun getCartCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartItem: CartItemEntity)

    @Delete
    suspend fun deleteCartItem(cartItem: CartItemEntity)
}