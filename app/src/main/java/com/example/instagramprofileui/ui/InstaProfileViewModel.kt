package com.example.instagramprofileui.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class InstaProfileViewModel(application: Application): AndroidViewModel(application) {
    private val _tabIndex: MutableLiveData<Int> = MutableLiveData(0)
    val tabIndex: LiveData<Int> = _tabIndex
    val tabs = listOf("Posts", "Reels", "Igtv", "Tags")

    fun updateTabIndexBasedOnSwipe(isSwipeToTheLeft: Boolean){
        _tabIndex.value = when(isSwipeToTheLeft){
            true -> Math.floorMod(_tabIndex.value!!.plus(1), tabs.size)
            false -> Math.floorMod(_tabIndex.value!!.minus(1), tabs.size)
        }
    }

    fun updateTabIndex(i: Int){
        _tabIndex.value = i
    }
}