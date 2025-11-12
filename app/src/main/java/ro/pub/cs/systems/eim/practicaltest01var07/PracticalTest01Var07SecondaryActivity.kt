package ro.pub.cs.systems.eim.practicaltest01var07

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var07SecondaryActivity : AppCompatActivity() {
    private var text1: EditText? = null
    private var text2: EditText? = null
    private var text3: EditText? = null
    private var text4: EditText? = null
    private var sumButton: Button? = null
    private var productButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var07_secondary)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.secondary_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)
        text3 = findViewById(R.id.text3)
        text4 = findViewById(R.id.text4)

        val intent = intent
        if (intent != null && intent.hasExtra("numberOfClicks")) {
            val nr1 = intent.getDoubleExtra("text1", 0.0)
            text1?.setText(nr1.toString())
            val nr2 = intent.getDoubleExtra("text2", 0.0)
            text2?.setText(nr2.toString())
            val nr3 = intent.getDoubleExtra("text3", 0.0)
            text3?.setText(nr3.toString())
            val nr4 = intent.getDoubleExtra("text4", 0.0)
            text4?.setText(nr4.toString())
        }

        sumButton = findViewById(R.id.sum_button)
        sumButton?.setOnClickListener(ButtonClickListener())
        productButton = findViewById(R.id.product_button)
        productButton?.setOnClickListener(ButtonClickListener())
    }

    private inner class ButtonClickListener : View.OnClickListener {
        override fun onClick(view: android.view.View?) {
            when (view?.id) {
                R.id.sum_button -> {
                    val sum = (text1?.text.toString().toDouble()) +
                              (text2?.text.toString().toDouble()) +
                              (text3?.text.toString().toDouble()) +
                              (text4?.text.toString().toDouble())
                    setResult(sum.toInt(), null)
                }
                R.id.product_button -> {
                    val product = (text1?.text.toString().toDouble()) *
                                  (text2?.text.toString().toDouble()) *
                                  (text3?.text.toString().toDouble()) *
                                  (text4?.text.toString().toDouble())
                    setResult(product.toInt(), null)
                }
            }
            finish()
        }
    }
}