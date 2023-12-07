package vi1ain.my.noteroomcategories.data_categories

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories_table")
data class CategoriesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val categoryName:String,
    val time:String,
)
