package health.dept.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import health.dept.shared.MainActivityModuleNavigation

interface MainActivityNavigation {
    fun navigateToModule(
        navController: NavController,
        module: MainActivityModuleNavigation,
        navOptions: NavOptions.Builder?
    )
}