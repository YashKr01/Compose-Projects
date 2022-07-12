package com.example.composeplayground.domain.usecases

import android.util.Patterns

class ValidatePassword {

    fun execute(password: String): ValidationResult {
        if (password.length < 8) {
            return ValidationResult(successful = false, errorMessage = "password too short")
        }
        val containsLetterDigits = password.any { it.isDigit() } && password.any { it.isLetter() }
        if (!containsLetterDigits) {
            return ValidationResult(successful = false, errorMessage = "password should contain at least one letter and digit")
        }

        return ValidationResult(true)
    }

}