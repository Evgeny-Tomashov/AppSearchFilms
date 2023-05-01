package com.devtomashov.appsearchfilms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.devtomashov.appsearchfilms.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.menu_settings_title),
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                else -> false
            }
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.menu_favorites_title),
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                R.id.watch_later -> {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.menu_watch_later_title),
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                R.id.selections -> {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.menu_selections_title),
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                else -> false
            }
        }
    }
}




