package com.example.bookview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var arrayItem : ArrayList<Model> = ArrayList()

        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_TWO , "view 2" , R.drawable.rectangle))

      //  Log.d("item" , arrayItem[0].text)

        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_TWO , "view 2" , R.drawable.rectangle))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_TWO , "view 2" , R.drawable.rectangle))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_TWO , "view 2", R.drawable.rectangle))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_ONE , "view 1", R.drawable.image1))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_ONE , "view 1", R.drawable.image1))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_ONE , "view 1", R.drawable.image1))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_ONE , "view 1", R.drawable.image1))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_THREE , "view 3", R.drawable.image3))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_THREE , "view 3", R.drawable.image3))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_THREE , "view 3", R.drawable.image3))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_THREE , "view 3", R.drawable.image3))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_THREE , "view 3", R.drawable.image3))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_THREE , "view 3", R.drawable.image3))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_THREE , "view 3", R.drawable.image3))
        arrayItem.add(Model(CustomAdapter.VIEW_TYPE_THREE , "view 3", R.drawable.image3))

        val adapter : CustomAdapter = CustomAdapter(arrayItem)

        val recyclerView : RecyclerView = findViewById(R.id.recycler1)

        var arrayItem1 : ArrayList<Model> = ArrayList()
        var arrayItem2 : ArrayList<Model> = ArrayList()
        var arrayItem3 = ArrayList<Model>()

      /*  for(i in 0 until arrayItem.size)
        {
            when (arrayItem[i].viewType) {
                1 -> {
                    arrayItem1.add(arrayItem[i])

                }
                else -> {
                    arrayItem2.add(arrayItem[i])
                }
            }

        }*/

        arrayItem.forEach {
            when(it.viewType)
            {
                1 -> arrayItem1.add(it)
                2 -> arrayItem2.add(it)
                3 -> arrayItem3.add(it)
                else -> arrayItem1.add(it)
            }
        }


        recyclerView.layoutManager = LinearLayoutManager(this)

        val arrayParent : ArrayList<ParentModel> = ArrayList()

        arrayParent.add(ParentModel("Favourites" , arrayItem1))
        arrayParent.add(ParentModel("Recent" , arrayItem2))
        arrayParent.add(ParentModel("Health and Wellness" , arrayItem3))

        val parentAdapter : ParentCustomAdapter = ParentCustomAdapter(arrayParent)

        recyclerView.adapter = parentAdapter




    }
}