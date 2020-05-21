package com.polinasmogi.cleanwishlist.presentation.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.polinasmogi.cleanwishlist.R
import com.polinasmogi.cleanwishlist.presentation.viewmodel.WishViewModel
import kotlinx.android.synthetic.main.fragment_create_wish.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateWishFragment : DialogFragment() {

    private val viewModel: WishViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_wish, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        wish_title_input.addTextChangedListener(textWatcher)

        createButton.setOnClickListener {
            viewModel.create(wish_title_input.text.toString(), wish_price_input.text.toString().toDouble())
            dismiss()
        }

        cancelButton.setOnClickListener {
            dismiss()
        }

    }

    override fun onResume() {
        super.onResume()

        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    companion object {
        const val TAG = "CreateTaskFragment"

        fun newInstance() : CreateWishFragment {
            return CreateWishFragment()
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            createButton.isEnabled = s!!.isNotBlank()
        }

    }


}