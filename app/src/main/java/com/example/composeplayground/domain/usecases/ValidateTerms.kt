package com.example.composeplayground.domain.usecases

class ValidateTerms {

    fun execute(accepted:Boolean): ValidationResult {
        if (!accepted) {
            return ValidationResult(successful = false, errorMessage = "Please accept the terms")
        }
        return ValidationResult(true)
    }

}