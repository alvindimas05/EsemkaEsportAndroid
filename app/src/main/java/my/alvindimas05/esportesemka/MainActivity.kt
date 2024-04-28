package my.alvindimas05.esportesemka

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import my.alvindimas05.esportesemka.adapter.MainPagerAdapter
import my.alvindimas05.esportesemka.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainPagerAdapter: MainPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainPagerAdapter = MainPagerAdapter(this)
        binding.viewpager.adapter = mainPagerAdapter

        binding.tablayout.addTab(binding.tablayout.newTab().setText("Tim"))
        binding.tablayout.addTab(binding.tablayout.newTab().setText("Pemain"))
        binding.tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(p0: TabLayout.Tab?) {
                if (p0 != null) binding.viewpager.currentItem = p0.position
            }
            override fun onTabUnselected(p0: TabLayout.Tab?) {}
            override fun onTabReselected(p0: TabLayout.Tab?) {}
        })

        val date = SimpleDateFormat("EEEE, dd MMMM y hh:mm:ss a", Locale.getDefault())
        binding.currentDate.text = date.format(Date())
    }
}