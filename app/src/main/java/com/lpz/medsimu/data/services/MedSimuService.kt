package com.lpz.medsimu.data.services

import com.lpz.medsimu.data.model.ClinicalCase
import retrofit2.http.GET
import retrofit2.http.Path

interface MedSimuService {
    @GET("clinical_case/{consulta}")
    suspend fun listClinicalCases(@Path("consulta") consulta: String): List<ClinicalCase>
}