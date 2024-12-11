package com.example.menus

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

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

        setSupportActionBar(findViewById(R.id.main_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

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

        return super.onCreateOptionsMenu(menu)
    }
}