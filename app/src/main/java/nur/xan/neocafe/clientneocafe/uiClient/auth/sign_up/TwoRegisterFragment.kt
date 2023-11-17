package nur.xan.neocafe.clientneocafe.uiClient.auth.sign_up

import android.app.Dialog
import android.content.ContentValues.TAG
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.gson.JsonObject
import nur.xan.neocafe.clientneocafe.R
import nur.xan.neocafe.clientneocafe.databinding.FragmentAuthBinding
import nur.xan.neocafe.clientneocafe.databinding.FragmentTwoRegisterBinding
import nur.xan.neocafe.clientneocafe.`object`.FullRegistr.CLIENT_BIRTHDAY
import nur.xan.neocafe.clientneocafe.`object`.FullRegistr.CLIENT_NAME
import nur.xan.neocafe.clientneocafe.`object`.FullRegistr.CLIENT_PHONE
import nur.xan.neocafe.clientneocafe.viewModels.BaseViewModels
import org.json.JSONObject


class TwoRegisterFragment : Fragment() {

    private var _binding: FragmentTwoRegisterBinding? = null
    private val viewModel by viewModels<BaseViewModels>()

    private val binding get() = _binding!!
    lateinit var dialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTwoRegisterBinding.inflate(inflater, container, false)


        dialog = Dialog(requireContext())


        return binding.root

    }

    @Suppress("DEPRECATION")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {


            if (binding.edtName.text.isNotEmpty() && binding.edtPhone.text.isNotEmpty()) {

                CLIENT_NAME = binding.edtName.text.toString()
                CLIENT_PHONE = binding.edtPhone.text.toString()

                if (CLIENT_BIRTHDAY != "null") {

                    val paramObj = JsonObject()
                    paramObj.addProperty(
                        "firstName",
                        CLIENT_NAME.trim()
                    )
                    paramObj.addProperty(
                        "phoneNumber",
                        CLIENT_PHONE.trim()
                    )

                    paramObj.addProperty(
                        "birthDate",
                        CLIENT_BIRTHDAY.trim()

                    )

                    viewModel.postClientRegister(paramObj)

                } else {
                    Toast.makeText(requireContext(), "Fatal ktn-001", Toast.LENGTH_SHORT)
                        .show()
                } // check Client

            } else {
                Toast.makeText(
                    requireContext(),
                    resources.getString(R.string.fill_all_fields),
                    Toast.LENGTH_SHORT
                )
                    .show()
            }


        }

        binding.btnBack.setOnClickListener {
            activity?.onBackPressed()
        }


        viewModel.myClientRegister.observe(viewLifecycleOwner) { list ->
            if (list.isSuccessful) {

                viewModel.sendCodeRegistration(CLIENT_PHONE)

            } else {
//                Toast.makeText(requireContext(), "Fatal ktn-002", Toast.LENGTH_SHORT)
//                    .show()
                val jsonObj = JSONObject(list.errorBody()!!.charStream().readText())
                alertDialogCancel(
                    jsonObj.getString("message").toString(),
                    jsonObj.getString("error").toString().replace("[\"", "").replace("\"]", "")
                )
            }
        }

        viewModel.mySendCodeRegistration.observe(viewLifecycleOwner) { list ->

            if (list.isSuccessful) {

//                alertDialogCancel(
//                    "Message", list.body()?.message.toString()
//                )

                findNavController().navigate(R.id.action_twoRegisterFragment_to_confirmRegisterFragment)

            }else{
//                val jsonObj = JSONObject(list.errorBody()!!.charStream().readText())
//                alertDialogCancel(
//                    jsonObj.getString("message").toString(),
//                    jsonObj.getString("error").toString().replace("[\"", "").replace("\"]", "")
//                )
            }
        }
    }

    private fun alertDialogCancel(title: String, descrip: String) {

        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setContentView(R.layout.dialog_error_auth)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonYES = dialog.findViewById<ImageView>(R.id.dialog_yes)
        val textTitle = dialog.findViewById<TextView>(R.id.txt_title)
        val textDescrip = dialog.findViewById<TextView>(R.id.txt_descript)
        textTitle.text = title
        textDescrip.text = descrip
        buttonYES.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}