package com.example.crop2cash.usecase

import com.example.crop2cash.repository.ExhibitRepository
import com.example.crop2cash.utils.Resource
import com.example.crop2cash.view.model.Exhibit
import javax.inject.Inject

class GetExhibitsUseCase @Inject constructor(
    private val exhibitRepository: ExhibitRepository
) {
    suspend operator fun invoke() : Resource<List<Exhibit>>{
        return exhibitRepository.getExhibits()
    }
}