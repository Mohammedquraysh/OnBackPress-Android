package com.example.onbackpress

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.onbackpress.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var _binding: FragmentFirstBinding
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? { // Inflate the layout for this fragment
       _binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.firstFragment.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }

        binding.buttonsToNavigate.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
        onBackPressed()
    }
     fun onBackPressed(){
         val callBack = object : OnBackPressedCallback(true){
             override fun handleOnBackPressed() {
                 findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
             }

         }
         requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callBack)
     }

}