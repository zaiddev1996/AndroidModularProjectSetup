package health.dept.shared

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions

fun navigate(
    navController: NavController,
    navDirections: NavDirections,
    builder: NavOptions.Builder? = null
) {
    navController.navigate(navDirections, builder?.build())
}