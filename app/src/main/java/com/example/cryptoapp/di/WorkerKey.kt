package com.example.cryptoapp.di

import androidx.lifecycle.ViewModel
import androidx.work.ListenableWorker
import com.example.cryptoapp.data.network.workers.ChildWorkerFactory
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class WorkerKey(val value: KClass<out ListenableWorker>)
