package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_enviar_factura.*


class EnviarFactura : AppCompatActivity() {

    var datos_cliente: HashMap<Int, String> = hashMapOf()
    var datos_menu: HashMap<Int, String> = hashMapOf()
    var datos_mesa: HashMap<Int, String> = hashMapOf()
    var datos_empleado: HashMap<Int, String> = hashMapOf()
    var datos_pedido: HashMap<Int, String> = hashMapOf()
    var datos_factura: HashMap<Int, String> = hashMapOf()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_factura)
        btn_regresarEnviarFA.setOnClickListener {
            regresaralmenu()
        }
        btn_EnviarCorreo.setOnClickListener {
            enviar()
        }
        obtenerCliente()
        obtenerMenu()
        obtenerMesa()
        obtenerEmpleado()
        obtenerPedido()
        obtenerFactura()


    }


    private fun regresaralmenu() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Cliente", datos_cliente)
        intent.putExtra("status-c","true")
        intent.putExtra("Menu", datos_menu)
        intent.putExtra("status-m","true")
        intent.putExtra("Mesa", datos_mesa)
        intent.putExtra("status-me","true")
        intent.putExtra("Empleado", datos_empleado)
        intent.putExtra("status-e","true")
        intent.putExtra("Pedido", datos_pedido)
        intent.putExtra("status-p","true")
        intent.putExtra("Factura", datos_factura)
        intent.putExtra("status-f","true")
        startActivity(intent)
    }


    private fun enviar(){
        var to = arrayOf<String>(txt_CorreoDestino.text.toString(), "helen.orellana1@ujcv.edu.hn","miguel.torres@ujcv.edu.hn","Daniela.herrera@ujcv.edu.hn","edwin.espino@ujcv.edu.hn")
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL,to)
        intent.putExtra(Intent.EXTRA_SUBJECT, txt_Asunto.text.toString())
        var a=""
        var b=""
        var c=""
        var de=""
        var e=""
        var f=""


        for(d in datos_factura){
            val data1 = d.toString().split("|").toTypedArray()
            a=data1[0].toString()
            b=data1[1].toString()
            c=data1[2].toString()
            de=data1[3].toString()
            e=data1[4].toString()
            f=data1[5].toString()


        }
        var facturafinal = a+"\nCODIGOS DE LA FACTURA: "+b+"\nTIPO DE PAGO: "+c+"\nNOMBRE DEL CLIENTE: "+de+"\nATENDIDO POR: "+e+"\nTOTAL: "+f
        intent.putExtra(Intent.EXTRA_TEXT, facturafinal)
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Email"))


    }

    private fun obtenerCliente(){
        val intent = intent
        datos_cliente= intent.getSerializableExtra("Cliente") as HashMap<Int,String>
        println("El cliente es: "+datos_cliente.toString())
    }
    private fun obtenerMenu(){
        val intent = intent
        datos_menu= intent.getSerializableExtra("Menu") as HashMap<Int,String>
        println("El menu es: " +datos_menu.toString())
    }
    private fun obtenerMesa(){
        val intent = intent
        datos_mesa= intent.getSerializableExtra("Mesa") as HashMap<Int,String>
        println("La mesa es: "+datos_mesa.toString())
    }
    private fun obtenerEmpleado(){
        val intent = intent
        datos_empleado= intent.getSerializableExtra("Empleado") as HashMap<Int,String>
        println("El empleado es: "+datos_empleado.toString())
    }
    private fun obtenerPedido(){
        val intent = intent
        datos_pedido= intent.getSerializableExtra("Pedido") as HashMap<Int,String>
        println("El pedido es: "+datos_pedido.toString())
    }

    private fun obtenerFactura(){
        val intent = intent
        datos_factura= intent.getSerializableExtra("Factura") as HashMap<Int,String>
        println("La factura es: "+datos_factura.toString())
    }

}