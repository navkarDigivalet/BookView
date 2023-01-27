package com.example.bookview

data class Model(val viewType : Int, val text : String , val image : Int)

data class ParentModel(val name : String , val arrayList: ArrayList<Model> )