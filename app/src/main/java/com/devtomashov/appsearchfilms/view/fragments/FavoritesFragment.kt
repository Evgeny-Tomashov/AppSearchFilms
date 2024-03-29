package com.devtomashov.appsearchfilms.view.fragments

import com.devtomashov.appsearchfilms.view.rv_adapters.TopSpacingItemDecoration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devtomashov.appsearchfilms.view.rv_adapters.FilmListRecyclerAdapter
import com.devtomashov.appsearchfilms.databinding.FragmentFavoritesBinding
import com.devtomashov.appsearchfilms.data.entity.Film
import com.devtomashov.appsearchfilms.utils.AnimationHelper
import com.devtomashov.appsearchfilms.view.MainActivity

class FavoritesFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private var favBinding: FragmentFavoritesBinding? = null
    private val binding
        get() = favBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favBinding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AnimationHelper.performFragmentCircularRevealAnimation(
            binding!!.favoritesFragmentRoot,
            requireActivity(),
            2
        )

        //Получаем список при транзакции фрагмента
        val favoritesList: List<Film> = emptyList()

        favBinding?.favoritesRecycler?.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(favoritesList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        favBinding = null
    }
}