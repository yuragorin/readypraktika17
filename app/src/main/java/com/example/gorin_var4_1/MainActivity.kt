package com.example.gorin_var4_1
import com.example.gorin_var4_1.R
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.toString


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref: SharedPreferences = getSharedPreferences("pasandlog", MODE_PRIVATE)
        val savedLogin = sharedPref.getString("login", "")
        val savedPassword = sharedPref.getString("password", "")

        val loginEditText: EditText = findViewById(R.id.login)
        val passEditText: EditText = findViewById(R.id.pass)

        loginEditText.setText(savedLogin)
        passEditText.setText(savedPassword)
    }







    fun button(view: View) {

        var edt:EditText = findViewById(R.id.login)
        var ps: EditText = findViewById(R.id.pass)







        if (edt.text.toString().isEmpty() or ps.text.toString().isEmpty())
        {
                val toast = Toast.makeText(this, "Введите логин и пароль", Toast.LENGTH_LONG)
                toast.show()
            }
        else {

                val intent: Intent = Intent(this, second::class.java)
            val sharedPref: SharedPreferences = getSharedPreferences("pasandlog", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("login", edt.text.toString())
                putString("password", ps.text.toString())
                apply()
            }

                startActivity(intent)
            }


    }



    }

