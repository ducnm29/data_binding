package com.ducnm.bruhmovie.data.network.movie

import com.ducnm.bruhmovie.model.ProductionCompany
import com.google.gson.annotations.SerializedName

data class ProductionCompanyResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("logo_path")
    val logoPath: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin_country")
    val originCountry: String?
)

fun ProductionCompanyResponse.toModel() : ProductionCompany {
    return ProductionCompany(
        id = id,
        logoPath = logoPath ?: "",
        name = name ?: "",
        originCountry = originCountry ?: ""
    )
}