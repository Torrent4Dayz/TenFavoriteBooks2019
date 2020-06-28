package com.dicoding.picodiploma.tenfavoritebooks2019

import android.content.Intent
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row_hero.*

class MainActivity : AppCompatActivity() {
    private lateinit var rvBook: RecyclerView
    private var list: ArrayList<Book> = arrayListOf()
    private var title: String = "Top 2019 Books I read"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvBook = findViewById(R.id.rv_heroes)
        rvBook.setHasFixedSize(true)

        list.addAll(BookData.listData)
        showRecyclerList()

        val btnMoveWithDataActivity: Button = findViewById(R.id.img_item_photo)
        btnMoveWithDataActivity.setOnClickListener(this)
    }
    override fun onCLick(v: View) {
        when (v.id){
            R.id.btn_detail -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)

            }
            R.id.btn_detail -> {

            }
        }
    }

    private fun showRecyclerList(){
        rvBook.layoutManager = LinearLayoutManager(this)
        val listBookAdapter = ListBookAdapter(list)
        rvBook.adapter = listBookAdapter
    }
    private fun showRecyclerGrid() {
        rvBook.layoutManager = GridLayoutManager(this,2)
        val gridBookAdapter = GridBookAdapter(list)
        rvBook.adapter = gridBookAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun showRecyclerCardView() {
        rvBook.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = CardViewBookAdapter(list)
        rvBook.adapter = cardViewHeroAdapter
    }

    private fun setActionBarTitle(title: String){
        if (supportActionBar != null){
            (supportActionBar as ActionBar).title = title
        }
    }
    private fun showProfile(){
        setContentView(R.layout.activity_profile)
        setActionBarTitle("Profile")

    }
    private fun setMode(selectedMode: Int){
        when (selectedMode){
            R.id.action_list ->{
                showRecyclerList()
            }

            R.id.action_grid ->{
                showRecyclerGrid()
            }

            R.id.action_cardview ->{
                showRecyclerCardView()
            }
            R.id.about ->{
                showProfile()
            }
        }
        setActionBarTitle(title)
    }


}