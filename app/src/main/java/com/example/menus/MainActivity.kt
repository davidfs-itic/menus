package com.example.menus

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var  toolbar :Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val trans=this.supportFragmentManager.beginTransaction()
        trans.replace(R.id.main_fragment,MainFragment())
        trans.commit()


        val menu=findViewById<BottomNavigationView>(R.id.menubottom)
        menu.setOnItemSelectedListener {
            when (it.itemId){
                R.id.botom_props->{
                    val trans=this.supportFragmentManager.beginTransaction()
                    trans.add(R.id.main_fragment,PropertiesFragment())
                    trans.addToBackStack(null)
                    trans.setReorderingAllowed(true)
                    trans.commit()
                    toggle.setDrawerIndicatorEnabled(false);
                    Log.i("mainactivity","Afegit fragment")
                }
                R.id.bottom_home->{
                    val trans=this.supportFragmentManager.beginTransaction()
                    trans.replace(R.id.main_fragment,MainFragment())
                    trans.commit()
                    Log.i("mainactivity","Afegit fragment")
                }
            }
             true
        }


        toolbar=findViewById(R.id.main_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        drawerLayout = findViewById(R.id.main_drawerlayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        var navigationView: NavigationView =findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this::navigationItemSelectedListener)
    }

    private fun navigationItemSelectedListener(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.alt_nav_home -> {
                Toast.makeText(this, "alt_nav_home", Toast.LENGTH_SHORT).show()
            }
            R.id.alt_nav_gallery -> {
                Toast.makeText(this, "alt_nav_gallery", Toast.LENGTH_SHORT).show()
            }
            R.id.alt_nav_slideshow -> {
                Toast.makeText(this, "alt_nav_slideshow", Toast.LENGTH_SHORT).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


    override fun onSupportNavigateUp(): Boolean {
        //this.onBackPressed()
        //return true
        supportFragmentManager.popBackStack()
        if (supportFragmentManager.fragments.size<=2){
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
        return super.onSupportNavigateUp()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_appbar, menu);
        return true;
        //return super.onCreateOptionsMenu(menu)
    }
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (true) {
            var item = menu?.findItem(R.id.appbar_nav_home)
            item?.setEnabled(false)
            Log.i("Toolbaronly_prepareoptionsmenu", item?.title.toString())
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i("onOptionsItemSelected",item.itemId.toString())
        return super.onOptionsItemSelected(item)
    }

}