package lat.pam.myrecyclerviewdicoding

import android.content.Context // <-- IMPORT INI
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView // <-- IMPORT INI
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import lat.pam.myrecyclerviewdicoding.R

class SuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_success, container, false)
    }

    // PERBARUI FUNGSI INI
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- BAGIAN BARU UNTUK NAMA ---

        // 1. Temukan TextView (ID dari langkah 1)
        val tvGreeting = view.findViewById<TextView>(R.id.tv_user_greeting)

        // 2. Baca nama dari SharedPreferences
        val prefs = requireActivity().getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE)
        val userName = prefs.getString("USER_NAME", "Nazwa") // Default "Nazwa"

        // 3. Set teks-nya (TANPA "Halo")
        tvGreeting.text = "$userName,"

        // --- (Kode Anda yang sudah ada untuk tombol "Main") ---
        val btnMain = view.findViewById<Button>(R.id.btnMain)

        btnMain.setOnClickListener {
            val options = navOptions {
                popUpTo(R.id.homeFragment) {
                    inclusive = true
                }
            }
            findNavController().navigate(R.id.homeFragment, null, options)
        }
    }
}