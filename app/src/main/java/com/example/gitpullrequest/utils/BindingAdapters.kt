package com.example.gitpullrequest

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("app:adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>) {
    view.adapter = adapter
}