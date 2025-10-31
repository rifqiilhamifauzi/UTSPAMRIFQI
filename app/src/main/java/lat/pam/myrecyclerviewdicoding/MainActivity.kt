package lat.pam.myrecyclerviewdicoding // Sesuaikan package Anda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels // Import ini sudah benar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import lat.pam.myrecyclerviewdicoding.R

class MainActivity : AppCompatActivity() {

    // --- PINDAHKAN KE SINI ---
    // Ini harus dideklarasikan di level Class, BUKAN di dalam onCreate
    private val cartViewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Hubungkan ke layout "cangkang"
        setContentView(R.layout.activity_main)

        // 2. Hilangkan ActionBar (karena kita pakai desain baru)
        supportActionBar?.hide()

        // 3. Temukan komponen dari activity_main.xml
        // --- Baris ViewModel dihapus dari sini ---
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // 4. Sambungkan Bottom Nav dengan Nav Controller
        // Ini yang membuat ikon menu bisa diklik untuk pindah fragment
        bottomNavView.setupWithNavController(navController)


        // --- Blok listener Anda (sudah benar, biarkan saja) ---
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Cek ID halaman tujuan
            when (destination.id) {
                // Jika tujuannya 3 menu utama, TAMPILKAN menu bawah
                R.id.homeFragment,
                R.id.orderFragment,
                R.id.profileFragment -> {
                    bottomNavView.visibility = View.VISIBLE
                }

                // Jika tujuannya halaman lain (Checkout, Shipping, dll), SEMBUNYIKAN
                else -> {
                    bottomNavView.visibility = View.GONE
                }
            }
        }
        // --- BATAS BLOK KODE BARU ---
    }
}