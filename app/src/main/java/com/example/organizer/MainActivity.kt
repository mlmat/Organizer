package com.example.organizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val dataList = ArrayList<DataModel>()
        dataList.add(DataModel(1, "first", "description one"))
        dataList.add(DataModel(2, "second", "description two"))
        dataList.add(DataModel(3, "third", "description three"))
        dataList.add(DataModel(4, "fourth", "description four"))
        dataList.add(DataModel(5, "fifth", "description five"))
        dataList.add(DataModel(6, "sixth", "description six"))
        dataList.add(DataModel(7, "some more", "one more"))
        dataList.add(DataModel(8, "some more", "one more"))
        dataList.add(DataModel(9, "some more", "one more"))
        dataList.add(DataModel(10, "some more", "one more"))
        dataList.add(DataModel(11, "some more", "one more"))
        dataList.add(DataModel(12, "some more", "one more"))
        dataList.add(DataModel(13, "some more", "one more"))

        val rvAdapter = RecyclerViewAdapter(dataList)

        recyclerView.adapter = rvAdapter

    }

    override fun onBackPressed() {

        mAuth.signOut()
        startActivity(
            Intent(
                applicationContext,
                LoginActivity::class.java
            )
        )
    }
}
