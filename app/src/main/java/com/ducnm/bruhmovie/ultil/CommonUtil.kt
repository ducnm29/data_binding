package com.ducnm.bruhmovie.ultil

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

object CommonUtil {
    fun <T> Fragment.flowWithViewLifecycle(
        flow: Flow<T>,
        minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
        block: suspend (T) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            flow.flowWithLifecycle(viewLifecycleOwner.lifecycle, minActiveState)
                .collectLatest { block(it) }
        }
    }

}