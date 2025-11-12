package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.toString

class PracticalTest01Var07MainActivity : AppCompatActivity() {
    private var text1: EditText? = null
    private var text2: EditText? = null
    private var text3: EditText? = null
    private var text4: EditText? = null
    private var setButton: Button? = null
    private var randomButton: Button? = null
    private var checkButton: Button? = null
    private var random = java.util.Random()
    private var serviceOff = true
//    private val messageBroadcastReceiver = MessageBroadcastReceiver()
    private var intentFilter: IntentFilter? = IntentFilter()
    private var result: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var07_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        for (action in Constants.ACTION_TYPES) {
//            intentFilter?.addAction(action)
//        }

        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)
        text3 = findViewById(R.id.text3)
        text4 = findViewById(R.id.text4)

        setButton     = findViewById(R.id.set_button)
        setButton?.setOnClickListener(ButtonClickListener())

        randomButton  = findViewById(R.id.random_button)
        randomButton?.setOnClickListener(ButtonClickListener())

        checkButton  = findViewById(R.id.check_result)
        checkButton?.setOnClickListener(ButtonClickListener())

        if (savedInstanceState != null) {
            Log.d("onCreate", "savedInstanceState is not null")
            if(savedInstanceState.containsKey("result")) {
                result = (savedInstanceState.getInt("result"))
        }
    }
    }

    private inner class ButtonClickListener : View.OnClickListener {
        @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
        override fun onClick(view: android.view.View?) {
            when (view?.id) {
                R.id.set_button -> {
                    val intent = Intent(
                        this@PracticalTest01Var07MainActivity,
                        PracticalTest01Var07SecondaryActivity::class.java
                    )
                    intent.putExtra("text1", text1?.text.toString())
                    intent.putExtra("text2", text2?.text.toString())
                    intent.putExtra("text3", text3?.text.toString())
                    intent.putExtra("text4", text4?.text.toString())
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE)
                }
                R.id.random_button -> {
                    val s1 = text1?.text.toString()
                    if (s1.toDoubleOrNull() == null) {
                        text1?.setText(random.nextDouble(10.0).toString())
                    }

                    val s2 = text2?.text.toString()
                    if (s2.toDoubleOrNull() == null) {
                        text2?.setText(random.nextDouble(10.0).toString())
                    }

                    val s3 = text3?.text.toString()
                    if (s3.toDoubleOrNull() == null) {
                        text3?.setText(random.nextDouble(10.0).toString())
                    }

                    val s4 = text4?.text.toString()
                    if (s4.toDoubleOrNull() == null) {
                        text4?.setText(random.nextDouble(10.0).toString())
                    }
                }

                R.id.check_result -> {
                    Toast.makeText(this@PracticalTest01Var07MainActivity, "The activity returned with result $result", Toast.LENGTH_LONG).show()
                    Log.d("result", "Result is $result")
                }
            }

//            if(leftClicks+rightClicks >= Constants.THRESHOLD && serviceOff) {
//                intent = Intent(this@PracticalTest01MainActivity, PracticalTest01Service::class.java)
//                intent.putExtra("firstNumber", leftClicks.toString())
//                intent.putExtra("secondNumber", rightClicks.toString())
//                startService(intent)
//                serviceOff= true
//            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("onSaveInstanceState", "Saving instance state")
        super.onSaveInstanceState(outState)
        outState.putInt("result", result)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d("onRestoreInstanceState", "Restoring instance state")
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState.containsKey("result")) {
            result = (savedInstanceState.getInt("result"))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result $resultCode", Toast.LENGTH_LONG).show()
            Log.d("result","Result is $resultCode")
            result = resultCode
        }
    }
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    override fun onResume() {
//        super.onResume()
//        registerReceiver(messageBroadcastReceiver, intentFilter, RECEIVER_EXPORTED)
//    }
//
//    override fun onPause() {
//        unregisterReceiver(messageBroadcastReceiver)
//        super.onPause()
//    }
//
//    override fun onDestroy() {
//        Log.d("onDestroy", "The activity is being destroyed.")
//        intent = Intent(this@PracticalTest01MainActivity, PracticalTest01Service::class.java)
//        stopService(intent)
//        super.onDestroy()
//    }
}