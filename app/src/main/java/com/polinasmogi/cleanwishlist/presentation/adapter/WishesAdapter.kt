package com.polinasmogi.cleanwishlist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.polinasmogi.cleanwishlist.R
import com.polinasmogi.cleanwishlist.domain.entity.Wish
import com.polinasmogi.cleanwishlist.presentation.viewmodel.WishViewModel

class WishesAdapter(private val viewModel: WishViewModel) :
    androidx.recyclerview.widget.ListAdapter<Wish, WishViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_wish, parent, false)
        return WishViewHolder(view)
    }

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) {
        holder.bind(getItem(position), viewModel)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Wish>() {
            override fun areItemsTheSame(oldWish: Wish, newWish: Wish): Boolean {
                return oldWish.id == newWish.id
            }

            override fun areContentsTheSame(oldWish: Wish, newWish: Wish): Boolean {
                return oldWish == newWish
            }
        }
    }

}