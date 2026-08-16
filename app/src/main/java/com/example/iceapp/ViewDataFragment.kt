package com.example.iceapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iceapp.databinding.FragmentViewDataBinding

class ViewDataFragment : Fragment() {
    private var _binding: FragmentViewDataBinding? = null
    private val binding get() = _binding!!
    private lateinit var dbHelper: DatabaseHelper
    private lateinit var adapter: DataAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentViewDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dbHelper = DatabaseHelper(requireContext())
        adapter = DataAdapter()
        binding.recyclerData.adapter = adapter
        loadData()
    }

    private fun loadData() {
        val list = dbHelper.getAllStudents()
        adapter.submitList(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
