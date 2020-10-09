package com.goga133.task5_7.ui.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Автор: Романюк Андерей\nГруппа: БПИ-194\nДата: 09.10.2020"
    }
    val text: LiveData<String> = _text
}