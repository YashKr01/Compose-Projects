package com.example.composeplayground.domain.usecases

import android.util.Patterns

class ValidateEmail {

    fun execute(email: String): ValidationResult {
        if (email.isBlank()) {
            return ValidationResult(successful = false, errorMessage = "email cannot be blank")
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return ValidationResult(successful = false, errorMessage = "email not valid")
        }

        return ValidationResult(true)
    }

}