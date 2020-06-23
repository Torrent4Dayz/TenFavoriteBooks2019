package com.dicoding.picodiploma.tenfavoritebooks2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBook: RecyclerView
    private var list: ArrayList<Book> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBook = findViewById(R.id.rv_heroes)
        rvBook.setHasFixedSize(true)

        list.addAll(BookData.listData)
        showRecyclerList()
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

    private fun setMode(selectedMode: Int){
        when (selectedMode){
            R.id.action_list ->{
                showRecyclerList()
            }

            R.id.action_grid ->{
                showRecyclerGrid()
            }

            R.id.action_cardview ->{}
        }
    }


}