package com.udacity.shoestore.shoe_list


import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel(), Observable {

    private val propChangeReg = PropertyChangeRegistry()

    private val shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())


    @Bindable
    var shoe = Shoe()
        set(value) {
            if(value != field) {
                field = value
                propChangeReg.notifyChange(this, BR.shoe)
            }
        }



    fun getShoeLiveData(): LiveData<MutableList<Shoe>> = shoes

    fun addShoes(item: Shoe?) {
        item?.let {
            shoes.value?.add(item)
        }
    }




    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propChangeReg.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propChangeReg.remove(callback)
    }


}