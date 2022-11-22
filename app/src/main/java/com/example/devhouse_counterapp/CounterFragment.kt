package com.example.devhouse_counterapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.devhouse_counterapp.databinding.FragmentCounterBinding


class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_counter, container, false)


        val args = CounterFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "Full name: ${args.nameFirst} ${args.nameSecond}", Toast.LENGTH_SHORT).show()
        var counter = args.counterAmount
        binding.tvCounterNumber.text = counter.toString()
        binding.btnCounter.setOnClickListener{
            counter++
            binding.tvCounterNumber.text = counter.toString()
        }

        binding.btnFinish.setOnClickListener{ view: View ->
            view.findNavController().navigate(CounterFragmentDirections.actionCounterFragmentToProfileFragment(args.nameFirst, args.nameSecond, counter, args.gayPhoto))
        }





        return binding.root
    }
}