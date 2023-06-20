package com.example.roomins

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import com.google.zxing.BarcodeFormat
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter

fun generateQRCode(text: String, width: Int, height: Int): Bitmap? {
    try {
        val bitMatrix: BitMatrix = QRCodeWriter().encode(
            text,
            BarcodeFormat.QR_CODE,
            width,
            height
        )
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
            }
        }
        return bitmap
    } catch (e: WriterException) {
        e.printStackTrace()
    }
    return null
}

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val qrCodeText = "내용을 포함시킬 QR 코드 정보"
        val qrCodeWidth = 500
        val qrCodeHeight = 500

        val qrCodeImageView: ImageView = findViewById(R.id.qr_back)
        val qrCodeBitmap = generateQRCode(qrCodeText, qrCodeWidth, qrCodeHeight)
        qrCodeImageView.setImageBitmap(qrCodeBitmap)

        qrCodeImageView.visibility = View.GONE

//        var button
    }


}
