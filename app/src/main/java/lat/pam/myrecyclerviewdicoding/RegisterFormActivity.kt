package lat.pam.myrecyclerviewdicoding

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText // <-- IMPORT INI
import android.widget.Toast
import lat.pam.myrecyclerviewdicoding.R
import lat.pam.myrecyclerviewdicoding.LoginActivity

class RegisterFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_form)
        supportActionBar?.hide()

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val etNamaLengkap = findViewById<EditText>(R.id.etNamaLengkap)

        // --- TAMBAHAN: Temukan EditText untuk username & password ---
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        btnRegister.setOnClickListener {
            val namaLengkap = etNamaLengkap.text.toString()
            // --- TAMBAHAN: Ambil teks username & password ---
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // --- TAMBAHAN: Validasi sederhana ---
            if (namaLengkap.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Berhenti di sini jika ada yang kosong
            }

            // Simpan SEMUA data ke SharedPreferences
            val prefs = getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE)
            val editor = prefs.edit()
            editor.putString("USER_NAME", namaLengkap)
            editor.putString("USER_USERNAME", username) // <-- SIMPAN USERNAME
            editor.putString("USER_PASSWORD", password) // <-- SIMPAN PASSWORD
            editor.apply()

            // --- (Sisa kode Anda) ---
            Toast.makeText(this, "Registrasi Berhasil, silahkan Login", Toast.LENGTH_LONG).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}