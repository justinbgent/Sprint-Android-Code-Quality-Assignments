package com.lambdaschool.sprintchallenge3_pokeapi.retro

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

interface RetroApiInterface {
    @GET("{IdOrName}")
    fun getPokemonInfo(@Path("IdOrName")idOrName: String): Call<PokemonDetail>
}

object RetroFunction{
    fun getPokemonInfo(idOrName: String): Call<PokemonDetail> {
        val okHttpClient = OkHttpClient.Builder()
                .addNetworkInterceptor(StethoInterceptor())
                .retryOnConnectionFailure(false)
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(12, TimeUnit.SECONDS)
                .build()

        val gson = GsonBuilder().setLenient().create()
        val retro = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/pokemon/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        return retro.create(RetroApiInterface::class.java).getPokemonInfo(idOrName)
    }
}

data class PokemonDetail(val id: Int, val name: String, val sprites: Sprites, val types: List<Types>, val moves: List<Moves>)

data class Sprites(@SerializedName("front_default")val pokemonSprite: String)

data class Types(val type: Type)

data class Type(val name: String)

data class Moves(val move: Move)

data class Move(val name: String)