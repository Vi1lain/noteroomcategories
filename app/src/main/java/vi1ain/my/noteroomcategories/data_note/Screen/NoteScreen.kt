package vi1ain.my.noteroomcategories.data_note.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import vi1ain.my.noteroomcategories.MyViewModel
import vi1ain.my.noteroomcategories.navigation.Route
import vi1ain.my.noteroomcategories.ui.theme.LightGreen220
import vi1ain.my.noteroomcategories.ui.theme.MyStrings

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun NoteScreen(
    newID: Int,
    navController: NavHostController,
    myViewModel: MyViewModel
) {
    val noteList = myViewModel.myDatabase.noteDao.getAllNotesById(newID).collectAsState(initial = emptyList())

    if (myViewModel.dialogState) {
        DialogController(
            myViewModel = myViewModel,
            onDismissRequest = {myViewModel.dialogState = false},
            dismissButton = { myViewModel.dialogState = false },
            confirmButton = {
                myViewModel.insertNote()
                myViewModel.dialogState = false}
        )
    }
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(containerColor = LightGreen220),
            navigationIcon = {
                IconButton(onClick = {
                    //myViewModel.categoryItemId = -1
                    navController.popBackStack(
                        route = Route.LIST_CATEGORIES,
                        inclusive = false
                    )
                }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = MyStrings.BUTTOM_BACK
                    )
                }
            },
            title = {
                Text(
                    text = "Title", maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
        )
    }, floatingActionButton = {
        ExtendedFloatingActionButton(containerColor = LightGreen220, onClick = {myViewModel.dialogState = true}) {
            Icon(Icons.Default.Add, contentDescription = MyStrings.ADD_CATEGORY)
            Text(text = "Добавить")
        }
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LightGreen220),
            contentPadding = PaddingValues(bottom = 80.dp, top = 70.dp),
            content = { items(noteList.value) {noteItem-> CardNoteScreen(noteItem=noteItem, onClickDelete = {note ->myViewModel.deleteNote(note)}) } })
    }
}