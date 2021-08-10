package com.lpz.medsimu.data.model

data class ClinicalCase (
    val id: String,
    val name : String,
    val questions : String,
    val area : String,
    val diagnosis : String,
    val treatment : String
    )