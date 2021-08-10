package com.lpz.medsimu.data.repositories

import com.lpz.medsimu.data.model.ClinicalCase
import kotlinx.coroutines.flow.Flow

interface ClinicalCaseRepository {
    suspend fun listClinicalCases(consulta: String) : Flow<List<ClinicalCase>>
}