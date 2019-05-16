package  com.home.lhduy.fragnet.movieModel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val title : String,
    val poster_path : String,
    val video : Boolean,
    val release_date : String,
    val overview : String,
    val vote_average : Float
): Parcelable
