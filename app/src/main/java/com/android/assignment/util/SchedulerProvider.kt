package com.android.assignment.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SchedulerProvider @Inject constructor() : ISchedulerProvider {
    override fun computation() = Schedulers.computation()

    override fun io() = Schedulers.io()

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()
}