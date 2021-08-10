package com.lpz.medsimu.domain.di

import com.lpz.medsimu.domain.ListClinicalCaseUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load() {
        loadKoinModules(useCaseModule())
    }

    private fun useCaseModule(): Module {
        return module {
            factory { ListClinicalCaseUseCase(get()) }
        }
    }
}