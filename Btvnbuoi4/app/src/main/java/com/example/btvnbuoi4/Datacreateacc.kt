package com.example.btvnbuoi4

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Datacreateacc(
    var username : String ="" ,
    var email : String ="",
    var pass : String ="",
    var cfpass : String =""
): Parcelable
