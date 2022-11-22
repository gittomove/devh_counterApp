package com.example.devhouse_counterapp

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.devhouse_counterapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        val args = ProfileFragmentArgs.fromBundle(requireArguments())
        binding.tvFirstName.text = args.firstName
        binding.tvLastName.text = args.lastName
        binding.tvCounterResult.text = args.counterNumber.toString()
        binding.imageView.setImageURI(args.gayPhoto)

        binding.btnCntCounting.setOnClickListener{
            view: View -> view.findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToCounterFragment(args.firstName, args.lastName, args.counterNumber, args.gayPhoto))
        }


        binding.btnGoMainPage.setOnClickListener{
            view: View -> view.findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToMainFragment())
        }
        return binding.root
    }

}