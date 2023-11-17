package nur.xan.neocafe.clientneocafe.uiClient.auth.sign_up

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import nur.xan.neocafe.clientneocafe.R
import nur.xan.neocafe.clientneocafe.databinding.FragmentAuthBinding
import nur.xan.neocafe.clientneocafe.databinding.FragmentConfirmRegisterBinding
import nur.xan.neocafe.clientneocafe.`object`.AuthObj
import nur.xan.neocafe.clientneocafe.`object`.PreferenceUser
import nur.xan.neocafe.clientneocafe.viewModels.BaseViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ConfirmRegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConfirmRegisterFragment : Fragment() {

    private var _binding: FragmentConfirmRegisterBinding? = null

    private val binding get() = _binding!!
    private val viewModel by viewModels<BaseViewModels>()
//    private lateinit var preferencesTOKEN: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentConfirmRegisterBinding.inflate(inflater, container, false)

//        preferencesTOKEN = (activity as AppCompatActivity).getSharedPreferences(
//            PreferenceUser.APP_PREFERENCES,
//            Context.MODE_PRIVATE
//        )

        return binding.root

    }

    @Suppress("DEPRECATION")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Установите фокус на editConf1
        binding.editConf1.requestFocus()

        // Откройте клавиатуру
        val imm = requireContext().getSystemService(InputMethodManager::class.java)
        imm.showSoftInput(binding.editConf1, InputMethodManager.SHOW_IMPLICIT)

        setEditTextListener(binding.editConf1, binding.editConf2)
        setEditTextListener(binding.editConf2, binding.editConf3)
        setEditTextListener(binding.editConf3, binding.editConf4)



        binding.btnNext.setOnClickListener {
            if (binding.editConf1.text.isNotEmpty() && binding.editConf2.text.isNotEmpty() &&
                binding.editConf3.text.isNotEmpty() && binding.editConf4.text.isNotEmpty()){
                val code = "${binding.editConf1}${binding.editConf2}${binding.editConf3}${binding.editConf4}"
//                viewModel.signInLogin(CLIENT_PHONE_AUTH, code)
                viewModel.verifyPhoneNumber(AuthObj.MY_NUMBER, code)
            }

        }


        viewModel.myVerifyPhoneNumber.observe(viewLifecycleOwner){list->
            if (list.isSuccessful){

                Toast.makeText(requireContext(), list.body()?.message.toString(), Toast.LENGTH_SHORT)
                    .show()
//                AuthObj.TOKEN_USER = list.body()?.message.toString()
//                preferencesTOKEN.edit().putString(PreferenceUser.KEY_TOKEN, AuthObj.TOKEN_USER).apply()

//                findNavController().navigate(R.id.action_confirmFragment_to_homeFragment)

            }else{
                Toast.makeText(requireContext(), "Fatal ktn-004", Toast.LENGTH_SHORT)
                    .show()
            }
        }


        binding.editConf4.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                // Закрыть клавиатуру
                val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.editConf4.windowToken, 0)
                // Обработка события "Далее"
                // Например, можно вызвать метод для обработки ввода кода или выполнить другие действия

                return@setOnEditorActionListener true
            }
            false
        }

        binding.btnBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun setEditTextListener(currentEditText: EditText, nextEditText: EditText) {
        currentEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(editable: Editable?) {
                if (editable?.length == 1) {
                    nextEditText.requestFocus()
                } else if (editable?.length == 0) {
                    // Если текст удален, возвращаем фокус на предыдущий EditText
                    nextEditText.clearFocus()
                    currentEditText.requestFocus()
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}