package com.lambdaschool.sprintchallenge3_pokeapi

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.lambdaschool.sprintchallenge3_pokeapi.retro.PokemonDetail
import com.lambdaschool.sprintchallenge3_pokeapi.retro.RetroFunction
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.util.ArrayList

class PokemonDetailsActivity : AppCompatActivity() {

    //internal var pokemon: Pokemon? = null
    internal var pokemon: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)
        val search = intent.getStringExtra("Search_Parameter")
        //GetPokemon().execute(search)
        RetroFunction.getPokemonInfo(search)
                .enqueue(object : Callback<PokemonDetail> {
                    override fun onFailure(call: Call<PokemonDetail>, t: Throwable) {
                        Log.i("UhFailed", ":(")
                    }

                    override fun onResponse(call: Call<PokemonDetail>, response: Response<PokemonDetail>) {
                        pokemon = response.body()?.name
                        if (response.body() != null) {
                            val pokemon = response.body()
                            pokemon?.moves?.forEach {
                                layout_moves_list.addView(buildTextView(it.move.name))
                            }
                            text_title?.text = pokemon?.name
                            if (pokemon?.types?.size == 2){
                                type_A?.text = pokemon.types[0].type.name
                                type_B?.text = pokemon.types[1].type.name
                            }else{
                                type_A?.text = pokemon!!.types[0].type.name
                            }

                            text_number?.text = String.format("No %03d", pokemon.id)
                            Picasso.get().load(pokemon.sprites.pokemonSprite).into(background_image)
                            progress_circular.visibility = View.INVISIBLE
                        }
                    }
                })

    }

    private fun buildTextView(moveName: String): TextView {
        val view = TextView(this)
        view.text = moveName
        view.textSize = 14f
        view.setPadding(10, 10, 10, 10)
        return view
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_OK, Intent().putExtra("pokemon", pokemon))
        finish()
    }

    inner class GetPokemon : AsyncTask<String, Pokemon, Bitmap>() {

        override fun onPostExecute(bitmap: Bitmap) {
            background_image?.setImageBitmap(bitmap)
            findViewById<View>(R.id.progress_circular).visibility = View.INVISIBLE
        }

//        override fun onProgressUpdate(vararg values: Pokemon) {
//            pokemon = values[0]
//            text_title?.text = values[0].name
//            type_A?.text = values[0].typeA
//            type_B?.text = values[0].typeB
//            text_number?.text = String.format("No %03d", values[0].id)
//
//            val movesViews = ArrayList<View>()
//            for (move in values[0].moves!!) {
//                movesViews.add(buildTextView(move))
//            }
//            runOnUiThread {
//                for (moveView in movesViews) {
//                    layout_moves_list?.addView(moveView)
//                }
//            }
//        }

        @SuppressLint("WrongThread")
        override fun doInBackground(vararg strings: String): Bitmap? {
            val loading = PokemonDao.getPokemon(strings[0])
            onProgressUpdate(loading)
            return loading.sprite
        }
    }
}
