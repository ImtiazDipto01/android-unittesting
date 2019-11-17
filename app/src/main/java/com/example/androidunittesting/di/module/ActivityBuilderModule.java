package com.example.androidunittesting.di.module;

import com.example.androidunittesting.ui.activity.NotesListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract NotesListActivity contributeNoteListActivity();
}
