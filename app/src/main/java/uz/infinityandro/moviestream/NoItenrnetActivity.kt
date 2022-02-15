package uz.infinityandro.moviestream

import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.infinityandro.moviestream.util.InternetBroadCast

class NoItenrnetActivity : AppCompatActivity() {
    private val receiver = InternetBroadCast()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_itenrnet)
//        applicationContext.registerReceiver(receiver, IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION))
//        receiver.setListener {
//            if (it){
//                Intent(applicationContext,MainActivity::class.java).let {
//                    startActivity(it)
//                    finish()
//                }
//            }else{
//
//            }
//        }
    }
}