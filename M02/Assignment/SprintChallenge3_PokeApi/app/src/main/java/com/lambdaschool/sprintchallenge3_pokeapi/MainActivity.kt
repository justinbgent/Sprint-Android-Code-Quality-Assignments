package com.lambdaschool.sprintchallenge3_pokeapi

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.lambdaschool.sprintchallenge3_pokeapi.retro.RetroFunction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this

        search_button.setOnClickListener {
            val intent = Intent(context, PokemonDetailsActivity::class.java)
            intent.putExtra("Search_Parameter", search_bar.text.toString())
            startActivityForResult(intent, 0)

            AlertDialog.Builder(this@MainActivity)
                    .setTitle("Delete entry")
                    .setMessage("Test")
                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(android.R.string.yes,
                            DialogInterface.OnClickListener { dialog, which ->
                                dialog.dismiss()
                            })
                    // A null listener allows the button to dismiss the dialog and take no further action.
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show()
        }


    }

    private fun buildTextView(name: String?): TextView {
        val view = TextView(this)
        view.text = name
        view.textSize = 14f
        view.setPadding(10, 10, 10, 10)
        view.setOnClickListener {
            val intent = Intent(context, PokemonDetailsActivity::class.java)
            intent.putExtra("Search_Parameter", name)
            startActivityForResult(intent, 0)
        }
        view.setOnLongClickListener { clickedView ->
            names_list_layout?.removeView(clickedView)
            true
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                0 -> {
                    //val pokemon = data!!.getSerializableExtra("pokemon") as Pokemon
                    //names_list_layout?.addView(buildTextView(pokemon.name))
                    val pokemon = data!!.getStringExtra("pokemon")
                    names_list_layout?.addView(buildTextView(pokemon))
                }
            }
        }
    }
}
