package com.devtomashov.appsearchfilms

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.devtomashov.appsearchfilms.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var film: Film
    private var detailBinding: FragmentDetailsBinding? = null
    private val binding get() = detailBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailBinding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFilmsDetails()

        detailBinding?.detailsFabFavorites?.setOnClickListener {
            if (!film.isInFavorites) {
                detailBinding?.detailsFabFavorites?.setImageResource(R.drawable.baseline_favorite)
                film.isInFavorites = true
            } else {
                detailBinding?.detailsFabFavorites?.setImageResource(R.drawable.baseline_favorite_border_24)
                film.isInFavorites = false
            }
        }

        detailBinding?.detailsFabShare!!.setOnClickListener {
            //Создаем интент
            val intent = Intent()
            //Укзываем action с которым он запускается
            intent.action = Intent.ACTION_SEND
            //Кладем данные о нашем фильме
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Check out this film: ${film.title} \n\n ${film.description}"
            )
            //УКазываем MIME тип, чтобы система знала, какое приложения предложить
            intent.type = "text/plain"
            //Запускаем наше активити
            startActivity(Intent.createChooser(intent, "Share To:"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        detailBinding = null
    }

    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        film = arguments?.get("film") as Film

        //Устанавливаем заголовок
        detailBinding?.detailsToolbar?.title = film.title
        //Устанавливаем картинку
        detailBinding?.detailsPoster?.setImageResource(film.poster)
        //Устанавливаем описание
        detailBinding?.detailsDescription?.text = film.description

        detailBinding?.detailsFabFavorites?.setImageResource(
            if (film.isInFavorites) R.drawable.baseline_favorite
            else R.drawable.baseline_favorite_border_24
        )
    }
}