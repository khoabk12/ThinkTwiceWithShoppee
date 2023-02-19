package com.devindie.stopusingshoppee.ui.screens.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.devindie.stopusingshoppee.R
import com.devindie.stopusingshoppee.ui.screens.main.MainViewModel

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    abstract val viewModel: T
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

}