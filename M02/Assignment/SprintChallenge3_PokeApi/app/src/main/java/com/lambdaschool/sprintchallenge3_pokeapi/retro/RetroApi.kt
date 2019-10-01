package com.lambdaschool.sprintchallenge3_pokeapi.retro

import com.google.gson.GsonBuilder
import com.lambdaschool.sprintchallenge3_pokeapi.Pokemon
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

interface RetroApiInterface {
    @GET("{idOrName}")
    fun getPokemonInfo(@Path("idOrName")idOrName: String): Call<Pokemon>
}

object RetroFunction{
    fun getPokemonInfo(idOrName: String): Call<Pokemon> {
        val gson = GsonBuilder().setLenient().create()

        val retro = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/pokemon/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(RetroApiInterface::class.java).getPokemonInfo(idOrName)

        return retro
    }
}