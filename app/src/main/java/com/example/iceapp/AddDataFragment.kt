package com.example.iceapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.iceapp.databinding.FragmentAddDataBinding

class AddDataFragment : Fragment() {
    private var _binding: FragmentAddDataBinding? = null
    private val binding get() = _binding!!
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAddDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dbHelper = DatabaseHelper(requireContext())
        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val number = binding.etNumber.text.toString().trim()
            if (name.isEmpty() || number.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val id = dbHelper.insertStudent(name, number)
            if (id > 0) {
                Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_add_to_view)
            } else {
                Toast.makeText(requireContext(), "Save failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
