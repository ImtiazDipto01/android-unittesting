package com.example.androidunittesting.di;

import android.app.Application;

import com.example.androidunittesting.utils.App;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = {AndroidInjectionModule.class /*ActivityBuilderModule.class, AppModule.class, ViewModuleFactoryModule.class*/})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
