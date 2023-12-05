package vi1ain.my.noteroomcategories.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import vi1ain.my.noteroomcategories.data_categories.CategoryViewModel
import vi1ain.my.noteroomcategories.data_categories.Screen.CategoriesScreen
import vi1ain.my.noteroomcategories.data_note.Screen.NoteScreen

@Composable
fun MainNavigation(categoryViewModel: CategoryViewModel = viewModel(factory = CategoryViewModel.factory)) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.LIST_CATEGORIES) {
        composable(route = Route.LIST_CATEGORIES) {
            CategoriesScreen(
                categoryViewModel = categoryViewModel,
                navController = navController
            )
        }
        composable(route = Route.LIST_NOTES) {NoteScreen()}
        //composable(route = Route.EDIT_NOTE) {}
    }

}