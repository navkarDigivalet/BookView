package com.example.bookview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CustomAdapter( private val datalist: ArrayList<Model>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object
    {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
        const val VIEW_TYPE_THREE = 3
    }

    private inner class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var txtItem1 : TextView = itemView.findViewById(R.id.txtItem1)
        var img1 : ImageView = itemView.findViewById(R.id.img1)
        fun bind(position: Int)
        {
            val arrayItem = datalist[position]
            txtItem1.text = arrayItem.text
            img1.setImageResource(arrayItem.image)
        }
    }


    private inner class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var txtItem2 : TextView = itemView.findViewById(R.id.txtItem2)
        var img2 : ImageView = itemView.findViewById(R.id.img2)
        fun bind(position: Int)
        {
            val arrayItem = datalist[position]
            txtItem2.text = arrayItem.text
            img2.setImageResource(arrayItem.image)
        }
    }

    private inner class ViewHolder3(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var txtItem3 : TextView = itemView.findViewById(R.id.txtItem3)
        var img3 : ImageView = itemView.findViewById(R.id.img3)
        fun bind(position: Int)
        {
            val arrayItem = datalist[position]
            txtItem3.text = arrayItem.text
            img3.setImageResource(arrayItem.image)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ONE -> {
                val itemView :View =  LayoutInflater.from(parent.context).inflate(R.layout.item1,parent,false)
                ViewHolder1(itemView)
            }
            VIEW_TYPE_TWO -> {
                val itemView :View =  LayoutInflater.from(parent.context).inflate(R.layout.item2,parent,false)
                ViewHolder2(itemView)
            }
            VIEW_TYPE_THREE -> {
                val itemView :View =  LayoutInflater.from(parent.context).inflate(R.layout.item3,parent,false)
                ViewHolder3(itemView)
            }
            else -> {
                val itemView :View =  LayoutInflater.from(parent.context).inflate(R.layout.item1,parent,false)
                ViewHolder1(itemView)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when (datalist[position].viewType) {
            VIEW_TYPE_ONE -> {
                (holder as ViewHolder1).bind(position)
            }
            VIEW_TYPE_TWO -> {
                (holder as ViewHolder2).bind(position)
            }
            VIEW_TYPE_THREE -> {
                (holder as ViewHolder3).bind(position)
            }
            else -> {
                (holder as ViewHolder1).bind(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun getItemViewType(position: Int): Int {
        return datalist[position].viewType
    }


}