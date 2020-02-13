package com.example.exchangeratesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
            when (p0.itemId) {
                R.id.vtbbankItem -> fragmentInstance(1)
                R.id.tbcbankItem -> fragmentInstance(2)
                R.id.procreditbankItem -> fragmentInstance(3)
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            hideImage()
            return true
        }


    val transaction: FragmentTransaction? = null
    var fragmentManager: FragmentManager? = null
    private var mDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setActionBarDrawer()
        navigationReference()

    }

    private fun setActionBarDrawer() {
        mDrawerToggle =
            ActionBarDrawerToggle(this, drawer_layout, toolBar, R.string.open, R.string.close)
        mDrawerToggle!!.syncState()

    }

    private fun navigationReference() {
        val navigationView: NavigationView = navigation_view
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)

        } else if (mainImage.visibility == View.GONE) {
            mainImage.visibility = View.VISIBLE

        } else {
            super.onBackPressed()
        }

    }

    private fun hideImage() {
        if (mainImage.visibility == View.VISIBLE) {
            mainImage.visibility = View.GONE
        }
    }

    private fun fragmentInstance(id: Int) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, BanksFragment.newInstance(id))
        transaction.commit()

    }

}
