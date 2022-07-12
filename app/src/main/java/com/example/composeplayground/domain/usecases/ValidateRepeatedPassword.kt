package com.example.composeplayground.domain.usecases

class ValidateRepeatedPassword {

    fun execute(password: String, repeatedPassword: String): ValidationResult {
        if (password != repeatedPassword) {
            return ValidationResult(successful = false, errorMessage = "passwords don't match")
        }
        return ValidationResult(true)
    }

}