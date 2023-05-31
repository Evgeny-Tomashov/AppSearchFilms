package com.devtomashov.appsearchfilms

import TopSpacingItemDecoration
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devtomashov.appsearchfilms.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var bindingFrag: FragmentHomeBinding? = null
    private val binding1 get() = bindingFrag!!

    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    val filmsDataBase = listOf(
        Film(
            "Back to the Future",
            R.drawable.back_to_the_future,
            "Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, the maverick scientist Doc Brown."
        ),
        Film(
            "Bride of Chucky",
            R.drawable.chucky,
            "Chucky, the doll possessed by a serial killer, discovers the perfect mate to kill and revive into the body of another doll."
        ),
        Film(
            "The dark knight",
            R.drawable.darkknight,
            "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."
        ),
        Film(
            "Freddy vs. Jason",
            R.drawable.freddy_vs_jason,
            "Freddy Krueger and Jason Voorhees return to terrorize the teenagers of Elm Street. Only this time, they're out to get each other, too."
        ),
        Film(
            "Insidious: The Red Door",
            R.drawable.insidious_the_red_door,
            "The Lamberts 10 years after the last installment, as Dalton begins college."
        ),
        Film(
            "Pearl",
            R.drawable.pearl,
            "In 1918, a young woman on the brink of madness pursues stardom in a desperate attempt to escape the drudgery, isolation and lovelessness of life on her parents' farm."
        ),
        Film(
            "Prometheus",
            R.drawable.promethus,
            "Following clues to the origin of mankind, a team finds a structure on a distant moon, but they soon realize they are not alone."
        ),
        Film(
            "Scream",
            R.drawable.scream,
            "A year after the murder of her mother, a teenage girl is terrorized by a masked killer who targets her and her friends by using scary movies as part of a deadly game."
        ),
        Film(
            "The Devil's Rejects",
            R.drawable.the_devils_rejects,
            "The murderous, backwoods Firefly family take to the road to escape the vengeful Sheriff Wydell, who is not afraid of being as ruthless as his target."
        ),
        Film(
            "The Lighthouse",
            R.drawable.the_lighthouse,
            "Two lighthouse keepers try to maintain their sanity while living on a remote and mysterious New England island in the 1890s."
        ),
        Film(
            "The Pope's Exorcist",
            R.drawable.the_popes_exorcist,
            "Follow Gabriele Amorth, the Vatican's leading exorcist, as he investigates the possession of a child and uncovers a conspiracy the Vatican has tried to keep secret."
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingFrag = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding1.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //находим наш RV
        bindingFrag?.mainRecycler?.apply {
            //Инициализируем наш адаптер в конструктор передаем анонимно инициализированный интерфейс
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
            //Применяем декораcтор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingFrag = null
    }

}

