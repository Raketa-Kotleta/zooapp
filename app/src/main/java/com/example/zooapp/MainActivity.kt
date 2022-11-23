package com.example.zooapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private var aiAdd: MenuItem? = null
    private var viAdd: MenuItem? = null
    private var ziAdd: MenuItem? = null
    private var iDelete: MenuItem? = null
    private var iChange: MenuItem? = null
    var ZooList: ZooViewModel? = ZooViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ZooList?.add(Zoo(1,"Дикие кошки", 5, "Krasnodar"))
        ZooList?.add(Zoo(2,"Дикие медведи", 4, "Moscow"))
        ZooList?.add(Zoo(3,"Дикие панды", 7, "Kaliningrad"))
        ZooList?.add(Zoo(1,"Дикие кошки", 5, "Krasnodar"))
        ZooList?.add(Zoo(2,"Дикие медведи", 4, "Moscow"))
        Log.i("123213213", ZooList?.zoos?.value?.size.toString());
        if (savedInstanceState == null) {
            val fragment = ZooListFragment();
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_viewer, ZooListFragment.newInstance())
                .commit()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        aiAdd=menu?.findItem(R.id.add_animal)
        viAdd=menu?.findItem(R.id.add_aviary)
        ziAdd=menu?.findItem(R.id.add_zoo)
        iDelete=menu?.findItem(R.id.drop)
        iChange=menu?.findItem(R.id.edit)
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.mvAdd -> {
//                showNestedStudent()
//                true
//            }
//            R.id.mvDelete -> {
//                true
//            }
//            R.id.mvChange -> {
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}