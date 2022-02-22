package com.lulu.imageviewmatrix

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint

/**
 * @author zhanglulu
 */
object MatrixUtil {
    /**
     * 3D 倾斜书封效果
     */
    fun convert3DBookCover(originBitmap: Bitmap, delta: Float): Bitmap {
        //创建一个与bitmap一样大小的bitmap2
        val destBitmap = Bitmap.createBitmap(originBitmap.width, originBitmap.height, originBitmap.config)
        val canvas = Canvas(destBitmap)
        //主要以这个对象调用旋转方法
        val matrix = Matrix()

        val bw = originBitmap.width
        val bh = originBitmap.height
        val src = floatArrayOf(
            0f, 0f,                    // 左上
            0f, bh.toFloat(),          // 左下
            bw.toFloat(), bh.toFloat(),// 右下
            bw.toFloat(), 0f           // 右上
        )
        val dst = floatArrayOf(
            0f, 0 + delta,
            0f, bh - delta,
            bw.toFloat(), bh.toFloat(),
            bw.toFloat(), 0f
        )
        matrix.setPolyToPoly(src, 0, dst, 0, 4)

        val paint = Paint()
        //设置抗锯齿,防止过多的失真
        paint.isAntiAlias = true
        canvas.drawBitmap(originBitmap, matrix, paint)
        return destBitmap
    }
}