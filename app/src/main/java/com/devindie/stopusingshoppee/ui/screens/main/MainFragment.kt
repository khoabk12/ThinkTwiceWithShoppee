package com.devindie.stopusingshoppee.ui.screens.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.devindie.stopusingshoppee.databinding.FragmentMainBinding
import com.devindie.stopusingshoppee.distractiongame.a2048html.Game2048Activity
import com.devindie.stopusingshoppee.distractiongame.twozerogame.MainActivity
import com.devindie.stopusingshoppee.ui.screens.base.BaseFragment

class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override val viewModel: MainViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMainBinding
        get() = FragmentMainBinding::inflate

    override fun setupViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.appCompatToggleButton.setOnClickListener {
//            startActivity(Intent(requireContext(), Game2048Activity::class.java))
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

    }


}