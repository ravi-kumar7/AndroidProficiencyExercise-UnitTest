package com.android.assignment.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.assignment.R
import com.android.assignment.data.Repository
import com.android.assignment.data.model.Fact
import com.android.assignment.data.model.State
import com.android.assignment.util.ISchedulerProvider
import com.android.assignment.util.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    private val repository: Repository,
    private val schedulerProvider: ISchedulerProvider,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _facts: MutableLiveData<State> = MutableLiveData(State.Idle)
    val facts: LiveData<State> = _facts

    fun loadFacts() {
        _facts.value = State.Loading
        compositeDisposable.add(networkHelper.checkNetworkAvailability()
            .onErrorReturnItem(false)
            .subscribe {
                if (it) getFactsFromAPI() else _facts.value = State.Error(R.string.network_error)
            }
        )
    }

    private fun getFactsFromAPI() {
        compositeDisposable.add(
            repository.getData()
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    _facts.postValue(State.Success<List<Fact>>(it))
                },
                    {
                        _facts.postValue(State.Error(R.string.error))
                    }
                )
        )
    }
}