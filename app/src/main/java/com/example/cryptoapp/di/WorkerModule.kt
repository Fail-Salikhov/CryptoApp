package com.example.cryptoapp.di

import androidx.work.ListenableWorker
import com.example.cryptoapp.data.network.workers.ChildWorkerFactory
import com.example.cryptoapp.data.network.workers.RefreshDataWorker
import com.example.cryptoapp.data.network.workers.WorkerFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindWorkerFactory (worker: RefreshDataWorker.Factory): ChildWorkerFactory
}