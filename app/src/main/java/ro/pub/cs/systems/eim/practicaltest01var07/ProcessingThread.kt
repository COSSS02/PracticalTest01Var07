package ro.pub.cs.systems.eim.practicaltest01var07

import android.content.Context
import android.content.Intent
import android.util.Log

class ProcessingThread(private val context: Context) : Thread() {
    private var isRunning = true
    private var random = java.util.Random()

    override fun run() {
        Log.d("Thread", "Thread.run() was invoked, PID: ${android.os.Process.myPid()} TID: ${android.os.Process.myTid()}")
        while (isRunning) {
            sendMessage()
            sleep()
        }
    }

    private fun sendMessage() {
        val intent = Intent()
        intent.setAction("BROADCAST_ACTION")
        intent.putExtra(
            "nr1",
            random.nextInt(100)
        )
        intent.putExtra(
            "nr2",
            random.nextInt(100)
        )
        intent.putExtra(
            "nr3",
            random.nextInt(100)
        )
        intent.putExtra(
            "nr4",
            random.nextInt(100)
        )
        context.sendBroadcast(intent)
    }

    private fun sleep() {
        try {
            sleep(10000)
        } catch (interruptedException: InterruptedException) {
            interruptedException.printStackTrace()
        }
    }

    public fun stopThread() {
        isRunning = false
    }
}