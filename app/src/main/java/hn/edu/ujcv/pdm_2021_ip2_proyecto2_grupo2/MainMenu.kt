package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_menu.*
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Color
import kotlinx.android.synthetic.main.menu_main.*

class MainMenu : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerAdapterComidas = RecyclerAdapterComidas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_main)
        setSupportActionBar(findViewById(R.id.toolbar2))

        collapsing_toolbar2.title = "MENUS"
        collapsing_toolbar2.setContentScrimColor(Color.BLACK)

        layoutManager = LinearLayoutManager(this)
        recyclerView2.layoutManager = layoutManager
        recyclerView2.adapter=adapter




    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}