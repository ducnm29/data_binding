package com.ducnm.bruhmovie.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.ducnm.bruhmovie.model.Movie

class MovieListAdapter(
    private val onClick: (View, String) -> Unit
) : Adapter<MovieViewHolder>() {

    private lateinit var listItem: List<Movie>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.createView(viewGroup = parent, onCLick = onClick)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        if (listItem.size > position) {
            holder.bindData(listItem[position])
        }
    }

    fun updateMovieList(listItem: List<Movie>) {
        this.listItem = listItem
    }

}