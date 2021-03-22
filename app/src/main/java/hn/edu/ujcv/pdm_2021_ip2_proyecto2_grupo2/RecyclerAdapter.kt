package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Process
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    var datos_cliente: HashMap<Int, String> = hashMapOf()
    var datos_menu: HashMap<Int, String> = hashMapOf()
    var datos_mesa: HashMap<Int, String> = hashMapOf()
    var datos_empleado: HashMap<Int, String> = hashMapOf()
    var datos_pedido: HashMap<Int, String> = hashMapOf()
    var datos_factura: HashMap<Int, String> = hashMapOf()

    private val titles = arrayOf("Registrar Cliente", "Registrar Menu", "Registrar Mesa",
        "Registrar Empleado", "Realizar Pedido",
        "Realizar Factura", "Enviar por correo")

    private val details = arrayOf( "Registrar un Cliente", "Registrar un Menu", "Registrar una Mesa",
        "Registrar un Empleado", "Realizar un Pedido",
        "Realizar una  Factura", "Enviar Factura por correo")

    private val images = intArrayOf(
        R.drawable.cliente,
        R.drawable.menu, R.drawable.mesa,
        R.drawable.empleado, R.drawable.pedidox,
        R.drawable.factura, R.drawable.enviar)


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        
        init {
            itemImage=itemView.findViewById(R.id.item_image)
            itemTitle=itemView.findViewById(R.id.item_title)
            itemDetail=itemView.findViewById(R.id.item_detail)


            itemView.setOnClickListener { v: View? ->
                var position:Int = getAdapterPosition()
                println(position.toString())


                when(position){
                    0 -> GoRegistrarCliente(itemView)
                    1 -> GoRegistrarMenu(itemView)
                    2 -> GoRegistrarMesa(itemView)
                    3 -> GoRegistrarEmpleado(itemView)
                    4 -> GoRealizarPedido(itemView)
                    5 -> GoRealizarFactura(itemView)
                    6 -> GoEnviarFactura(itemView)
                    else->GoMain(itemView)

                }




            }
        }
    }

    /*FUNCIONES PARA NAVEGAR ENTRE ACTIVITIES*/
    private fun GoMain(itemView: View){
        val intent = Intent(itemView.context, MainActivity::class.java)
        itemView.context.startActivity(intent)

    }
    fun GoRegistrarCliente(itemView: View) {
        val intent = Intent(itemView.context, RegistrarCliente::class.java)
        intent.putExtra("Menu", datos_menu)
        intent.putExtra("Mesa", datos_mesa)
        intent.putExtra("Empleado", datos_empleado)
        intent.putExtra("Pedido", datos_pedido)
        intent.putExtra("Factura", datos_factura)
        itemView.context.startActivity(intent)
    }

    fun GoRegistrarMenu(itemView: View) {
        val intent = Intent(itemView.context, RegistrarMenu::class.java)
        intent.putExtra("Cliente", datos_cliente)
        intent.putExtra("Mesa", datos_mesa)
        intent.putExtra("Empleado", datos_empleado)
        intent.putExtra("Pedido", datos_pedido)
        intent.putExtra("Factura", datos_factura)
        itemView.context.startActivity(intent)
    }
    fun GoRegistrarMesa(itemView: View) {
        val intent = Intent(itemView.context, RegistrarMesa::class.java)
        intent.putExtra("Cliente", datos_cliente)
        intent.putExtra("Menu", datos_menu)
        intent.putExtra("Empleado", datos_empleado)
        intent.putExtra("Pedido", datos_pedido)
        intent.putExtra("Factura", datos_factura)
        itemView.context.startActivity(intent)
    }

    fun GoRegistrarEmpleado(itemView: View) {
        val intent = Intent(itemView.context, RegistrarEmpleado::class.java)
        intent.putExtra("Cliente", datos_cliente)
        intent.putExtra("Menu", datos_menu)
        intent.putExtra("Mesa", datos_mesa)
        intent.putExtra("Pedido", datos_pedido)
        intent.putExtra("Factura", datos_factura)
        itemView.context.startActivity(intent)
    }

    fun GoRealizarPedido(itemView: View) {
        val intent = Intent(itemView.context, RealizarPedido::class.java)
        intent.putExtra("Cliente", datos_cliente)
        intent.putExtra("Menu", datos_menu)
        intent.putExtra("Mesa", datos_mesa)
        intent.putExtra("Empleado", datos_empleado)
        intent.putExtra("Factura", datos_factura)
        itemView.context.startActivity(intent)
    }


    fun GoRealizarFactura(itemView: View) {
        val intent = Intent(itemView.context, RealizarFactura::class.java)
        intent.putExtra("Cliente", datos_cliente)
        intent.putExtra("Menu", datos_menu)
        intent.putExtra("Mesa", datos_mesa)
        intent.putExtra("Empleado", datos_empleado)
        intent.putExtra("Pedido", datos_pedido)
        itemView.context.startActivity(intent)
    }



    fun GoEnviarFactura(itemView: View) {
        val intent = Intent(itemView.context, EnviarFactura::class.java)
        intent.putExtra("Cliente", datos_cliente)
        intent.putExtra("Menu", datos_menu)
        intent.putExtra("Mesa", datos_mesa)
        intent.putExtra("Empleado", datos_empleado)
        intent.putExtra("Pedido", datos_pedido)
        intent.putExtra("Factura", datos_factura)
        itemView.context.startActivity(intent)

    }

    /*FUNCIONES PARA RECIBIR LOS DATOS*/
    fun setCliente(cliente:HashMap<Int,String>){
        this.datos_cliente=cliente

    }

    fun setMenu(menu:HashMap<Int,String>){
        this.datos_menu=menu

    }

    fun setMesa(mesa:HashMap<Int,String>){
        this.datos_mesa=mesa

    }

    fun setEmpleado(empleado:HashMap<Int,String>){
        this.datos_empleado=empleado

    }

    fun setPedido(pedido:HashMap<Int,String>){
        this.datos_pedido=pedido

    }

    fun setFactura(factura:HashMap<Int,String>){
        this.datos_factura=factura

    }


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text= titles[i]
        viewHolder.itemDetail.text= details[i]
        viewHolder.itemImage.setImageResource(images[i])

    }

    override fun getItemCount(): Int {
        return titles.size
    }
}
