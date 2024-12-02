package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.mariuszgromada.math.mxparser.Expression
import android.util.TypedValue


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn1 = findViewById<Button>(R.id.btn_um)
        val btn2 = findViewById<Button>(R.id.btn_dois)
        val btn3 = findViewById<Button>(R.id.btn_tres)
        val btn4 = findViewById<Button>(R.id.btn_quatro)
        val btn5 = findViewById<Button>(R.id.btn_cinco)
        val btn6 = findViewById<Button>(R.id.btn_seis)
        val btn7 = findViewById<Button>(R.id.btn_sete)
        val btn8 = findViewById<Button>(R.id.btn_oito)
        val btn9 = findViewById<Button>(R.id.btn_nove)
        val btn0 = findViewById<Button>(R.id.btn_zero)
        val btnPonto = findViewById<Button>(R.id.btn_ponto)
        val btnParenteseA = findViewById<ImageButton>(R.id.btn_parentese1)
        val btnParenteseF = findViewById<ImageButton>(R.id.btn_parentese2)
        val btnVoltar = findViewById<ImageButton>(R.id.img_btn_apagar1)
        val btnApagar = findViewById<ImageButton>(R.id.btn_deletar)
        val btnMult = findViewById<Button>(R.id.btn_mult)
        val btnMenos = findViewById<Button>(R.id.btn_menos)
        val btnMais = findViewById<Button>(R.id.btn_mais)
        val btnDiv = findViewById<Button>(R.id.btn_divisao)
        val btnCalc = findViewById<Button>(R.id.btn_igual)

        val tvResultado = findViewById<TextView>(R.id.tv_resultado)
        val tvConta = findViewById<TextView>(R.id.tv_conta)



        btn1.setOnClickListener(){
            tvConta.text = "${tvConta.text}1"
        }
        btn2.setOnClickListener(){
            tvConta.text = "${tvConta.text}2"
        }
        btn3.setOnClickListener(){
            tvConta.text = "${tvConta.text}3"
        }
        btn4.setOnClickListener(){
            tvConta.text = "${tvConta.text}4"
        }
        btn5.setOnClickListener(){
            tvConta.text = "${tvConta.text}5"
        }
        btn6.setOnClickListener(){
            tvConta.text = "${tvConta.text}6"
        }
        btn7.setOnClickListener(){
            tvConta.text = "${tvConta.text}7"
        }
        btn8.setOnClickListener(){
            tvConta.text = "${tvConta.text}8"
        }
        btn9.setOnClickListener(){
            tvConta.text = "${tvConta.text}9"
        }
        btn0.setOnClickListener(){
            tvConta.text = "${tvConta.text}0"
        }
        btnPonto.setOnClickListener(){
            tvConta.text = "${tvConta.text}."
        }
        btnParenteseA.setOnClickListener(){
            tvConta.text = "${tvConta.text}("
        }
        btnParenteseF.setOnClickListener(){
            tvConta.text = "${tvConta.text})"
        }
        btnVoltar.setOnClickListener(){
            tvConta.text = tvConta.text.dropLast(1)
        }
        btnApagar.setOnClickListener(){
            tvConta.text = ""
            tvResultado.text = ""
            tvConta.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40f)
        }
        btnMult.setOnClickListener(){
            tvConta.text = "${tvConta.text}*"
        }
        btnDiv.setOnClickListener(){
            tvConta.text = "${tvConta.text}/"
        }
        btnMais.setOnClickListener() {
            tvConta.text = "${tvConta.text}+"
        }
        btnMenos.setOnClickListener(){
            tvConta.text = "${tvConta.text}-"
        }
        btnCalc.setOnClickListener(){
            val resultadoCalculado = Expression(tvConta.text.toString()).calculate()
            tvConta.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)

            if (resultadoCalculado.isNaN()){
                tvResultado.text = "Expressão invalida"
            }else {

                tvResultado.text = "${resultadoCalculado.toString()}"
            }
        }

    }
}