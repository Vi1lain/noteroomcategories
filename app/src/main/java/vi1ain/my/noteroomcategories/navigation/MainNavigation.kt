package vi1ain.my.noteroomcategories.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import vi1ain.my.noteroomcategories.MyViewModel
import vi1ain.my.noteroomcategories.data_categories.Screen.CategoriesScreen
import vi1ain.my.noteroomcategories.data_note.Screen.EditNote
import vi1ain.my.noteroomcategories.data_note.Screen.NoteScreen

@Composable
fun MainNavigation(myViewModel: MyViewModel = viewModel(factory = MyViewModel.factory)) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.LIST_CATEGORIES) {
        composable(route = Route.LIST_CATEGORIES) {
            CategoriesScreen(
                myViewModel = myViewModel,
                navController = navController
            )
        }
        composable(
            route = "${Route.LIST_NOTES}/{categoryItem.id}",
            arguments = listOf(navArgument("categoryItem.id") { type = NavType.IntType })
        ) { backStackEntry ->
            NoteScreen(
                backStackEntry.arguments?.getInt("categoryItem.id") ?: -1,
                navController = navController,
                myViewModel = myViewModel
            )
        }
        composable(route = Route.EDIT_NOTE) { EditNote(navController = navController,myViewModel= myViewModel) }
    }

}