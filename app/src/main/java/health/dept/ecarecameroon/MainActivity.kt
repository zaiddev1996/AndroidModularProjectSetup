package health.dept.ecarecameroon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import health.dept.navigation.MainActivityNavigation
import health.dept.shared.extensions.repeatWhenStarted
import health.dept.shared.viewmodels.MainActivityViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private val viewModel by viewModels<MainActivityViewModel>()

    @Inject
    lateinit var mainActivityNavigation: MainActivityNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        initObservers()
    }

    private fun initObservers() {
        repeatWhenStarted {
            launch {
                viewModel.activityEvents.collect { event ->
                    when (event) {
                        is MainActivityViewModel.MainActivityEvent.NavigateToModule -> {
                            mainActivityNavigation.navigateToModule(
                                navController = navController,
                                module = event.module,
                                navOptions = event.navOptions
                            )
                        }
                    }
                }
            }
        }
    }
}