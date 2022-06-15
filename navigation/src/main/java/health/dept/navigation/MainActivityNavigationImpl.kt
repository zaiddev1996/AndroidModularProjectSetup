package health.dept.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import health.dept.shared.MainActivityModuleNavigation
import health.dept.shared.navigate

class MainActivityNavigationImpl : MainActivityNavigation {
    override fun navigateToModule(
        navController: NavController,
        module: MainActivityModuleNavigation,
        navOptions: NavOptions.Builder?
    ) {
        when (module) {
            is MainActivityModuleNavigation.NavigateToDoctorSignup -> {
                navigate(navController, MainActivityNavigationDirections.actionToDoctorSignup())
            }
        }
    }
}