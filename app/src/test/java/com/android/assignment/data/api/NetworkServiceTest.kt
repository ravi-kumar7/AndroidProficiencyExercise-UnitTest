package com.android.assignment.data.api

import com.android.assignment.BuildConfig
import com.android.assignment.util.TestSchedulerProvider
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkServiceTest {


    private lateinit var networkService: NetworkService

    @Before
    fun setUp()
    {
        networkService = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }

    @Test
    fun whenRequestMade_fetchResponse(){
        val testScheduler = TestScheduler()
        val testSchedulerProvider = TestSchedulerProvider(testScheduler)
        networkService.fetchFacts()
            .subscribeOn(testSchedulerProvider.io())
            .observeOn(testSchedulerProvider.ui())
            .subscribe(
                {
                    assert(it.title.isNotBlank())
                    assert(it.rows.isNotEmpty())
                },
                {

                }
            )
        testScheduler.triggerActions()

    }




}