package com.tests.testcombank.soal2.di.presenter

import com.tests.testcombank.soal2.core.BaseView
import com.tests.testcombank.soal2.di.module.ContextModule
import com.tests.testcombank.soal2.di.module.NetworkModule
import com.tests.testcombank.soal2.ui.CrudPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    fun inject(postPresenter: CrudPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}