package vi1ain.my.noteroomcategories.data_note.Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import vi1ain.my.noteroomcategories.MyViewModel
import vi1ain.my.noteroomcategories.ui.theme.LightGreen220
import vi1ain.my.noteroomcategories.ui.theme.MyStrings
import vi1ain.my.noteroomcategories.ui.theme.Silver220
import vi1ain.my.noteroomcategories.ui.theme.While220


@Composable
fun DialogController(
    myViewModel: MyViewModel,
    onDismissRequest: () -> Unit,
    dismissButton: () -> Unit,
    confirmButton: () -> Unit
) {
    AlertDialog(containerColor = LightGreen220,
        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = MyStrings.ADD_ITEM)
                TextField(
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = While220,
                        unfocusedContainerColor = While220,
                        disabledContainerColor = While220,
                    ),
                    maxLines= 3,
                    label = { Text(color = Silver220, text = MyStrings.TITLE) },
                    value = myViewModel.titleState,
                    onValueChange = { text -> myViewModel.titleState = text })
                TextField(
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = While220,
                        unfocusedContainerColor = While220,
                        disabledContainerColor = While220,
                    ),
                    maxLines= 3,
                    label = { Text(color = Silver220, text = MyStrings.DESCRIPTION) },
                    value = myViewModel.descriptionState,
                    onValueChange = { text -> myViewModel.descriptionState = text })
            }
        },
        onDismissRequest = { onDismissRequest() },
        dismissButton = {
            TextButton(onClick = { dismissButton() }) {
                Text(text = MyStrings.BUTTOM_CLOSE)
            }
        },
        confirmButton = {
            TextButton(onClick = { confirmButton() }) {
                Text(text = MyStrings.BUTTOM_OK)
            }
        }
    )


}