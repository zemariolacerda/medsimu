package com.lpz.medsimu.data.repositories

import android.os.RemoteException
import com.lpz.medsimu.data.model.ClinicalCase
import com.lpz.medsimu.data.services.MedSimuService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException


class ClinicalCaseRepositoryImpl(private val service: MedSimuService) : ClinicalCaseRepository {


    override suspend fun listClinicalCases(consulta: String) = flow {
        try {
            val clinicalCaseList = service.listClinicalCases(consulta)
            emit(clinicalCaseList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message)
        }
    }

}