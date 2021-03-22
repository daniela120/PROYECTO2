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


class RecyclerAdapterComidas: RecyclerView.Adapter<RecyclerAdapterComidas.ViewHolder>() {

    private val titlesC = arrayOf("Tacos Jumbo", "Nachos Familiar", "Burritos Jr",
        "Tacos Jr.", "Chiles Relleno",
        "Chilaquiles Familiar", "Torta Jumbo","Mexican Burger")

    private val detailsC = arrayOf(
            "4 tacos, 2 refresco",
            "4 nachos, 4 refrescos",
            "2 burritos, 1 refresco",
             "2 tacos, 1 refresco.",
            "4 chiles rellenos, 1 refresco",
             "4 chilaquiles, 4 refresco",
            "1 Torta, 1 refresco",
            "1 Mexican Burger, 1 refresco")

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
            itemImage=itemView.findViewById(R.id.item_imageC)
            itemTitle=itemView.findViewById(R.id.item_titleC)
            itemDetail=itemView.findViewById(R.id.item_detailC)


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
    private fun GoMain(itemView: View){
        val intent = Intent(itemView.context, MainActivity::class.java)
        itemView.context.startActivity(intent)

    }
    fun GoRegistrarCliente(itemView: View) {
        val intent = Intent(itemView.context, RegistrarCliente::class.java)
        itemView.context.startActivity(intent)
    }

    fun GoRegistrarMenu(itemView: View) {
        val intent = Intent(itemView.context, RegistrarMenu::class.java)
        itemView.context.startActivity(intent)
    }
    fun GoRegistrarMesa(itemView: View) {
        val intent = Intent(itemView.context, RegistrarMesa::class.java)
        itemView.context.startActivity(intent)
    }

    fun GoRegistrarEmpleado(itemView: View) {
        val intent = Intent(itemView.context, RegistrarEmpleado::class.java)
        itemView.context.startActivity(intent)
    }
    fun GoRealizarFactura(itemView: View) {
        val intent = Intent(itemView.context, RealizarFactura::class.java)
        itemView.context.startActivity(intent)
    }

    fun GoRealizarPedido(itemView: View) {
        val intent = Intent(itemView.context, RealizarPedido ::class.java)
        itemView.context.startActivity(intent)
    }

    fun GoEnviarFactura(itemView: View) {
        val intent = Intent(itemView.context, EnviarFactura ::class.java)
        itemView.context.startActivity(intent)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text= titlesC[i]
        viewHolder.itemDetail.text= detailsC[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titlesC.size
    }
}
