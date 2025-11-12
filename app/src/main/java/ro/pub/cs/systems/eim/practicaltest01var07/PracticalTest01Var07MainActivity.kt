package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var07MainActivity : AppCompatActivity() {
    private var text1: EditText? = null
    private var text2: EditText? = null
    private var text3: EditText? = null
    private var text4: EditText? = null
    private var setButton: Button? = null
    private var randomButton: Button? = null
    private var serviceOff = true
//    private val messageBroadcastReceiver = MessageBroadcastReceiver()
    private var intentFilter: IntentFilter? = IntentFilter()

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

//        if (savedInstanceState != null) {
//            Log.d("onCreate", "savedInstanceState is not null")
//            if(savedInstanceState.containsKey("left_edit_text")) {
//                leftEditText?.setText(savedInstanceState.getString("left_edit_text"))
//            } else {
//                leftEditText?.setText("0")
//            }
//
//            if(savedInstanceState.containsKey("right_edit_text")) {
//                rightEditText?.setText(savedInstanceState.getString("right_edit_text"))
//            } else {
//                rightEditText?.setText("0")
//            }
//        } else {
//            Log.d("onCreate", "savedInstanceState is null")
//            leftEditText?.setText("0")
//            rightEditText?.setText("0")
//        }
    }

    private inner class ButtonClickListener : View.OnClickListener {
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
                    if (!s1.isEmpty() || s1.toDouble().isNaN()) {
                        text1?.setText((0..100).random().toString())
                    }

                    val s2 = text2?.text.toString()
                    if (!s2.isEmpty() || s2.toDouble().isNaN()) {
                        text2?.setText((0..100).random().toString())
                    }

                    val s3 = text3?.text.toString()
                    if (!s3.isEmpty() || s3.toDouble().isNaN()) {
                        text3?.setText((0..100).random().toString())
                    }

                    val s4 = text4?.text.toString()
                    if (!s4.isEmpty() || s4.toDouble().isNaN()) {
                        text4?.setText((0..100).random().toString())
                    }
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

//    override fun onSaveInstanceState(outState: Bundle) {
//        Log.d("onSaveInstanceState", "Saving instance state")
//        super.onSaveInstanceState(outState)
//        outState.putString("left_edit_text", leftEditText?.text.toString())
//        outState.putString("right_edit_text", rightEditText?.text.toString())
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        Log.d("onRestoreInstanceState", "Restoring instance state")
//        super.onRestoreInstanceState(savedInstanceState)
//        if(savedInstanceState.containsKey("left_edit_text")) {
//            leftEditText?.setText(savedInstanceState.getString("left_edit_text"))
//        }
//        if(savedInstanceState.containsKey("right_edit_text")) {
//            rightEditText?.setText(savedInstanceState.getString("right_edit_text"))
//        }
//    }
//
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result $resultCode", Toast.LENGTH_LONG).show()
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