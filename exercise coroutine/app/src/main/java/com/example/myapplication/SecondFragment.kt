package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = listOf(ItemList(R.string.hello, R.drawable.baseline_currency_bitcoin_24), ItemList(R.string.world, R.drawable.baseline_euro_24),
            ItemList(R.string.banana, R.drawable.baseline_euro_24), ItemList(R.string.strawberry, R.drawable.baseline_euro_24), ItemList(R.string.apple,R.drawable.baseline_euro_24), ItemList(R.string.apple,R.drawable.baseline_euro_24), ItemList(R.string.apple, R.drawable.baseline_euro_24) )
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = ListAdapter(list)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}