package uz.infinityandro.moviestream

import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import uz.infinityandro.moviestream.util.InternetBroadCast

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val receiver = InternetBroadCast()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

//        applicationContext.registerReceiver(receiver, IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION))
//        receiver.setListener {
//            if (it){
//
//            }else{
//                Intent(applicationContext,NoItenrnetActivity::class.java).let {
//                    startActivity(it)
//                    finish()
//                }
//            }
//        }
    }
}