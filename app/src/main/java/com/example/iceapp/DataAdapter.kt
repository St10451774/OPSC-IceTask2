package com.example.iceapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iceapp.databinding.ItemStudentBinding

class DataAdapter : RecyclerView.Adapter<DataAdapter.VH>() {
    private val items = mutableListOf<Student>()

    fun submitList(list: List<Student>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val s = items[position]
        holder.binding.tvName.text = s.name
        holder.binding.tvNumber.text = s.number
    }

    override fun getItemCount() = items.size
}
