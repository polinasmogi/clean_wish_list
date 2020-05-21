package com.polinasmogi.cleanwishlist.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.polinasmogi.cleanwishlist.R
import com.polinasmogi.cleanwishlist.presentation.adapter.WishesAdapter
import com.polinasmogi.cleanwishlist.presentation.viewmodel.WishViewModel
import kotlinx.android.synthetic.main.fragment_wish_list.*
import kotlinx.android.synthetic.main.fragment_wish_list.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class WishesFragment : Fragment() {

    private val viewModel: WishViewModel by viewModel()
    private lateinit var adapter: WishesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wish_list, container, false)

        adapter = WishesAdapter(viewModel)
        view.wish_list.adapter = adapter

        view.add_wish_fab.setOnClickListener {
            fragmentManager.let {
                CreateWishFragment.newInstance()
                    .show(it, CreateWishFragment.TAG)
            }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.wishes.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
            no_wishes_icon.isVisible = it.isEmpty()
            no_wishes_text.isVisible = it.isEmpty()
        })

    }

}