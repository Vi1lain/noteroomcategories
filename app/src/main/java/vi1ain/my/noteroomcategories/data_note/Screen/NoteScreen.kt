package vi1ain.my.noteroomcategories.data_note.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import vi1ain.my.noteroomcategories.MyViewModel
import vi1ain.my.noteroomcategories.navigation.Route
import vi1ain.my.noteroomcategories.ui.theme.LightGreen220
import vi1ain.my.noteroomcategories.ui.theme.MediumGreen220
import vi1ain.my.noteroomcategories.ui.theme.MyStrings
import vi1ain.my.noteroomcategories.ui.theme.While220

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun NoteScreen(
    newID: Int,
    navController: NavHostController,
    myViewModel: MyViewModel
) {
    val noteList =
        myViewModel.myDatabase.noteDao.getAllNotesById(newID).collectAsState(initial = emptyList())

    if (myViewModel.dialogState) {
        DialogController(
            myViewModel = myViewModel,
            onDismissRequest = { myViewModel.dialogState = false },
            dismissButton = { myViewModel.dialogState = false },
            confirmButton = {
                myViewModel.insertNote()
                myViewModel.dialogState = false
            }
        )
    }
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MediumGreen220),
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack(
                        route = Route.LIST_CATEGORIES,
                        inclusive = false
                    )
                }) {
                    Icon(
                        modifier = Modifier
                            //.clip(shape = CircleShape)
                            .background(color = While220).padding(10.dp),
                        //tint = Green220,
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = MyStrings.BUTTOM_BACK
                    )
                }
            },
            title = {
                Text(
                    text = myViewModel.nameCategory,
                    //fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            },
        )
    }, floatingActionButton = {
        ExtendedFloatingActionButton(
            containerColor = MediumGreen220,
            onClick = { myViewModel.dialogState = true }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = MyStrings.ADD_CATEGORY)
            Text(text = MyStrings.ADD)
        }
    }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LightGreen220),
            contentPadding = PaddingValues(bottom = 80.dp, top = 70.dp),
            content = {
                items(noteList.value) { noteItem ->
                    CardNoteScreen(navController = navController,
                        noteItem = noteItem,
                        onClickDelete = { note -> myViewModel.deleteNote(note) }, myViewModel = myViewModel)
                }
            })
    }
}