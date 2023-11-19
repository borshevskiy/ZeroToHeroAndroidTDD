package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        savedInstanceState?.let {
            counter = it.getString("counter")?.toInt() ?: 0
            checkButtonVisibility()
            binding.countTextView.text = it.getString("counter") }
        binding.incrementButton.setOnClickListener {
            counter += 2
            binding.countTextView.text = counter.toString()
            checkButtonVisibility()
        }
    }

    private fun checkButtonVisibility() {
        binding.incrementButton.isEnabled = counter != 4
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("counter", counter.toString())
    }
}