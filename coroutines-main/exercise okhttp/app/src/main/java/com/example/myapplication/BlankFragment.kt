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

    ): View {

        binding = FragmentBlankBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {

            val number = binding.edittext.text.toString().toIntOrNull()
            viewLifecycleOwner.lifecycleScope.launch {
                addNumber(number)
            }
            binding.edittext.text.clear()
        }
    }

    private suspend fun addNumber(number: Int?) {
        val result = number?.plus(1) ?: binding.textview.text.toString().toIntOrNull()?.plus(1)
        binding.textview.text = result?.toString()
        delay(2000)
    }
}


