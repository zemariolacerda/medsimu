package com.lpz.medsimu.presentation.di

import com.lpz.medsimu.presentation.ClinicalCaseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object PresentationModule {
    fun load() {
        loadKoinModules(viewModelModule())
    }

    private fun viewModelModule(): Module {
        return module {
            viewModel { ClinicalCaseViewModel(get()) }
        }
    }
}