package com.example.crop2cash.repository

import com.example.crop2cash.utils.Resource
import com.example.crop2cash.view.model.Exhibit

interface ExhibitRepository {
    suspend fun getExhibits() : Resource<List<Exhibit>>
}