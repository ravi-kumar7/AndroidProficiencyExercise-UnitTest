package com.android.assignment.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.assignment.util.ViewModelFactory
import com.android.assignment.data.Repository
import com.android.assignment.di.ViewModelKey
import com.android.assignment.ui.MainViewModel
import com.android.assignment.util.ISchedulerProvider
import com.android.assignment.util.NetworkHelper
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Module
class ViewModelModule {

    @Singleton
    @Provides
    fun getViewModelFactory(map:Map<Class<out ViewModel>, ViewModel>): ViewModelProvider.Factory {
        return ViewModelFactory(map)
    }

    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(compositeDisposable: CompositeDisposable, repository:Repository, schedulerProvider: ISchedulerProvider,networkHelper: NetworkHelper): MainViewModel =
        MainViewModel(compositeDisposable,repository, schedulerProvider, networkHelper)
}