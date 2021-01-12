package com.android.assignment.util

import io.reactivex.Scheduler
import io.reactivex.annotations.NonNull

interface ISchedulerProvider {
    @NonNull
    fun computation(): Scheduler

    @NonNull
    fun io(): Scheduler

    @NonNull
    fun ui(): Scheduler
}