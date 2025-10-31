package lat.pam.myrecyclerviewdicoding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button // <-- IMPORT Button
import androidx.navigation.fragment.findNavController // <-- IMPORT NavController
import lat.pam.myrecyclerviewdicoding.R

class ShippingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shipping, container, false)
    }

    // PERBARUI FUNGSI INI
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Temukan tombol
        val btnOrder = view.findViewById<Button>(R.id.btnOrderSekarang)

        // 2. Set listener
        btnOrder.setOnClickListener {
            // 3. Navigasi ke SuccessFragment (Screen 8)
            findNavController().navigate(R.id.successFragment)
        }
    }
}