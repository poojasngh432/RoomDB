package com.example.roomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_user.*

class MainActivity : AppCompatActivity() {

    val db by lazy {
        Room.databaseBuilder(this,
            AppDataBase::class.java, "user.db"
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    val name: MutableLiveData<String> = MutableLiveData()
    val list = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = UserAdapter(list)
        db.userDao().getAllUsers().observe(this, Observer {
            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })

        name.observe(this, Observer {
            Log.i("LiveData", "$it")
        })

        setDataBtn.setOnClickListener {
            db.userDao().insertUser(User(enterNewDataET.text.toString(), 15, "Student"))
        }

        userRV.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter
        }
    }
}
