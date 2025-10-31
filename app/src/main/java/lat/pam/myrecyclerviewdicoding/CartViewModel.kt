package lat.pam.myrecyclerviewdicoding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// 'Hero' adalah data class Makanan Anda
class CartViewModel : ViewModel() {

    // '_cart' adalah daftar pribadi yang bisa kita ubah (Mutable)
    // 'cart' adalah daftar publik yang hanya bisa DIBACA oleh halaman lain (LiveData)
    private val _cart = MutableLiveData<ArrayList<Hero>>()
    val cart: LiveData<ArrayList<Hero>> get() = _cart

    // Inisialisasi keranjang agar tidak null
    init {
        _cart.value = ArrayList()
    }

    // Fungsi untuk MENAMBAH item ke keranjang
    fun addToCart(food: Hero) {
        val currentCart = _cart.value ?: ArrayList() // Ambil keranjang saat ini
        currentCart.add(food) // Tambahkan makanan baru
        _cart.value = currentCart // Setel LiveData agar halaman lain tahu ada update
    }

    // Fungsi untuk MENDAPATKAN semua item di keranjang
    fun getCartItems(): ArrayList<Hero> {
        return _cart.value ?: ArrayList()
    }

    // TODO: Nanti kita tambahkan fungsi removeCart(food: Hero)
}