package com.lpz.medsimu.domain

import com.lpz.medsimu.core.UseCase
import com.lpz.medsimu.data.model.ClinicalCase
import com.lpz.medsimu.data.repositories.ClinicalCaseRepository
import kotlinx.coroutines.flow.Flow

class ListClinicalCaseUseCase(
    private val repository: ClinicalCaseRepository
) : UseCase<String, List<ClinicalCase>>() {

    override suspend fun execute(param: String): Flow<List<ClinicalCase>> {
        return repository.listClinicalCases(param)
    }
}