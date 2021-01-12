package com.android.assignment.data

import com.android.assignment.data.api.NetworkService
import com.android.assignment.data.model.Fact
import com.android.assignment.util.ISchedulerProvider
import io.reactivex.Single
import javax.inject.Inject

class Repository @Inject constructor(private val service:NetworkService, private val schedulerProvider: ISchedulerProvider) {

    fun getData(): Single<List<Fact>> {
        return service.fetchFacts()
            .subscribeOn(schedulerProvider.io())
            .map {
                it.rows.filter { fact -> fact.title!=null }
            }
    }
}