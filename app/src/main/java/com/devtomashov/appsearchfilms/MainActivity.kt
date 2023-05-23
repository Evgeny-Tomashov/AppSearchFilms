package com.devtomashov.appsearchfilms

import TopSpacingItemDecoration
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.devtomashov.appsearchfilms.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
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

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        //находим наш RV
        binding?.mainRecycler.apply {
            //Инициализируем наш адаптер в конструктор передаем анонимно инициализированный интерфейс,
            //оставим его пока пустым, он нам понадобится во второй части задания
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    //Создаем бандл и кладем туда объект с данными фильма
                    val bundle = Bundle()
                    //Первым параметром указывается ключ, по которому потом будем искать, вторым сам
                    //передаваемый объект
                    bundle.putParcelable("film", film)
                    //Запускаем наше активити
                    val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                    //Прикрепляем бандл к интенту
                    intent.putExtras(bundle)
                    //Запускаем активити через интент
                    startActivity(intent)
                }
            })
            //Присваиваем адаптер
            this!!.adapter = filmsAdapter
            //Присвои layoutmanager
            this!!.layoutManager = LinearLayoutManager(this@MainActivity)
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            this!!.addItemDecoration(decorator)
        }
//Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)


        binding?.topAppBar?.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.menu_settings_title),
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                else -> false
            }
        }

        binding?.bottomNavigation?.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.menu_favorites_title),
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                R.id.watch_later -> {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.menu_watch_later_title),
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                R.id.selections -> {
                    Toast.makeText(
                        this,
                        resources.getString(R.string.menu_selections_title),
                        Toast.LENGTH_SHORT
                    ).show()
                    true
                }

                else -> false
            }
        }

    }
}





