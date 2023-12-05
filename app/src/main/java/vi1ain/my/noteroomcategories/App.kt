package vi1ain.my.noteroomcategories

import android.app.Application

class App:Application() {
    val database by lazy {
        MyDatabase.createDatabase(this)
    }
}