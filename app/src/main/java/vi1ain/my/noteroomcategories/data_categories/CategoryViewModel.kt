package vi1ain.my.noteroomcategories.data_categories

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.launch
import vi1ain.my.noteroomcategories.App
import vi1ain.my.noteroomcategories.MyDatabase

class CategoryViewModel(val myDatabase: MyDatabase) : ViewModel() {
    // ===================лист категорий=========================
    val categoryList = myDatabase.categoryDao.getAllCategories()

    //==================entity котегории ========================
    var categoryCheckItem: CategoriesEntity? = null

    // =============== переменные состояния======================
    var nameState by mutableStateOf("")


    fun insertCategory() = viewModelScope.launch {
        if (nameState.isNotEmpty()) {
            var item = categoryCheckItem?.copy(categoryName = nameState) ?: CategoriesEntity(
                categoryName = nameState
            )
            myDatabase.categoryDao.insertCategory(item)
        }
        categoryCheckItem = null
        nameState = ""
    }

    fun deleteCategory(categoryEntity: CategoriesEntity) = viewModelScope.launch {
        myDatabase.categoryDao.deleteCategory(categoryEntity = categoryEntity)
    }

    fun deleteAllNotes(categoryEntity: CategoriesEntity) = viewModelScope.launch {
        myDatabase.categoryDao.deleteAllNotes(categoryEntity = categoryEntity)
    }


    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return CategoryViewModel(myDatabase = database) as T
            }
        }
    }

}