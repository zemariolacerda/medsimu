package com.lpz.medsimu.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.lpz.medsimu.R
import com.lpz.medsimu.databinding.ActivityListClinicalCaseBinding
import com.lpz.medsimu.presentation.ClinicalCaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ClinicalCaseActivity : AppCompatActivity() {

    private val viewModel by viewModel<ClinicalCaseViewModel>()
    private val adapter by lazy { ClinicalCaseListAdapter() }
    private val binding by lazy { ActivityListClinicalCaseBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvClinicalCases.adapter = adapter

        viewModel.getClinicalCaseList("06a54ec5-2ad5-4e6c-beef-91982044760b")
        viewModel.clinicalCases.observe(this) {
            when(it) {
                ClinicalCaseViewModel.State.Loading -> {}
                is ClinicalCaseViewModel.State.Error -> {}
                is ClinicalCaseViewModel.State.Success -> {
                    adapter.submitList(it.list)
                }
            }
        }
    }
}