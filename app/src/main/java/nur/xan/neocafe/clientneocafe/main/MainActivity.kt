package nur.xan.neocafe.clientneocafe.main

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import nur.xan.neocafe.clientneocafe.R
import nur.xan.neocafe.clientneocafe.databinding.ActivityMainBinding

// part test

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        binding.bottomNavigationView.setupWithNavController(navController)
        binding.bottomNavigationView.background = null

    }

    override fun onBackPressed() {
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        if (
            navController.currentDestination!!.id == R.id.basketFragment ||
            navController.currentDestination!!.id == R.id.locationFragment ||
            navController.currentDestination!!.id == R.id.profileFragment
        ) {
            navController.navigate(R.id.homeFragment)
        } else {
            if (navController.currentDestination!!.id != R.id.homeFragment) {
                super.onBackPressed()
            } else {
                val startMain = Intent(Intent.ACTION_MAIN)
                startMain.addCategory(Intent.CATEGORY_HOME)
                startMain.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(startMain)
            }
        }
    }

}