package com.example.myapplicationwithpaging3.model

import com.google.gson.annotations.Expose
import com.squareup.moshi.Json

data class UserResponse(

    @Json(name = "page") @Expose val page: Int,
    @Json(name = "per_page") @Expose val per_page: Int,
    @Json(name = "total") @Expose val total: Int,
    @Json(name = "total_pages") @Expose val total_pages: Int,
    @Json(name = "support") @Expose val support: SupportModel?,
    @Json(name = "data") @Expose val data: List<UserDataModel>
)

data class UserDataModel(

    @Json(name = "id") @Expose var id: Int?,
    @Json(name = "email") @Expose var email: String?,
    @Json(name = "first_name") @Expose var first_name: String?,
    @Json(name = "last_name") @Expose var last_name: String?,
    @Json(name = "avatar") @Expose var avatar: String?
)

data class SupportModel(

    @Json(name = "url") @Expose val url: String?,
    @Json(name = "text") @Expose val text: String?
)

