package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import  android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val titles = arrayOf("Registrar Cliente", "Registrar Menu", "Registrar Mesa",
        "Registrar Empleado", "Realizar Pedido",
        "Realizar Factura", "Enviar por correo")

    private val details = arrayOf( "Registrar un Cliente", "Registrar un Menu", "Registrar una Mesa",
        "Registrar un Empleado", "Realizar un Pedido",
        "Realizar una  Factura", "Enviar Factura por correo")

    private val images = intArrayOf(R.drawable.registro_cliente,
        R.drawable.registrar_menu, R.drawable.mesa,
        R.drawable.empleado, R.drawable.pedido,
        R.drawable.factura, R.drawable.enviar)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v =LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
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

            itemView.setOnClickListener{ v: View->
                var position: Int = getAdapterPosition()

                Snackbar.make(v,"Click detectado en el item $position",
                        Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }
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
