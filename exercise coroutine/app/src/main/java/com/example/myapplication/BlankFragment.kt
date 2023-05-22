package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.FragmentBlankBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BlankFragment : Fragment() {

    private var _binding: FragmentBlankBinding? = null

    private val binding get() = _binding!!

    private var currentValue: Int? = null

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentBlankBinding.bind(view)

        binding.button.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                val number = addNumber(binding)
                binding.textview.text = number?.toString()
            }
        }
    }

    suspend fun addNumber(binding: FragmentBlankBinding): Int? {
            val number = binding.edittext.text.toString().toIntOrNull()
            delay(2000)
            return number?.plus(1)
        }
    }


