package com.bookinventory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BookViewModelProviderFactory(private val _providerCallback: () -> ViewModel): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(_providerCallback()::class.java)) {
            return _providerCallback() as T
        }
        throw IllegalArgumentException("No relevant viewModel!")
    }
}