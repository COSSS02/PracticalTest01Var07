package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MessageBroadcastReceiver() : BroadcastReceiver() {
    public var nr1 : Int? = 0
    public var nr2 : Int? = 0
    public var nr3 : Int? = 0
    public var nr4 : Int? = 0

    override fun onReceive(context: Context?, intent: Intent?) {
        nr1 = intent?.getIntExtra("nr1", 0)
        nr2 = intent?.getIntExtra("nr2", 0)
        nr3 = intent?.getIntExtra("nr3", 0)
        nr4 = intent?.getIntExtra("nr4", 0)

        Log.d("Broadcast", "nr1=$nr1 nr2=$nr2 nr3=$nr3 nr4=$nr4 ")

//        PracticalTest01Var07MainActivity.updateNums(nr1,nr2,nr3,nr4)
    }
}