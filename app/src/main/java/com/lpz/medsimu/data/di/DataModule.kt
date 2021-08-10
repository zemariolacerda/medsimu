package com.lpz.medsimu.data.di

import android.util.Log
import com.google.gson.GsonBuilder
import com.lpz.medsimu.data.repositories.ClinicalCaseRepository
import com.lpz.medsimu.data.repositories.ClinicalCaseRepositoryImpl
import com.lpz.medsimu.data.services.MedSimuService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    private const val OK_HTTP = "OkHttp"

    fun load() {
        loadKoinModules(networkModules() + clinicalCasesModule())
    }

    private fun networkModules(): Module {
        return module {
            single {
                val interceptor = HttpLoggingInterceptor {
                    Log.e(OK_HTTP, it)
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            }

            single {
                GsonConverterFactory.create(GsonBuilder().create())
            }

            single {
                createService<MedSimuService>(get(), get())
            }
        }
    }

    private fun clinicalCasesModule(): Module {
        return module {
            single<ClinicalCaseRepository> { ClinicalCaseRepositoryImpl(get()) }
        }
    }

    private inline fun <reified T> createService(client: OkHttpClient, factory: GsonConverterFactory) : T {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.10:5001/api/v1/")
            .client(client)
            .addConverterFactory(factory)
            .build().create(T::class.java)
    }
}