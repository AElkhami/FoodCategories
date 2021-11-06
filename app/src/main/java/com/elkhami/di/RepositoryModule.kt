package com.elkhami.di

import com.elkhami.data.remote.FoodCategoriesApi
import com.elkhami.data.repository.FoodCategoryRepository
import com.elkhami.data.repository.FoodCategoryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by A.Elkhami on 06,November,2021
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideFoodCategoryRepository(api: FoodCategoriesApi) : FoodCategoryRepository =
        FoodCategoryRepositoryImpl(api)
}