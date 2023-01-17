package com.usb.androidtestmominul

import android.os.Build
import android.os.Bundle
import android.view.ViewGroup.MarginLayoutParams
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.usb.androidtestmominul.databinding.ActivityFullScreenBinding


class FullScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFullScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            window.setDecorFitsSystemWindows(true)
//            if (window.insetsController != null) {
//                window.insetsController?.show(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
//            }
//        } else {
//            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE;
//        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {

            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        setMargin()

        setContentView(binding.root)
    }

    private fun setMargin() {
        val bottomNavHeight = resources.getDimensionPixelSize(
            resources.getIdentifier(
                "navigation_bar_height",
                "dimen",
                "android"
            )
        )
        val params = binding.bottomNavigation.layoutParams as MarginLayoutParams
        params.bottomMargin = bottomNavHeight
    }
}