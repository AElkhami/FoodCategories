package com.elkhami.foodcategories.view.categorieslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.elkhami.foodcategories.data.repository.TestFoodCategoryRepository
import com.elkhami.foodcategories.data.stub.FoodCategoriesStub.mockedProductsList
import com.elkhami.foodcategories.testrules.MainCoroutineRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/**
 * Created by A.Elkhami on 07,November,2021
 */
@ExperimentalCoroutinesApi
class CategoriesListViewModelTest {

    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var viewModel: CategoriesListViewModel
    private lateinit var repository: TestFoodCategoryRepository

    @Before
    fun setUp() {
        repository = TestFoodCategoryRepository()
        viewModel = CategoriesListViewModel(repository)
    }

    @Test
    fun `get food data from repository, returns the data`() =
        runBlockingTest {
            viewModel.getFoodCategories()

            assertThat(viewModel.uiStateFlow.value.data).isEqualTo(mockedProductsList)
        }


    @Test
    fun `get from data from repository, returns unknown error`() =

        runBlockingTest {
            repository.setReturnError(true)

            viewModel.getFoodCategories()

            assertThat(viewModel.uiStateFlow.value.message).isEqualTo("error")
        }
}