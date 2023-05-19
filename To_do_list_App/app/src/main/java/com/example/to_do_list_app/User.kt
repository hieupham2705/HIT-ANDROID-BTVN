package com.example.to_do_list_app

import android.text.Editable
import com.google.gson.annotations.SerializedName

data class User(
    var id: String? = null,
    val email: String? = null,
    val age: Int = 0,
    val password: String? = null,
    var name: String? = null

)
