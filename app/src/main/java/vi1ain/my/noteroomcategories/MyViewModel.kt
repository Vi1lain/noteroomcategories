package vi1ain.my.noteroomcategories

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import kotlinx.coroutines.launch
import vi1ain.my.noteroomcategories.data_categories.CategoriesEntity
import vi1ain.my.noteroomcategories.data_note.NoteEntity

class MyViewModel(val myDatabase: MyDatabase) : ViewModel() {
    // ===================лист категорий=========================
    val categoryList = myDatabase.categoryDao.getAllCategories()
    var categoryItemId =-1
    var nameCategory ="Title"
    // ===================лист записей===========================


    //=========================entity============================
    var categoryCheckItem: CategoriesEntity? = null
    var noteCheckItem: NoteEntity? = null

    // =============== переменные состояния======================
    var nameState by mutableStateOf("")
    var titleState by mutableStateOf("")
    var descriptionState by mutableStateOf("")
    var dialogState by mutableStateOf(false)


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

    fun insertNote() = viewModelScope.launch {
        if (titleState.isNotEmpty()){
            var item = noteCheckItem?.copy(title = titleState, description = descriptionState)?: NoteEntity(
                title = titleState, description = descriptionState, categoryID = categoryItemId
            )
            myDatabase.noteDao.insertNotes(item)
        }
        noteCheckItem = null
        titleState = ""
        descriptionState =""
    }




    fun deleteCategory(categoryEntity: CategoriesEntity) = viewModelScope.launch {
        myDatabase.categoryDao.deleteCategory(categoryEntity = categoryEntity)
    }

    fun deleteAllNotes(categoryEntity: CategoriesEntity) = viewModelScope.launch {
        myDatabase.categoryDao.deleteAllNotes(categoryEntity = categoryEntity)
    }
    fun deleteNote(noteEntity: NoteEntity) = viewModelScope.launch {
        myDatabase.noteDao.deleteNotes(noteEntity = noteEntity)
    }


    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val database = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return MyViewModel(myDatabase = database) as T
            }
        }
    }

}