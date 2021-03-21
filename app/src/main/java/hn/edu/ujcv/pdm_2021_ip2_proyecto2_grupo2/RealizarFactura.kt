package hn.edu.ujcv.pdm_2021_ip2_proyecto2_grupo2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_factura.*
import kotlinx.android.synthetic.main.activity_registrar_empleado.*
import java.lang.StringBuilder

class RealizarFactura : AppCompatActivity() {
    var datos_Factura: HashMap<Int, String> = hashMapOf()
    var num = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factura)

        btn_GuardarFa.setOnClickListener {
            guardar()
        }
        btn_regresarFA.setOnClickListener {
            regresar()
        }

    }

    private  fun guardar() {

        if (txt_CodigoPedido.text.toString().isEmpty()) {
            Toast.makeText(this, "Ingrese el Codigo del Pedido", Toast.LENGTH_SHORT).show()
        } else {
            if (spinner_menusPe.selectedItem.toString().isEmpty()) {
                Toast.makeText(this, "Seleccione un opcion de Pago", Toast.LENGTH_SHORT).show()
            } else {
                if (txt_Clientefa.text.toString().isEmpty()) {
                    Toast.makeText(this, "Ingrese el nombre del cliente", Toast.LENGTH_SHORT).show()
                } else {
                    if (txt_EmpleadoFa.text.toString().isEmpty()) {
                        Toast.makeText(this, "Ingrese el codigo del empleado", Toast.LENGTH_SHORT).show()
                    } else {
                        if (txt_Total.text.toString().isEmpty()) {
                            Toast.makeText(this, "Ingrese el total a pagar ", Toast.LENGTH_SHORT).show()
                        } else {
                            val parametro = StringBuilder()
                            num += 1
                            parametro.append("DATOS FACTURA").append("|")
                            parametro.append(txt_CodigoPedido.text.toString().trim()).append("|")
                            parametro.append(spinner_menusPe.selectedItem.toString().trim()).append("|")
                            parametro.append(txt_Clientefa.text.toString().trim()).append("|")
                            parametro.append(txt_EmpleadoFa.text.toString().trim()).append("|")
                            parametro.append(txt_Total.text.toString().trim()).append("|")
                            datos_Factura.put(num, parametro.toString())
                            println(datos_Factura.toString())
                            Toast.makeText(this, "Factura Realizada", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    fun regresar() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}