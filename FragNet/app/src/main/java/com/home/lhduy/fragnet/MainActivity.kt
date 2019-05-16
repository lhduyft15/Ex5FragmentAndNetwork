package com.home.lhduy.fragnet

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.home.lhduy.fragnet.R
import com.home.lhduy.fragnet.fragment.TopRate
import com.home.lhduy.fragnet.fragment.NowPlaying
import kotlinx.android.synthetic.main.activity_movie_list.*

class MainActivity : AppCompatActivity() {

    private lateinit var toolBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        supportActionBar?.let{toolBar=it}
        toolBar.title = getString(R.string.title_actionBar)

        switchContent(NowPlaying())

        //  change item -> put string to instances bundle
        bottomNavigation.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.nowPlaying -> {
                        toolBar.title = getString(R.string.title_nowPlaying)
                        switchContent(NowPlaying())
                        return true
                    }
                    R.id.topRate -> {
                        toolBar.title = getString(R.string.title_topRate)
                        switchContent(TopRate())
                        return true
                    }
                }
                return false
            }
        })
    }

    private fun switchContent(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameListMovies,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
