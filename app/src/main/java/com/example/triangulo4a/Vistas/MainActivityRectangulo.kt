package com.example.triangulo4a.Vistas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.triangulo4a.Contratos.ContratoRectangulo
import com.example.triangulo4a.Presentador.RectanguloPresenter
import com.example.triangulo4a.R
import kotlin.toString

class MainActivityRectangulo : AppCompatActivity(), ContratoRectangulo.Vista {
    private lateinit var txvResultado: TextView;
    private lateinit var presentador: ContratoRectangulo.Presentador;

    fun setPresentador(presentador: ContratoRectangulo.Presentador){
        this.presentador=presentador;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        enableEdgeToEdge();
        setContentView(R.layout.activity_main_rectangulo);

        val txtBase: EditText =findViewById<EditText>(R.id.edtbase);
        val txtAltura: EditText =findViewById<EditText>(R.id.edtaltura);
        val btnArea: Button =findViewById<Button>(R.id.btnArea);
        val btnPerimetro: Button =findViewById<Button>(R.id.btnPerimetro);
        txvResultado=findViewById<TextView>(R.id.txvRes);

        presentador = RectanguloPresenter(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            insets
        }

        btnArea.setOnClickListener{
            val base=txtBase.text.toString().toFloat();
            val altura=txtAltura.text.toString().toFloat();
            presentador.area(base,altura);
        }

        btnPerimetro.setOnClickListener{
            val base=txtBase.text.toString().toFloat();
            val altura=txtAltura.text.toString().toFloat();
            presentador.perimetro(base,altura);
        }
    }

    override fun showArea(area: Float) {
        txvResultado.text="El area es ${area}";
    }
    override fun showPerimetro(perimetro: Float) {
        txvResultado.text="El perimetro es ${perimetro}";
    }
    override fun showError(msg: String) {
        txvResultado.text = msg
    }
}