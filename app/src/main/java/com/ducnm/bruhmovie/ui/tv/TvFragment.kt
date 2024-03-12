package com.ducnm.bruhmovie.ui.tv

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.ducnm.bruhmovie.BaseFragment
import com.ducnm.bruhmovie.R
import com.ducnm.bruhmovie.databinding.TvFragmentBinding

class TvFragment: BaseFragment<TvFragmentBinding, TvViewModel>() {
    override val viewModel by viewModels<TvViewModel>()
    override val layoutRes = R.layout.tv_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkEvent()
    }

    private fun checkEvent(){
        binding.btnTvBack.setOnClickListener {
            navController.popBackStack()
        }
    }
}