package com.android.assignment.util

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

class TestSchedulerProvider(private val testScheduler: TestScheduler): ISchedulerProvider{

    override fun computation(): Scheduler = testScheduler

    override fun io(): Scheduler  = testScheduler

    override fun ui(): Scheduler = testScheduler
}