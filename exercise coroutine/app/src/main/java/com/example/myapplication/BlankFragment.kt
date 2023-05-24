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

    private lateinit var binding: FragmentBlankBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = FragmentBlankBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            lifecycleScope.launch {
                binding.textview.text = addNumber().toString()
            }
            binding.edittext.text.clear()
        }
    }

    suspend fun addNumber(): Int? {
        val number = binding.edittext.text.toString().toIntOrNull()
        delay(2000)

        val condition = binding.edittext.text.isNullOrEmpty()
        if (condition) {
            binding.button.setOnClickListener {
                val numberOnTextView = binding.textview.text.toString().toInt()
                binding.textview.text = numberOnTextView.plus(1).toString()
            }
        }
        return number
    }
}


