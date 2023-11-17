package nur.xan.neocafe.clientneocafe.uiClient.splash

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import nur.xan.neocafe.clientneocafe.R
import nur.xan.neocafe.clientneocafe.databinding.FragmentSplashBinding
import nur.xan.neocafe.clientneocafe.`object`.AuthObj.TOKEN_USER
import nur.xan.neocafe.clientneocafe.`object`.PreferenceUser.APP_PREFERENCES
import nur.xan.neocafe.clientneocafe.`object`.PreferenceUser.KEY_TOKEN

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private lateinit var preferencesTOKEN: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashBinding.inflate(inflater, container, false)

        preferencesTOKEN = (activity as AppCompatActivity).getSharedPreferences(
            APP_PREFERENCES,
            Context.MODE_PRIVATE
        )


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TOKEN_USER = preferencesTOKEN.getString(KEY_TOKEN, "null").toString()

        if (TOKEN_USER != "null"){
            CoroutineScope(Dispatchers.Main).launch {
                delay(2000)
                findNavController().navigate(R.id.action_SplashFragment_to_homeFragment)
            }
        }else{
            CoroutineScope(Dispatchers.Main).launch {
                delay(2000)
                findNavController().navigate(R.id.action_SplashFragment_to_welcomeFragment)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}