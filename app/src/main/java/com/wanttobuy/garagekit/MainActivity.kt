package com.wanttobuy.garagekit

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.aleyn.mvvm.base.BaseActivity
import com.aleyn.mvvm.base.NoViewModel
import com.wanttobuy.garagekit.databinding.ActivityMainBinding
import com.wanttobuy.garagekit.navigation.KeepStateNavigator

class MainActivity : BaseActivity<NoViewModel, ActivityMainBinding>() {

    lateinit var currentFragment:Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView()

    }

    override fun initData() {

    }

    override fun initView(savedInstanceState: Bundle?) {
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        val navigator =
            KeepStateNavigator(this, navHostFragment!!.childFragmentManager, R.id.nav_host_fragment)
        navController.navigatorProvider.addNavigator(navigator)
        navController.setGraph(R.navigation.mobile_navigation)
        setUpNavBottom(navHostFragment)

//        NavigationUI.setupWithNavController(navView,navController)
//        navView.setOnNavigationItemSelectedListener(object :
//            BottomNavigationView.OnNavigationItemSelectedListener{
//            override fun onNavigationItemSelected(item: MenuItem): Boolean {
//                if(item.isChecked){
//                    return  true
//                }
//                return onNavigationItemSelected(item)
//            }
//
//        })

    }


    private fun setUpNavBottom(hostFragment: NavHostFragment?) {
        //        NavHostFragment hostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragment3);
        val navMenu = findViewById<BottomNavigationView>(R.id.nav_view)
        if (hostFragment != null) {
            val navController = hostFragment.navController
            NavigationUI.setupWithNavController(navMenu, navController)
        }
    }

    override fun layoutId(): Int {
        return R.layout.activity_main
    }
}
