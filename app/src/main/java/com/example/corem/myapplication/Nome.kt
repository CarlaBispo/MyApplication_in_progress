package com.example.corem.myapplication

import com.google.gson.annotations.SerializedName

data class Nome (@SerializedName("name")val nome:String,
                 @SerializedName("avatar_url")val avatatarUrl:String)