package com.lulu.imageviewmatrix

import android.content.res.Resources
import android.graphics.*
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btDelta.setOnClickListener {
            setImageView(etDelta.text.toString().toFloat())
        }
        setImageView(10f)
    }

    private fun setImageView(deltaDx: Float) {
        ivCover.setImageBitmap(
            MatrixUtil.convert3DBookCover(
                BitmapFactory.decodeResource(
                    resources,
                    R.mipmap.cover_10
                ), dp2px(deltaDx).toFloat()
            )
        )
    }


    private fun dp2px(dipValue: Float): Int {
        val resources = Resources.getSystem()
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dipValue, resources.displayMetrics
        ).toInt()
    }
}