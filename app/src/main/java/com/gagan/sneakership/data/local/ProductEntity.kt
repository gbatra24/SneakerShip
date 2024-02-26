package com.gagan.sneakership.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.gagan.sneakership.data.local.AppDatabase.Companion.PRODUCTS_TABLE
import com.gagan.sneakership.data.models.Media
import com.gagan.sneakership.utils.Constants
import com.google.gson.annotations.SerializedName

@Entity(tableName = PRODUCTS_TABLE)
data class ProductEntity (

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