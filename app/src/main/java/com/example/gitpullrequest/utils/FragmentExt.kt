package com.example.gitpullrequest

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

fun <T> Fragment.observe(liveData: LiveData<T>, result: (T) -> Unit) {
    liveData.observe(this.viewLifecycleOwner) {
        if(it != null) result.invoke(it)
    }
}