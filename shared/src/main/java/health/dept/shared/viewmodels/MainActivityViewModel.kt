package health.dept.shared.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavOptions
import health.dept.shared.MainActivityModuleNavigation
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val _activityEvents = MutableSharedFlow<MainActivityEvent>()
    val activityEvents = _activityEvents.asSharedFlow()

    fun navigate(
        module: MainActivityModuleNavigation,
        navOptions: NavOptions.Builder?
    ) = viewModelScope.launch {
        _activityEvents.emit(
            MainActivityEvent.NavigateToModule(module, navOptions)
        )
    }

    sealed class MainActivityEvent {
        data class NavigateToModule(
            val module: MainActivityModuleNavigation,
            val navOptions: NavOptions.Builder?
        ) : MainActivityEvent()
    }
}