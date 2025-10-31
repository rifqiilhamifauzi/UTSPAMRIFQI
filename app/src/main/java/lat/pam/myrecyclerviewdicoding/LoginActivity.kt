package lat.pam.myrecyclerviewdicoding

import android.content.Context // <-- IMPORT INI
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText // <-- IMPORT INI
import android.widget.Toast
import lat.pam.myrecyclerviewdicoding.R
import lat.pam.myrecyclerviewdicoding.MainActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        // --- Temukan semua komponen ---
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        // --- Ambil data tersimpan dari SharedPreferences ---
        val prefs = getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE)
        val savedUsername = prefs.getString("USER_USERNAME", null)
        val savedPassword = prefs.getString("USER_PASSWORD", null)

        btnLogin.setOnClickListener {
            // Ambil input pengguna saat tombol diklik
            val inputUsername = etUsername.text.toString()
            val inputPassword = etPassword.text.toString()

            // --- LOGIKA UTAMA ADA DI SINI ---

            // 1. Cek jika input kosong
            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(this, "Username dan Password harus diisi", Toast.LENGTH_SHORT).show()

                // 2. Cek jika tidak ada data register (belum pernah register)
            } else if (savedUsername == null || savedPassword == null) {
                Toast.makeText(this, "Anda belum terdaftar, silahkan Register dulu", Toast.LENGTH_LONG).show()

                // 3. Cek jika input COCOK dengan yang tersimpan
            } else if (inputUsername == savedUsername && inputPassword == savedPassword) {
                // LOGIN BERHASIL
                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()

                // 4. Jika input TIDAK COCOK
            } else {
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}