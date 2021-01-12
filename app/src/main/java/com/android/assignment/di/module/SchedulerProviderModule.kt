package com.android.assignment.di.module

import com.android.assignment.util.ISchedulerProvider
import com.android.assignment.util.SchedulerProvider
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class SchedulerProviderModule {

    @Singleton
    @Binds
    abstract fun provideSchedulerProvider(schedulerProvider: SchedulerProvider): ISchedulerProvider
}