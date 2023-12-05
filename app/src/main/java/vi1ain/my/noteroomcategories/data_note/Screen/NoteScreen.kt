package vi1ain.my.noteroomcategories.data_note.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vi1ain.my.noteroomcategories.ui.theme.LightPurple220
import vi1ain.my.noteroomcategories.ui.theme.MyStrings

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun NoteScreen() {
    Scaffold(floatingActionButton = {
        ExtendedFloatingActionButton(onClick = {}) {
            Icon(Icons.Default.Add, contentDescription = MyStrings.ADD_CATEGORY)
            Text(text = "Добавить")
        }
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LightPurple220),
            contentPadding = PaddingValues(bottom = 80.dp),
            content = {items(20){CardScreen()} })
    }
}