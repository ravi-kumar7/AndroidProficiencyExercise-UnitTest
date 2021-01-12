package com.android.assignment.di.module

import android.content.Context
import com.android.assignment.MyApplication
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideCompositeDisposable():CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideContext(app: MyApplication): Context = app.applicationContext
}