package com.example.devhouse_counterapp

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.devhouse_counterapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    private lateinit var binding: FragmentMainBinding
    lateinit var gay: Uri

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        binding.btnGonext.setOnClickListener{ view: View ->
            view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToCounterFragment(binding.etFirstName.text.toString(),  binding.etLastName.text.toString(), 0, gay))
        }

        binding.btnChooseAvatar.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK)
            intent.setType("image/*")
            startActivityForResult(intent, IMAGE_REQUEST_CODE)
        }






        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            gay = data?.data!!
        }
    }

}