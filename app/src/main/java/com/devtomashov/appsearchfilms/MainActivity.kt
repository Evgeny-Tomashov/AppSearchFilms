package com.devtomashov.appsearchfilms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onClickToastMenu (view: View) {
        Toast.makeText(this, "Меню", Toast.LENGTH_SHORT).show()
    }
    fun onClickToastFavorites (view: View) {
        Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
    }
    fun onClickToastWatchLater (view: View) {
        Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
    }
    fun onClickToastSelections (view: View) {
        Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
    }
    fun onClickToastSettings (view: View) {
        Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
    }
}
