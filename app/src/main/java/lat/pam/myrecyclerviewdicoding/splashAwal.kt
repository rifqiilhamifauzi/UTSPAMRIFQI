package lat.pam.myrecyclerviewdicoding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import lat.pam.myrecyclerviewdicoding.SignUpActivity // <-- TAMBAHKAN IMPORT INI

class splashAwal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashawal)

        // Ini sudah benar, mengambil tombol dari layout Anda
        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            // Pindah ke halaman SignUpActivity (Screen 2)
            // UBAH BARIS INI:
            val intent = Intent(this, SignUpActivity::class.java) // <-- Diubah dari MainActivity
            startActivity(intent)
            finish() // Ini sudah bagus, agar tidak bisa kembali ke Splash Screen
        }
    }
}