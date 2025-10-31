package lat.pam.myrecyclerviewdicoding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels // <-- IMPORT PENTING
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lat.pam.myrecyclerviewdicoding.R

class OrderFragment : Fragment() {

    // 1. Ambil ViewModel yang sama dari MainActivity
    private val cartViewModel: CartViewModel by activityViewModels()

    // Kita pakai adapter yang sama dengan Home (ListHeroAdapter)
    private lateinit var cartAdapter: ListHeroAdapter
    private lateinit var rvCart: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Hubungkan ke layout fragment_order.xml
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Nama Pengguna (dari SharedPreferences)
        val tvHaloUser = view.findViewById<TextView>(R.id.tv_halo_user_order)
        val prefs = requireActivity().getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE)
        var userName = prefs.getString("USER_NAME", "Nazwa")
        if (userName.isNullOrEmpty()) { userName = "Nazwa" }
        tvHaloUser.text = "Halo $userName,"

        // Setup RecyclerView
        rvCart = view.findViewById(R.id.rv_cart)
        rvCart.layoutManager = LinearLayoutManager(requireContext())

        // 2. Ambil data dari ViewModel
        val cartItems = cartViewModel.getCartItems()

        // 3. Buat adapter BARU dengan data keranjang
        cartAdapter = ListHeroAdapter(cartItems)
        rvCart.adapter = cartAdapter

        // Setup Tombol Checkout
        val btnCheckout = view.findViewById<Button>(R.id.btnCheckout)
        btnCheckout.setOnClickListener {
            // Pindah ke Halaman Shipping (Screen 7)
            findNavController().navigate(R.id.shippingFragment)
        }
    }
}