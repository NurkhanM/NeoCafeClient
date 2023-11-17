package nur.xan.neocafe.clientneocafe.uiClient.auth.sign_in

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import nur.xan.neocafe.clientneocafe.R
import nur.xan.neocafe.clientneocafe.databinding.FragmentAuthBinding
import nur.xan.neocafe.clientneocafe.`object`.AuthObj.MY_NUMBER
import nur.xan.neocafe.clientneocafe.viewModels.BaseViewModels

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AuthFragment : Fragment() {

    private var _binding: FragmentAuthBinding? = null
    private val viewModel by viewModels<BaseViewModels>()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root

    }

    @Suppress("DEPRECATION")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        binding.btnNext.setOnClickListener {
//            val number = "${binding.authEditPhone.selectedCountryDialCode}${binding.authEditPhone.text.toString()}"
//            CLIENT_PHONE_AUTH = number
//            viewModel.sendCodeLogin(number)


            viewModel.sendCodeLogin(MY_NUMBER)
        }

        fun String.isValidPhone() = isNotEmpty() && android.util.Patterns.PHONE.matcher(this).matches()


        binding.authEditPhone.doOnTextChanged { text, _, _, _ ->
            val count = text?.length ?: 0

            if (count > 10) {
                if (text.toString().isValidPhone()) {

                    binding.btnNext.isEnabled = true
                    binding.btnNext.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(requireContext(), R.color.base)
                    )

                } else {
                    binding.textHelper.text = resources.getText(R.string.enter_email_correctly)
                }
            } else {
                binding.btnNext.isEnabled = false
                binding.btnNext.backgroundTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(requireContext(), R.color.gray)
                )
            }
        }


        viewModel.mySendCodeLogin.observe(viewLifecycleOwner){ list->

            if (list.isSuccessful){

                findNavController().navigate(R.id.action_AuthFragment_to_confirmFragment)
            }else {
                Toast.makeText(requireContext(), "Fatal ktn-003", Toast.LENGTH_SHORT)
                    .show()
                binding.textHelper.visibility = View.VISIBLE
            }

        }

        binding.btnBack.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.titleText.setOnClickListener {
            findNavController().navigate(R.id.action_AuthFragment_to_confirmFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}