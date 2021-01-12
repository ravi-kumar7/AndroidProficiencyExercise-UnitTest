package com.android.assignment.di

import com.android.assignment.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(subcomponents = [])
abstract class SubComponents {

    @ActivityScope
    @ContributesAndroidInjector(modules = [])
    abstract fun contributeMainActivityInjector():MainActivity
}