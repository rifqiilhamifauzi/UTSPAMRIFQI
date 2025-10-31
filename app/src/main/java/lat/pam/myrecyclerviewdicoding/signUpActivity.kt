package lat.pam.myrecyclerviewdicoding // Pastikan ini sesuai package Anda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import lat.pam.myrecyclerviewdicoding.R // Import R
import lat.pam.myrecyclerviewdicoding.RegisterFormActivity
import lat.pam.myrecyclerviewdicoding.LoginActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up) // Pastikan nama layout-nya benar

        // TAMBAHAN DARI LANGKAH 1: Menghilangkan ActionBar
        supportActionBar?.hide()

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnRegister.setOnClickListener {
            // Ganti ke activity Registrasi/form yang kamu punya
            val intent = Intent(this, RegisterFormActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            // Ganti ke activity Login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}