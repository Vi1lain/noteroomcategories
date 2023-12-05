package vi1ain.my.noteroomcategories.data_note

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    val title:String,
    val description:String,
    val categoryID:Int
)
