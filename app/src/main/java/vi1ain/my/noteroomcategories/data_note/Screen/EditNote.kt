package vi1ain.my.noteroomcategories.data_note.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import vi1ain.my.noteroomcategories.MyViewModel
import vi1ain.my.noteroomcategories.ui.theme.Green220
import vi1ain.my.noteroomcategories.ui.theme.MediumGreen220
import vi1ain.my.noteroomcategories.ui.theme.MyStrings
import vi1ain.my.noteroomcategories.ui.theme.While220


@Composable
fun EditNote(myViewModel: MyViewModel, navController: NavHostController,) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MediumGreen220)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(7.dp)
                .background(While220),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .background(While220)
                        .fillMaxWidth()
                ) {
                    TextField(
                        modifier = Modifier.weight(1f),
                        label = { Text(text = MyStrings.TITLE) },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = While220,
                            unfocusedContainerColor = While220,
                            disabledContainerColor = While220,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Green220,
                        ),
                        singleLine = true,
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        value = myViewModel.titleState,
                        onValueChange = { text -> myViewModel.titleState = text })
                    IconButton(onClick = { myViewModel.insertNote()
                        navController.popBackStack()
                    }) {
                        Icon(
                            Icons.Default.Check,
                            contentDescription = "Save", tint = Green220
                        )
                    }
                }
                TextField(modifier = Modifier.fillMaxSize(),
                    label = { Text(text = MyStrings.DESCRIPTION, fontSize = 14.sp) },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = While220,
                        unfocusedContainerColor = While220,
                        disabledContainerColor = While220,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ), textStyle = TextStyle(
                        fontSize = 14.sp,

                        ),
                    value = myViewModel.descriptionState,
                    onValueChange = { text -> myViewModel.descriptionState = text })
            }
        }
    }
}