package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var remove = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        savedInstanceState?.let { if(it.getBoolean("removed")) {
            binding.rootLayout.removeView(binding.titleTextView)
            binding.removeButton.isEnabled = false
            }
        }
        binding.removeButton.setOnClickListener {
            remove = !remove
            binding.rootLayout.removeView(binding.titleTextView)
            binding.removeButton.isEnabled = !remove
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("removed", remove)
    }
}