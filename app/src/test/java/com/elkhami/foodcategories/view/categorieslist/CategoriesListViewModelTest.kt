package com.elkhami.foodcategories.view.categorieslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.elkhami.foodcategories.data.repository.TestFoodCategoryRepository
import com.elkhami.foodcategories.data.stub.*
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
            val foodCategories = viewModel.getFoodCategories()

            assertThat(foodCategories).isEqualTo(OutputFoodCategoriesStub().outFoodCategories)
        }


    @Test
    fun `get from data from repository, returns unknown error`() =
        runBlockingTest {
            repository.setReturnError(true)

            viewModel.getFoodCategories()

            assertThat(viewModel.uiStateFlow.value.message).isEqualTo("error")
        }

    @Test
    fun `flatten FoodCategories, return ProductList`() {
        val productList =
            viewModel.flattenFoodCategoriesToProductList(InputFoodCategoriesStub().inFoodCategories)

        assertThat(productList).isEqualTo(FoodCategoriesStubAfterFlatting().outProductsListAfterFlatting)
    }

    @Test
    fun `flatten FoodCategories, return additional header item`() {
        val productList =
            viewModel.flattenFoodCategoriesToProductList(InputFoodCategoriesStub().inFoodCategories)

        assertThat(productList.size).isEqualTo(InputFoodCategoriesStub().inProductsList.size + 1)
    }

    @Test
    fun `map Image Url string to full url, return full url`() {
        val productList = viewModel.mapImageUrlString(InputFoodCategoriesStub().inProductsList)

        assertThat(productList[0].url).isEqualTo(FoodCategoriesStubAfterUrlMapping().outProductsListAfterMapping[0].url)
    }

    @Test
    fun `sending required data after flatting and mapping to UI, return required data`() =
        runBlockingTest {

            viewModel.updateUiWithData()

            assertThat(viewModel.uiStateFlow.value.data).isEqualTo(
                FoodCategoriesStubAfterFattingAndUrlMapping().outProductsListAfterFattingAndUrlMapping
            )
        }
}