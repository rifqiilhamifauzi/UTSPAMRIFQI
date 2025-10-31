package lat.pam.myrecyclerviewdicoding

import android.content.Context // <-- IMPORT INI
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import lat.pam.myrecyclerviewdicoding.R

class CheckoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- TAMBAHKAN KODE UNTUK NAMA DI SINI ---

        // 1. Temukan TextView "Halo" (ID dari fragment_checkout.xml)
        val tvHaloUser = view.findViewById<TextView>(R.id.tv_halo_nazwa)

        // 2. Baca nama dari SharedPreferences
        val prefs = requireActivity().getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE)
        val userName = prefs.getString("USER_NAME", "Nazwa") // "Nazwa" adalah default

        // 3. Set teks-nya
        tvHaloUser.text = "Halo $userName,"

        // --- (Kode Anda yang sudah ada untuk menampilkan data makanan) ---

        val tvNamaMakanan = view.findViewById<TextView>(R.id.tv_nama_makanan)
        val tvDeskripsi = view.findViewById<TextView>(R.id.tv_lokasi)

        val food = if (Build.VERSION.SDK_INT >= 33) {
            arguments?.getParcelable("EXTRA_FOOD", Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getParcelable("EXTRA_FOOD")
        }

        if (food != null) {
            tvNamaMakanan.text = food.name
            tvDeskripsi.text = food.description
        }

        // --- (Logika tombol 'Kirim' Anda yang sudah ada) ---
        val btnKirim = view.findViewById<Button>(R.id.btnKirim)
        btnKirim.setOnClickListener {
            findNavController().navigate(R.id.shippingFragment)
        }
    }
}