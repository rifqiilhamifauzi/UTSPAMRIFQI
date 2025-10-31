package lat.pam.myrecyclerviewdicoding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels // <-- IMPORT BARU
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lat.pam.myrecyclerviewdicoding.R

class HomeFragment : Fragment() {

    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()

    // --- TAMBAHKAN BARIS INI ---
    // 'activityViewModels' mengambil ViewModel dari MainActivity
    private val cartViewModel: CartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // --- onViewCreated Anda sudah benar (tidak perlu diubah) ---
    // (Fungsi ini sudah benar, membaca nama DAN setup RecyclerView)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvHaloUser = view.findViewById<TextView>(R.id.tv_halo_user)
        val prefs = requireActivity().getSharedPreferences("MY_APP_PREFS", Context.MODE_PRIVATE)
        var userName = prefs.getString("USER_NAME", "Nazwa")
        if (userName.isNullOrEmpty()) {
            userName = "Nazwa"
        }
        tvHaloUser.text = "Halo $userName,"

        rvHeroes = view.findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.clear()
        list.addAll(getListHeroes())
        showRecyclerList()
    }

    // ... (getListHeroes Anda sudah benar) ...
    private fun getListHeroes(): ArrayList<Hero> {
        val dataName = requireActivity().resources.getStringArray(R.array.data_food_name)
        val dataDescription = requireActivity().resources.getStringArray(R.array.data_food_description)
        val dataPhoto = listOf(
            R.drawable.rendang,
            R.drawable.nasi_goreng,
            R.drawable.sate_ayam,
            R.drawable.bakso,
            R.drawable.soto_ayam,
            R.drawable.gado_gado,
            R.drawable.rawon,
            R.drawable.pempek,
            R.drawable.gudeg,
            R.drawable.karedok
        )
        val listHero = ArrayList<Hero>()
        for (i in dataName.indices) {
            val hero = Hero(dataName[i], dataDescription[i], dataPhoto[i])
            listHero.add(hero)
        }
        return listHero
    }

    // --- PERUBAHAN UTAMA DI FUNGSI INI ---
    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(requireContext())
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {

                // --- INI LOGIKA BARU DARI LANGKAH 4 ---

                // 1. Tambahkan makanan ke ViewModel
                cartViewModel.addToCart(data)

                // 2. Beri notifikasi ke pengguna
                Toast.makeText(requireContext(), "${data.name} ditambahkan ke keranjang", Toast.LENGTH_SHORT).show()

                // HAPUS NAVIGASI LAMA
                // val bundle = Bundle()
                // bundle.putParcelable("EXTRA_FOOD", data)
                // findNavController().navigate(R.id.checkoutFragment, bundle)
            }
        })
    }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(requireContext(), "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }
}