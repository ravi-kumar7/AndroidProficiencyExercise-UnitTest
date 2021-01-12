package com.android.assignment.data.repository

import com.android.assignment.data.Repository
import com.android.assignment.data.api.NetworkService
import com.android.assignment.data.model.Response
import com.android.assignment.util.DummyData
import com.android.assignment.util.TestSchedulerProvider
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepositoryTest {

    @Mock
    private lateinit var networkService: NetworkService
    private lateinit var repository: Repository
    private lateinit var testSchedulerProvider: TestSchedulerProvider

    @Before
    fun setUp()
    {
        val testScheduler = TestScheduler()
        testSchedulerProvider = TestSchedulerProvider(testScheduler)
        repository = Repository(networkService,testSchedulerProvider )
    }

    @Test
    fun whenFetchFacts_remoteDataSourceCall(){
        val facts = DummyData.getData()
        val response = Response("Dummy Title",facts)
        doReturn(Single.just(response))
            .`when`(networkService)
            .fetchFacts()
        repository.getData()
            .observeOn(testSchedulerProvider.io())
            .subscribeOn(testSchedulerProvider.ui())
            .subscribe(
                {
                    assert(facts==it)
                },
                {

                }
            )
        verify(networkService).fetchFacts()
    }

}