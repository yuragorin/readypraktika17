package com.example.gorin_var4_1
import com.example.gorin_var4_1.R
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_three : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_three)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val arguments = getIntent().getExtras()
        val name: String? = arguments!!.getString("фигура2")

        val edt:EditText=findViewById(R.id.editText)
        edt.setText(name)
        val edt2: EditText=findViewById(R.id.editText2)
        val name2: Double? = arguments.getDouble("результат")
        edt2.setText(name2.toString())
    }


}