package com.example.crop2cash.repository

import com.example.crop2cash.remote.ExhibitsLoader
import com.example.crop2cash.utils.Resource
import com.example.crop2cash.view.model.Exhibit
import javax.inject.Inject

class ExhibitRepositoryImpl @Inject constructor(
    private val exhibitsLoader: ExhibitsLoader
    ) : ExhibitRepository {

        override suspend fun getExhibits(): Resource<List<Exhibit>> {
            return try {
                val response = exhibitsLoader.getExhibitList().map { Exhibit(it.title, it.images) }
                Resource.Success(response)
            }catch (err : Exception){
                Resource.Error(err)
            }
    }

}
