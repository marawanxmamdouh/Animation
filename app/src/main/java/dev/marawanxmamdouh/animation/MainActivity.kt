package dev.marawanxmamdouh.animation

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dev.marawanxmamdouh.animation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)

        binding.rotateButton.setOnClickListener {
            rotate()
        }

        binding.translateButton.setOnClickListener {
            translate()
        }

        setContentView(binding.root)
    }

    private fun ObjectAnimator.disableViewDuringAnimation(view: View) {
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                view.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                view.isEnabled = true
            }
        })
    }

    private fun rotate() {
        val animator = ObjectAnimator.ofFloat(binding.star, View.ROTATION, -360f, 0f)
        animator.duration = 1000
        animator.disableViewDuringAnimation(binding.rotateButton)
        animator.start()
    }

    private fun translate() {
        val animator = ObjectAnimator.ofFloat(binding.star, View.TRANSLATION_X, 300f)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.disableViewDuringAnimation(binding.translateButton)
        animator.start()
    }

}