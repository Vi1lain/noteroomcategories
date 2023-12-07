package vi1ain.my.noteroomcategories.data_note.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import vi1ain.my.noteroomcategories.MyViewModel
import vi1ain.my.noteroomcategories.data_note.NoteEntity
import vi1ain.my.noteroomcategories.navigation.Route
import vi1ain.my.noteroomcategories.ui.theme.Green220
import vi1ain.my.noteroomcategories.ui.theme.MediumGreen220
import vi1ain.my.noteroomcategories.ui.theme.MyStrings
import vi1ain.my.noteroomcategories.ui.theme.Purple220
import vi1ain.my.noteroomcategories.ui.theme.Red220
import vi1ain.my.noteroomcategories.ui.theme.While220


@Composable
fun CardNoteScreen(
    myViewModel: MyViewModel,
    noteItem: NoteEntity,
    onClickDelete: (NoteEntity) -> Unit,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 5.dp, end = 5.dp)
            .clickable {
                myViewModel.noteCheckItem = noteItem
                myViewModel.titleState = noteItem.title
                myViewModel.descriptionState = noteItem.description
                navController.navigate(Route.EDIT_NOTE)
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(While220)
        ) {
            Checkbox(colors = CheckboxDefaults.colors(
                checkedColor = Purple220,
                checkmarkColor = While220
            ),
                checked = noteItem.isCheck, onCheckedChange = { check ->
                    noteItem.isCheck
                    myViewModel.checkedNote(noteItem.copy(isCheck = check))
                })
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)

            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 7.dp, start = 10.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    text = noteItem.title
                )
                Text(
                    modifier = Modifier
                        .padding(top = 3.dp, start = 10.dp, bottom = 7.dp),

                    fontSize = 14.sp,
                    maxLines = 2,
                    fontWeight = FontWeight.Normal,
                    overflow = TextOverflow.Ellipsis,
                    text = noteItem.description
                )


            }

            IconButton(onClick = { onClickDelete(noteItem) }) {
                Icon(
                    tint = Red220,
                    imageVector = Icons.Default.Delete,
                    contentDescription = MyStrings.DELETE_CATEGORY
                )
            }
        }
    }
}