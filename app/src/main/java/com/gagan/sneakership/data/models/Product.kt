package com.gagan.sneakership.data.models

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") val id: Int,
    @SerializedName("brand") val brand: String,
    @SerializedName("colorway") val colorway: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("media") val media: Media,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("retailPrice") val retailPrice: Int,
    @SerializedName("styleId") val styleId: String,
    @SerializedName("shoe") val shoe: String,
    @SerializedName("name") val name: String,
    @SerializedName("title") val title: String,
    @SerializedName("year") val year: Int
)