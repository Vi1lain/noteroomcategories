package vi1ain.my.noteroomcategories.data_note.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import vi1ain.my.noteroomcategories.data_note.NoteEntity
import vi1ain.my.noteroomcategories.ui.theme.MyStrings
import vi1ain.my.noteroomcategories.ui.theme.Red220
import vi1ain.my.noteroomcategories.ui.theme.While220


@Composable
fun CardNoteScreen(noteItem: NoteEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 5.dp, end = 5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(While220)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)

            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 7.dp, start = 7.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    text = noteItem.title
                )
                Text(
                    modifier = Modifier
                        .padding(top = 3.dp, start = 7.dp, bottom = 7.dp),

                    fontSize = 14.sp,
                    maxLines = 2,
                    fontWeight = FontWeight.Normal,
                    overflow = TextOverflow.Ellipsis,
                    text = noteItem.description
                )


            }
            IconButton(onClick = {}) {
                Icon(
                    tint = Red220,
                    imageVector = Icons.Default.Delete,
                    contentDescription = MyStrings.DELETE_CATEGORY
                )
            }
        }
    }
}