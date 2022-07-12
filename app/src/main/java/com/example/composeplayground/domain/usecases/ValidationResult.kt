package com.example.composeplayground.domain.usecases

data class ValidationResult(val successful: Boolean, val errorMessage: String? = null)