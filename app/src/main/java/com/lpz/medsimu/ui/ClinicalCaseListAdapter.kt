package com.lpz.medsimu.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lpz.medsimu.data.model.ClinicalCase
import com.lpz.medsimu.databinding.ItemClinicalCaseBinding

class ClinicalCaseListAdapter : ListAdapter<ClinicalCase, ClinicalCaseListAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemClinicalCaseBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder (
        private val binding: ItemClinicalCaseBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ClinicalCase) {
            binding.tvClinicalCaseArea.text = item.area
            binding.tvClinicalCaseName.text = item.name
            binding.tvClinicalCaseDiagnosis.text = item.diagnosis
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<ClinicalCase>() {
    override fun areItemsTheSame(oldItem: ClinicalCase, newItem: ClinicalCase) = oldItem == newItem
    override fun areContentsTheSame(oldItem: ClinicalCase, newItem: ClinicalCase) = oldItem.id == newItem.id
}