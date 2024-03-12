package com.ducnm.bruhmovie.ui.others

import androidx.fragment.app.viewModels
import com.ducnm.bruhmovie.BaseFragment
import com.ducnm.bruhmovie.R
import com.ducnm.bruhmovie.databinding.OtherFragmentBinding

class OtherFragment: BaseFragment<OtherFragmentBinding, OtherViewModel>() {
    override val viewModel by viewModels<OtherViewModel>()

    override val layoutRes = R.layout.other_fragment
}