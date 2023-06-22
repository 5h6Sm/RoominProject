package com.example.roomins

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.roomins.R
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

class HomeFragment : Fragment() {

    private lateinit var button: ImageButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_home, container, false)

        val qrCodeText = "내용을 포함시킬 QR 코드 정보"
        val qrCodeWidth = 500
        val qrCodeHeight = 500

        val qrCodeImageView: ImageView = view.findViewById(R.id.qr_back)
        val qrCodeBitmap = generateQRCode(qrCodeText, qrCodeWidth, qrCodeHeight)
        qrCodeImageView.setImageBitmap(qrCodeBitmap)

        val hotel = view.findViewById<ImageButton>(R.id.myhotel)
        hotel.setOnClickListener {
            val intent = Intent(getContext(), RegisteredHotelInput::class.java)
            startActivity(intent)

        }


        qrCodeImageView.visibility = View.GONE

        var button = view.findViewById<ImageButton>(R.id.button6)

        button.setOnClickListener{
            qrCodeImageView.visibility = View.VISIBLE
        }
        qrCodeImageView.setOnClickListener{
            qrCodeImageView.visibility = View.GONE
        }

        return view
    }
}
