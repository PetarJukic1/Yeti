package com.example.yeti.di

import com.example.yeti.feature_yeti.presentation.GameViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    viewModel { GameViewModel() }
}