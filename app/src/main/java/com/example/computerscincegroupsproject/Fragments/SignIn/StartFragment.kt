package com.example.computerscincegroupsproject.Fragments.SignIn

import androidx.navigation.Navigation.findNavController
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import com.example.computerscincegroupsproject.R
import com.example.computerscincegroupsproject.databinding.StartFragmentBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class StartFragment : Fragment() {
    private var binding: StartFragmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = StartFragmentBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed(
            { findNavController(requireView()).navigate(R.id.action_StartFragment_to_mainActivity) },
            2000
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}