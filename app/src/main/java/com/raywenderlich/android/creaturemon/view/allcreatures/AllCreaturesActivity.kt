package com.raywenderlich.android.creaturemon.view.allcreatures

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import com.raywenderlich.android.creaturemon.R
import com.raywenderlich.android.creaturemon.presenter.AllCreatureContract
import com.raywenderlich.android.creaturemon.presenter.AllCreaturePresenter
import com.raywenderlich.android.creaturemon.view.creature.CreatureActivity
import kotlinx.android.synthetic.main.activity_all_creatures.*
import kotlinx.android.synthetic.main.content_all_creatures.*

class AllCreaturesActivity : AppCompatActivity(),AllCreatureContract.View {

  private val adapter = CreatureAdapter(mutableListOf())
  private lateinit var presenter :AllCreaturePresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_all_creatures)
    setSupportActionBar(toolbar)

    presenter = AllCreaturePresenter()
    presenter.setView(this)

    presenter.getAllCreatures().observe(this, Observer{
      adapter.updateCreatures(it)
    })

    creaturesRecyclerView.layoutManager = LinearLayoutManager(this)
    creaturesRecyclerView.adapter = adapter

    fab.setOnClickListener {
      startActivity(Intent(this, CreatureActivity::class.java))
    }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.action_clear_all -> {
        presenter.clearAllCreatures()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }

  override fun showCreaturesCleared() {
    Toast.makeText(this,"cleared",Toast.LENGTH_SHORT).show()
  }
}
