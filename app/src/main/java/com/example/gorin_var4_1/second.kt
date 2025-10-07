package com.example.gorin_var4_1
import com.example.gorin_var4_1.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly


class second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var spin:Spinner = findViewById(R.id.spins)
        var data = arrayOf("круг", "треугольник")

        var adapter: ArrayAdapter<Any?> =
            ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.adapter = adapter;



        val intent: Intent = Intent(this, activity_three::class.java)
        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selected = data[position]
                if(selected=="треугольник"){
                    val immg:ImageView=findViewById(R.id.imgs)
                    immg.setImageResource(R.drawable.triug)


                    intent.putExtra("фигура2", "ываыва");





                }
                else{


                    val immg:ImageView=findViewById(R.id.imgs)
                    immg.setImageResource(R.drawable.circus)


                }

                val toast = Toast.makeText(this@second, selected, Toast.LENGTH_LONG)
                toast.show()


            }
            override fun onNothingSelected(parent: AdapterView<*>) {



            }
        }

    }

    fun apply(view: View) {
        val rasch:EditText=findViewById(R.id.raschet)
        val str: String= rasch.text.toString()

        if(str.isEmpty()){
            Toast.makeText(this,"введите число", Toast.LENGTH_LONG).show()
        }
        else{
            if(str.isDigitsOnly()) {
                val nymbers: Int = str.toInt()


                val intent: Intent = Intent(this, activity_three::class.java)
                var spinner: Spinner = findViewById(R.id.spins);
                var ns: String = spinner.selectedItem.toString()

                intent.putExtra("фигура2", ns);
                if (ns == "круг") {
                    if (str.isDigitsOnly()) {
                        var result: Double = str.toDouble() / (2 * 3.14);


                        intent.putExtra("результат", result);
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "введите число", Toast.LENGTH_LONG).show()
                    }
                } else {
                    if (str.isDigitsOnly()) {
                        var result: Double = str.toDouble() * (4);
                        intent.putExtra("результат", result);
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "введите число", Toast.LENGTH_LONG).show()
                    }
                }
            }
            else{
                Toast.makeText(this,"введите число", Toast.LENGTH_LONG).show()
            }

        }




    }


}