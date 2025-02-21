package com.example.deepbot

import android.os.Bundle
import android.transition.Slide
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.deepbot.ui.gallery.GalleyFragment
import com.example.deepbot.ui.home.HomeFragment
import com.example.deepbot.ui.shop.ShopFragment
import com.example.deepbot.ui.calender.CalenderFragment
import com.example.deepbot.ui.notification.NotificationFragment
import com.example.deepbot.ui.slideshow.SlideshowFragment

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up Toolbar
        val toolbar: Toolbar = findViewById(R.id.appBarMain)
        setSupportActionBar(toolbar)

        // Enable the Hamburger Icon (3 bars)
        drawerLayout = findViewById(R.id.drawer_layout)
        toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Force the drawer icon to show
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        // Load HomeFragment by default
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        // Navigation Item Clicks
        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_gallery -> replaceFragment(GalleyFragment())
                R.id.nav_slideshow ->replaceFragment(SlideshowFragment())
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_calender -> replaceFragment(CalenderFragment())
                R.id.nav_set_mood -> replaceFragment(HomeFragment())
                R.id.shopFragmentFragment -> replaceFragment(ShopFragment())

            }
            drawerLayout.closeDrawers() // Close the drawer after selection
            true
        }
    }

    // Inflate the menu (Notification Icon)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    // Handle notification click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_notifications -> {
                replaceFragment(NotificationFragment())  // Navigate to NotificationsFragment
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Function to replace fragments
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
