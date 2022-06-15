package health.dept.ecarecameroon.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import health.dept.ecarecameroon.R
import health.dept.ecarecameroon.databinding.FragmentStartBinding
import health.dept.shared.MainActivityModuleNavigation
import health.dept.shared.extensions.navigateToModule

class StartFragment : Fragment(R.layout.fragment_start) {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentStartBinding.bind(view)

        binding.apply {
            doctorSignup.setOnClickListener {
                navigateToModule(destination = MainActivityModuleNavigation.NavigateToDoctorSignup)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}