package vi1ain.my.noteroomcategories.data_categories

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Query("SELECT * FROM categories_table")
    fun getAllCategories(): Flow<List<CategoriesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryEntity: CategoriesEntity)

    @Delete
    suspend fun deleteCategory(categoryEntity: CategoriesEntity)

    @Query("DELETE  FROM note_table WHERE categoryID = :categoryID")
    suspend fun deleteNote(categoryID: Int)

    @Transaction
    suspend fun deleteAllNotes(categoryEntity: CategoriesEntity) {
        deleteNote(categoryEntity.id!!)
        deleteCategory(categoryEntity)
    }
}