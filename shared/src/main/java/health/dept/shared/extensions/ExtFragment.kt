package health.dept.shared.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavOptions
import health.dept.shared.MainActivityModuleNavigation
import health.dept.shared.viewmodels.MainActivityViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun Fragment.repeatWhenStarted(block: suspend CoroutineScope.() -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            block()
        }
    }
}

fun Fragment.navigateToModule(
    destination: MainActivityModuleNavigation,
    builder: NavOptions.Builder? = null
) {
    val viewModel by activityViewModels<MainActivityViewModel>()
    viewLifecycleOwner.lifecycleScope.launchWhenStarted {
        viewModel.navigate(destination, builder)
    }
}