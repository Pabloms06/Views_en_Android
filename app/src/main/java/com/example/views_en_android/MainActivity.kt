package com.example.views_en_android

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import com.example.views_en_android.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Vista con ViewBinding, el texto se cambia de TextView a Bienvenido aplicado al segundo boton
        //Añadimos en build:gradle(:app) la siguiente liena de código --> viewBinding.enabled = true (dentro de el elemento android) y pulsamos sync now y introducimos el
        //siguiente texto para referenciarlo
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            //Para acceder a cada una de las vistas (binding.nombreelemento.)
            texto2.text="Bienvenido"
        }

        //FindViewById, Te cambia el mensaje de Hola!! por Adios, aplicado al primer boton
        //Esta seria la primera forma que surgio, se usa de la siguiente forma:
        // variable nombreDado = findViewById<Tipo>(R.id.nombreIDdentrodelXML)

        val texto = findViewById<TextView>(R.id.textView)
        val boton = findViewById<Button>(R.id.button)

        boton.setOnClickListener {
            texto.text = "Adios"
        }



        //Te añade los mensajes que ponga el usuario en usuario a texto
        //Lo primero para usar este tipo de vistas en declarar en build.gradle(:app) lo siguiente--> id 'kotlin-android-extensions'  Dentro de el elemento plugins
        //y de esta manera, será mucho más sencillo iniciar el elemento aquí
        //SIMPLEMENTE para inicializarlo pondremos el nombre del identificador del elemento.

        usuario.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if (it.isNotEmpty())
                        texto.text = it  //Te pone en el text view el valor que el usuario meta por pantalla

                    //Tener como minimo 1

                }
            }
        })

    }

}