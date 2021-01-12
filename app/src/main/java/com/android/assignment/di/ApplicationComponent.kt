package com.android.assignment.di

import android.content.Context
import com.android.assignment.MyApplication
import com.android.assignment.di.module.ApplicationModule
import com.android.assignment.di.module.NetworkModule
import com.android.assignment.di.module.SchedulerProviderModule
import com.android.assignment.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class,ApplicationModule::class,ViewModelModule::class, SubComponents::class
    , NetworkModule::class, SchedulerProviderModule::class])
interface ApplicationComponent: AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<MyApplication>{
    }
}