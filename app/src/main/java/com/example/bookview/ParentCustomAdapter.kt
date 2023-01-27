package com.example.bookview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ParentCustomAdapter(private val dataset : ArrayList<ParentModel>): RecyclerView.Adapter<ParentCustomAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        val txtParent1: TextView
        val childRecycler : RecyclerView

        init {

            childRecycler = view.findViewById(R.id.child_recycler)
            txtParent1= view.findViewById(R.id.txtParent1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.parentlist,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.txtParent1.text = dataset[position].name

        val childAdapter :CustomAdapter = CustomAdapter(dataset[position].arrayList)

        holder.childRecycler.layoutManager = LinearLayoutManager(holder.childRecycler.context,
            LinearLayoutManager.HORIZONTAL,false)

        holder.childRecycler.adapter = childAdapter

        /*childAdapter.notifyDataSetChanged()*/



    }
}