package com.polinasmogi.cleanwishlist.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.polinasmogi.cleanwishlist.domain.entity.Wish
import com.polinasmogi.cleanwishlist.presentation.viewmodel.WishViewModel
import kotlinx.android.synthetic.main.item_wish.view.*

class WishViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(wish: Wish, viewModel: WishViewModel) {
        itemView.wish_title.text = wish.title
        itemView.wish_price.text = wish.price.toString()

        itemView.checkBox.setOnCheckedChangeListener { checkbox, isChecked ->
            checkbox.isChecked = false
            viewModel.delete(wish)
        }
    }

}