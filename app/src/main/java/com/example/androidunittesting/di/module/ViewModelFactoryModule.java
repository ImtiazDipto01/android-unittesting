package com.example.androidunittesting.di.module;

import androidx.lifecycle.ViewModelProvider;

import com.example.androidunittesting.utils.ViewModelProviderFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory viewModelProviderFactory);
}
