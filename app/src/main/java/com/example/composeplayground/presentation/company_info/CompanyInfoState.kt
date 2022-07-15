package com.example.composeplayground.presentation.company_info

import com.example.composeplayground.domain.model.CompanyInfo
import com.example.composeplayground.domain.model.IntraDayInfo

data class CompanyInfoState(
    val stockInfo: List<IntraDayInfo> = emptyList(),
    val company: CompanyInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)