package vi1ain.my.noteroomcategories.data_categories.Screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import vi1ain.my.noteroomcategories.MyViewModel
import vi1ain.my.noteroomcategories.data_categories.CategoriesEntity
import vi1ain.my.noteroomcategories.navigation.Route
import vi1ain.my.noteroomcategories.ui.theme.MyStrings
import vi1ain.my.noteroomcategories.ui.theme.Purple220
import vi1ain.my.noteroomcategories.ui.theme.Red220
import vi1ain.my.noteroomcategories.ui.theme.While220


@SuppressLint("UnrememberedMutableState")
@Composable
fun CardScreen(
    navController: NavHostController,
    categoryItem: CategoriesEntity,
    onClickDelete: (CategoriesEntity) -> Unit,
    onClickEdit: (CategoriesEntity) -> Unit,


    myViewModel: MyViewModel
) {

    Card(
        modifier = Modifier
            .clickable {
                myViewModel.nameCategory = categoryItem.categoryName
                myViewModel.categoryItemId = categoryItem.id!!
                navController.navigate(Route.LIST_NOTES + "/${categoryItem.id}")
            }
            .fillMaxWidth()
            .padding(top = 8.dp, start = 5.dp, end = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(While220)
        ) {

            IconButton(onClick = {
                onClickEdit(categoryItem)
            }) {
                Icon(
                    tint = Purple220,
                    imageVector = Icons.Default.Edit,
                    contentDescription = MyStrings.EDIT_CATEGORY
                )
            }
            Text(
                modifier = Modifier
                    .padding(top = 7.dp, start = 7.dp)
                    .weight(1f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1, text = categoryItem.categoryName
            )

            IconButton(onClick = { onClickDelete(categoryItem) }) {
                Icon(
                    tint = Red220,
                    imageVector = Icons.Default.Delete,
                    contentDescription = MyStrings.DELETE_CATEGORY
                )
            }
        }

    }

}