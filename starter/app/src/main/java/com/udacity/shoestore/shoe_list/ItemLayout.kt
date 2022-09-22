package com.udacity.shoestore.shoe_list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe

class ItemLayout : LinearLayout{
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    private val binding: ShoeItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.shoe_item, this, false)

    fun     setUpItem(shoe: Shoe) {
        binding.apply {
            addView(this.root)

            tvName.text = shoe.name
            tvCompany.text = shoe.company
            tvSize.text = shoe.size
            ivDescription.text = shoe.description

        }
    }


}