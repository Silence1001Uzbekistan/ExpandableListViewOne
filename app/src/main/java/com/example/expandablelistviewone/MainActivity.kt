package com.example.expandablelistviewone

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.expandablelistviewone.adapter.ExpandableAdapter
import com.example.expandablelistviewone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var map: HashMap<String, List<String>>
    lateinit var titleList: ArrayList<String>

    lateinit var expandableAdapter: ExpandableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        expandableAdapter = ExpandableAdapter(titleList, map)
        binding.expandableListViewId.setAdapter(expandableAdapter)

        binding.expandableListViewId.setOnGroupExpandListener {
            Toast.makeText(this, "Open $it", Toast.LENGTH_SHORT).show()
        }

        binding.expandableListViewId.setOnGroupCollapseListener {
            Toast.makeText(this, "Close $it", Toast.LENGTH_SHORT).show()
        }

        binding.expandableListViewId.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->

            Toast.makeText(
                this,
                map[titleList[groupPosition]]!![childPosition],
                Toast.LENGTH_SHORT
            ).show()
            true
        }

    }

    private fun loadData() {

        map = HashMap()

        var spainList = arrayListOf("Real Madrid", "Barcelona", "Atletico")
        map["Spain"] = spainList

        var englangList = arrayListOf("Manchestr United", "Arsenal", "Chelsea")
        map["England"] = englangList

        var italyList = arrayListOf("Yuventis", "Napoli", "Milan")
        map["Italy"] = italyList


        titleList = ArrayList()

        titleList.add("Spain")
        titleList.add("England")
        titleList.add("Italy")

    }
}