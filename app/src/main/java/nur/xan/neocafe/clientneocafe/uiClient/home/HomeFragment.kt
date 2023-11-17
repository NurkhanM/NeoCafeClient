package nur.xan.neocafe.clientneocafe.uiClient.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nur.xan.neocafe.clientneocafe.databinding.ActivityMainBinding
import nur.xan.neocafe.clientneocafe.databinding.FragmentHomeBinding
import nur.xan.neocafe.clientneocafe.main.MainActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private var activityBinding: ActivityMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityBinding = (requireActivity() as? MainActivity)?.binding
        activityBinding?.bottomAppBar?.visibility = View.VISIBLE

//        binding.btnNext.setOnClickListener {
//            findNavController().navigate(R.id.action_welcomeFragment_to_AuthFragment)
//        }
//
//        binding.btnNext2.setOnClickListener {
//            findNavController().navigate(R.id.action_welcomeFragment_to_oneRegisterFragment)
//        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        activityBinding = null
    }

}