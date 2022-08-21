package dev.marawanxmamdouh.animation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.marawanxmamdouh.animation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)



        setContentView(binding.root)
    }
}