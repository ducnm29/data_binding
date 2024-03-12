package com.ducnm.bruhmovie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ducnm.bruhmovie.databinding.MovieItemBinding
import com.ducnm.bruhmovie.model.Movie

class MovieViewHolder(
    private val binding: MovieItemBinding,
    private val onCLick: (View, String) -> Unit
) : ViewHolder(binding.root) {
    fun bindData(movie: Movie) {
        binding.root.setOnClickListener { onCLick(binding.root, movie.id) }

        binding.apply {
            this.movie = movie
            executePendingBindings()
        }
    }

    companion object{
        fun createView(viewGroup: ViewGroup, onCLick: (View, String) -> Unit): MovieViewHolder{
            val layoutInflater = LayoutInflater.from(viewGroup.context)
            val binding =  MovieItemBinding.inflate(layoutInflater, viewGroup, false)
            return MovieViewHolder(binding = binding, onCLick = onCLick)
        }
    }
}