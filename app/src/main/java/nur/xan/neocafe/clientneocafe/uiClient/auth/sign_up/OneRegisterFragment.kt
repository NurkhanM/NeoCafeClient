package nur.xan.neocafe.clientneocafe.uiClient.auth.sign_up

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.navigation.fragment.findNavController
import nur.xan.neocafe.clientneocafe.R
import nur.xan.neocafe.clientneocafe.databinding.FragmentOneRegisterBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


/**
 * A simple [Fragment] subclass.
 * Use the [OneRegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OneRegisterFragment : Fragment(),  DatePickerDialog.OnDateSetListener {

    private val calendar = Calendar.getInstance()
    private val formatterBirthday = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    private var _binding: FragmentOneRegisterBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOneRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }

    @Suppress("DEPRECATION")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_oneRegisterFragment_to_twoRegisterFragment)
        }

        binding.btnBack.setOnClickListener {
            activity?.onBackPressed()
        }

        binding.line2.setOnClickListener {
            datePick()
        }

        binding.editDateBirthday.setOnClickListener {
            datePick()
        }


    }

    private fun datePick(){
        DatePickerDialog(
            requireContext(),
            android.R.style.Theme_Holo_Light_Panel,
            this,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(year, month, dayOfMonth)
        displayFormattedDate(calendar.timeInMillis)
    }

    private fun displayFormattedDate(timeInMillis: Long) {
        binding.editDateBirthday.setText(formatterBirthday.format(timeInMillis))
    }
}