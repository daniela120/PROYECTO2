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
        R.drawable.tacos_jumbo,
        R.drawable.nachos_familiar, R.drawable.burritos_jr,
        R.drawable.tacos_jr, R.drawable.chiles_rellenos,
        R.drawable.chilaquiles, R.drawable.torta_jumbo, R.drawable.mexican_burger)


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout2, viewGroup, false)
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
                    0 -> GoTacosJumbo(itemView)
                    1 -> GoNachosFamiliar(itemView)
                    2 -> GoBurritos(itemView)
                    3 -> GoTacosJr(itemView)
                    4 -> GoChilesRellenos(itemView)
                    5 -> GoTortaJumbo(itemView)
                    6 -> GoMexicanBurger(itemView)
                    else->GoMain(itemView)

                }




            }
        }

    }

     fun GoMexicanBurger(itemView: View) {
        val intent = Intent(itemView.context, RegistrarMenu::class.java)
        itemView.context.startActivity(intent)
    }

    fun GoTortaJumbo(itemView: View) {
        val intent = Intent(itemView.context, RegistrarMenu::class.java)
        itemView.context.startActivity(intent)
    }

    fun GoChilesRellenos(itemView: View) {
        val intent = Intent(itemView.context, RegistrarMenu::class.java)
        itemView.context.startActivity(intent)
    }

   fun GoTacosJr(itemView: View) {
        val intent = Intent(itemView.context, RegistrarMenu::class.java)
        itemView.context.startActivity(intent)
    }

    private fun GoMain(itemView: View){
        val intent = Intent(itemView.context, MainActivity::class.java)
        itemView.context.startActivity(intent)

    }
    fun GoBurritos(itemView: View) {
        val intent = Intent(itemView.context, RegistrarMenu::class.java)
        itemView.context.startActivity(intent)

    }
    fun GoTacosJumbo(itemView: View) {
        val intent = Intent(itemView.context, RegistrarMenu::class.java)
        itemView.context.startActivity(intent)
    }

    fun GoNachosFamiliar(itemView: View) {
        val intent = Intent(itemView.context, RegistrarMenu::class.java)
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
