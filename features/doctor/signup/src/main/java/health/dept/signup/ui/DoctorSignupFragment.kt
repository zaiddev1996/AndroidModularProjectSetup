package health.dept.signup.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import health.dept.signup.R
import health.dept.signup.databinding.FragmentDoctorSignupBinding

class DoctorSignupFragment : Fragment(R.layout.fragment_doctor_signup) {

    private var _binding: FragmentDoctorSignupBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentDoctorSignupBinding.bind(view)

        binding.apply {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}