package vi1ain.my.noteroomcategories.data_categories.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import vi1ain.my.noteroomcategories.MyViewModel
import vi1ain.my.noteroomcategories.ui.theme.Green220
import vi1ain.my.noteroomcategories.ui.theme.LightGreen220
import vi1ain.my.noteroomcategories.ui.theme.MyStrings
import vi1ain.my.noteroomcategories.ui.theme.While220


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CategoriesScreen(myViewModel: MyViewModel, navController: NavHostController) {
    val categoryList = myViewModel.categoryList.collectAsState(initial = emptyList())
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LightGreen220)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    modifier = Modifier.weight(1f),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = While220,
                        unfocusedContainerColor = While220,
                        disabledContainerColor = While220,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = While220,
                    ),
                    value = myViewModel.nameState,
                    onValueChange = { text -> myViewModel.nameState = text })
                IconButton(onClick = { myViewModel.insertCategory() }) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = MyStrings.ADD_CATEGORY,
                        tint = Green220
                    )
                }
            }
            LazyColumn(modifier = Modifier.fillMaxSize(), content = {
                items(categoryList.value) { categoryItem ->
                    CardScreen(navController = navController, myViewModel = myViewModel,
                        categoryItem = categoryItem,
                        onClickDelete = { item -> myViewModel.deleteAllNotes(item) },
                        onClickEdit = { item ->
                            myViewModel.categoryCheckItem = item
                            myViewModel.nameState = item.categoryName
                        }
                    )
                }
            })
        }
    }
}