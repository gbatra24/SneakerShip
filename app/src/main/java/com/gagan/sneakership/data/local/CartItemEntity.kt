package com.gagan.sneakership.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gagan.sneakership.data.local.AppDatabase.Companion.CART_TABLE

@Entity(tableName = CART_TABLE)
data class CartItemEntity (

    @ColumnInfo("id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @ColumnInfo("url")
    val url: String,

    @ColumnInfo("retailPrice")
    val retailPrice: Int,

    @ColumnInfo("title")
    val title: String,

)