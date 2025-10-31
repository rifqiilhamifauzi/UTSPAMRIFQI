package lat.pam.myrecyclerviewdicoding

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val photo: Int // <--- GANTI JADI Int
) : Parcelable
