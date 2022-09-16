package com.example.crop2cash.remote

import com.example.crop2cash.Constant.GET_EXHIBIT_END_POINT
import com.example.crop2cash.remote.model.ExhibitDto
import retrofit2.http.GET

interface ExhibitsLoader {

    @GET(GET_EXHIBIT_END_POINT)
    suspend fun getExhibitList() : ExhibitDto
}