package net.ivanvega.mirollera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //AQUI SE DECLARO VARIABLES DE TIPO BOTON, LABEL Y UNA IMAGEN
    //LATEINIT ES PARA INSTANCIAR ESA VARIABLE DESPUES
    lateinit var boton: Button
    lateinit var lbl: TextView
    lateinit var img: ImageView

    lateinit var lbl1: TextView
    lateinit var img1: ImageView




    //ESTE ES EL METODO MAIN Y SE ENVIA EL LAYAOUT
    //OSEA LA VNTANA PRINCIPAL EN LA QUE SE TRBAJARA
    //DONDE SE ADJUNTAN BOTONES, LABEL ,ETC ,ETC...
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_roller)


        /*USAMOS LA VARIABLE DECLARADA
        "R" ES PARA BUSCAR ENTRE LOS RECURSOS LA VARIABLE DE EL BOTON,
        EL LABEL Y LA IMAGEN Y SE LE ASIGNA A LA VARIABLE CREADA SIN USAR*/

        lbl = findViewById(R.id.lblSaludo)
        boton = findViewById(R.id.btnRoller)
        img = findViewById(R.id.imgRoller)


        lbl1 = findViewById(R.id.lblnueva)
        img1 = findViewById(R.id.imgDado2)
        //*****************************************************************
        /*ESTE CODIGO ES PARA CUANDO SE DE CLICK EN EL BOTON              *
        SE MUESTRE UN MENSAJE DE QUE SE PRECIONO CON                      *
        UN LIMITE DE TIEMPO , EN ESTE CASO LARGO POR EL LENGTH LONG*/ //  *
        //                                                                *
        /*boton.setOnClickListener(                                       *
            View.OnClickListener {                                        *
                Toast.makeText(applicationContext,                        *
                    "Boton presionafdo",                                  *
                    Toast.LENGTH_LONG                                     *
                    ).show()                                              *
            }                                                             *
        )*///                                                             *
        //*****************************************************************

        /*Aqui se agrega de los recursos de la carpeta drawable la imagen que estara al principio
        * de la aplicacion cuando se ejecute*/
        img.setImageDrawable(resources.getDrawable(R.drawable.dado_inicial ))
        img1.setImageDrawable(resources.getDrawable(R.drawable.dado_inicial))
        /**se le da un evento al boton, en este caso cuando se precione*/

        boton.setOnClickListener {
            val aleatorio = diceRoller() //se declaro una variable aleatoria que tendra un numero aleatorio
            val aleatorio2 = diceRoller()
            //Esto mostrara el mensaje y se le adjunta el numero aleatorio
            Toast.makeText(
                applicationContext,
                "Se genero el numero " + aleatorio,
                Toast.LENGTH_SHORT
            ).show()

            Toast.makeText(
                applicationContext,
                "Se genero el numero " + aleatorio2,
                Toast.LENGTH_SHORT
            ).show()


            /*Esto funciona como un if else,if else... o como un awitch case */
            /*una variable donde se le asigna el numero aleatorio
              y en caso de que sea 1 se accede a la carpeta de recursos
              drawable, que es donde estan las imagenes y se le asigna*/
            val idImagenAl = when (aleatorio){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.empty_dice
            }

            val idImagenAl2 = when (aleatorio2){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.empty_dice
            }

            //asignamos a la variable imagen en funcion del numero aleatorio
            img.setImageResource(idImagenAl)
            img1.setImageResource(idImagenAl2)

            //hacemos un tostring para convertir en numero
            lbl.text = aleatorio.toString()
            lbl1.text = aleatorio2.toString()

        }
    }
        //Este es un metodo, cuando no lleva dos puntos es un metodo que no recibe nada
        //la palabra "FUN" es para iniciar un metodo
    fun diceRoller () : Int {
        return (1..6).random() //retornara 6 numeros aleatorios
    }

}