package com.junodev.assignmentapp.di.modules

import com.junodev.assignmentapp.ui.tiles.viewmodel.TilesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        TilesViewModel()
    }
}