# Proyek UTS: Aplikasi "Mesen Makanan" 
nama: Rifqi Ilhami Fauzi
nim: 1237050121

Ini adalah proyek yang saya buat untuk memenuhi tugas Ujian Tengah Semester (UTS) mata kuliah Pengembangan Aplikasi Mobile.

## Penjelasan Singkat Proyek

Singkatnya, ini adalah prototipe aplikasi *food delivery* sederhana. Saya membuatnya pakai **Kotlin** dan **Android Studio**.

Tujuan utama proyek ini adalah untuk menerapkan materi-materi dasar yang sudah dipelajari, terutama:

* **Navigasi:** Pindah-pindah halaman pakai **Navigation Component** (dari halaman Login ke Home, dari Home ke Keranjang, dst.)
* **Penyimpanan Data:** Pakai **SharedPreferences** untuk menyimpan data user (Nama, Username, Password) waktu register. Jadi, datanya nggak hilang walaupun aplikasi ditutup.
* **State Management:** Pakai **ViewModel** dan **LiveData** untuk "otak" keranjang belanja. Jadi, item yang saya tambahkan di halaman Home bisa muncul di halaman Order.
* **Tampilan Dinamis:** Pakai **RecyclerView** buat nampilin daftar 10 makanan di halaman Home.

---

## Fitur-fitur Utama

Berikut adalah fitur-fitur yang sudah berhasil saya implementasikan di proyek ini:

1.  **Sistem Login & Register:**
    * Wajib **Register** dulu sebelum bisa login.
    * Data (Nama Lengkap, Username, Password) disimpan ke **SharedPreferences**.
    * Halaman **Login** akan mengecek data dari SharedPreferences tadi. Kalau salah, bakal muncul `Toast` error.

2.  **Personalisasi Nama:**
    * Nama yang diisi pas register (misal: "Rifqi") bakal dipanggil dan ditampilin di halaman Home, Order, dan Sukses. Jadi, munculnya "Halo Rifqi,".

3.  **Katalog & Keranjang Belanja:**
    * Halaman Home nampilin 10 makanan pakai `RecyclerView`.
    * Waktu item makanan di-klik, item itu bakal masuk ke `CartViewModel` (keranjang).
    * Tab **Order** berfungsi sebagai halaman Keranjang Belanja, menampilkan semua item yang sudah dipilih.

4.  **Alur Checkout Penuh:**
    * Dari halaman Order, user bisa lanjut ke halaman "Alamat Pengiriman" (Screen 7) dan halaman "Sukses" (Screen 8).

5.  **UI/UX Cerdas:**
    * Menu navigasi bawah (Bottom Bar) sengaja saya **sembunyikan** pas user masuk ke alur Checkout (Alamat & Sukses) biar nggak mengganggu.

---

## Alur Penggunaan Aplikasi

Begini cara pakai aplikasinya dari awal sampai akhir:

1.  **Awal:** Buka aplikasi, muncul **Splash Screen**, lalu tekan "Start now".
2.  **Registrasi:** User wajib pilih "Register". Di sini, user ngisi Nama Lengkap, Username, dan Password. Data ini langsung **disimpan** ke SharedPreferences.
3.  **Login:** Setelah register, user balik ke halaman Login. Masukkan Username dan Password yang *benar* (sesuai yang didaftarkan).
4.  **Home:** Kalau login berhasil, user masuk ke halaman Home. Di sini ada daftar 10 makanan.
5.  **Tambah ke Keranjang:** User bisa klik beberapa makanan (misal: "Rendang" dan "Bakso"). Setiap klik, muncul `Toast` notifikasi ("Bakso ditambahkan ke keranjang").
6.  **Lihat Keranjang:** User pindah ke tab "Order".
7.  **Halaman Order:** Halaman ini nampilin daftar makanan yang tadi dipilih ("Rendang" dan "Bakso").
8.  **Checkout:** User menekan tombol "Kirim (Checkout)".
9.  **Isi Alamat:** User masuk ke form "Alamat Pengiriman". Di sini, menu navigasi bawah (Home, Order, Profile) **hilang**.
10. **Selesai:** Setelah isi alamat dan klik "Order", user masuk ke halaman "Success".
11. **Balik ke Home:** Dari halaman Success, user tekan "Main" dan kembali ke Home.

---

## Teknologi yang Dipakai

* **Bahasa:** Kotlin
* **Arsitektur:** ViewModel + LiveData (untuk data Cart/Keranjang)
* **Navigasi:** Android Navigation Component (Single Activity, Multiple Fragment)
* **Layout:** XML (LinearLayout, RelativeLayout, dll.)
* **List:** RecyclerView
* **Storage:** SharedPreferences
* **Image Loading:** Glide (dari folder `drawable`)

---

## Tangkapan Layar (Screenshots)

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/e2b1e3d5-1b08-4c45-8a7c-3621ed809e28" />
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/903f369d-77b9-4313-8198-c0e359061df2" />
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/f4ba5a0b-2091-4e8c-a68f-8587ff131501" />
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/afe45bc2-27c0-4bd6-b27d-3819cfd55676" />
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/374abfdf-a38a-4b95-827b-04d8df46ac8c" />
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/6f7dbf49-3eb8-4a3f-b72e-153c7df49863" />
<img width="960" height="600" alt="image" src="https://github.com/user-attachments/assets/64bfc726-b0d3-4d23-8128-3562e135a247" />
<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/2c6ab133-020a-4e81-88a2-4f4c3ed08dee" />

### Alur Autentikasi (Login/Register)
| | |
|:---:|:---:|
| [Screenshot Splash Screen] | [Screenshot Pilihan Auth] |
| [Screenshot Form Register] | [Screenshot Form Login] |

### Alur Utama & Pemesanan
| | |
|:---:|:---:|
| [Screenshot Home (Daftar Makanan)] | [Screenshot Notifikasi Toast "Tambah Keranjang"] |
| [Screenshot Halaman Order (Keranjang)] | [Screenshot Halaman Alamat (Checkout)] |
| [Screenshot Halaman Sukses] | |
