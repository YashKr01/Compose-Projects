package com.example.composeplayground.presentation.company_listing

sealed class CompanyListingEvent {
    object Refresh : CompanyListingEvent()
    data class OnSearchQueryChange(val query: String):CompanyListingEvent()
}
