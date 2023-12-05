package vi1ain.my.noteroomcategories

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import vi1ain.my.noteroomcategories.data_categories.CategoriesEntity
import vi1ain.my.noteroomcategories.data_categories.CategoryDao
import vi1ain.my.noteroomcategories.data_note.NoteDao
import vi1ain.my.noteroomcategories.data_note.NoteEntity

@Database(entities = [CategoriesEntity::class, NoteEntity::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract val categoryDao: CategoryDao
    abstract val noteDao: NoteDao

    companion object {
        fun createDatabase(app: App) =
            Room.databaseBuilder(app, MyDatabase::class.java, "database.db").build()
    }
}