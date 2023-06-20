package com.example.roomins

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment

//import android.graphics.Bitmap
//import android.graphics.Color
//import android.os.Bundle
//import android.view.View
//import android.widget.ImageView
//import androidx.fragment.app.Fragment
//import com.google.zxing.BarcodeFormat
//import com.google.zxing.MultiFormatWriter
//import com.google.zxing.WriterException
//import com.google.zxing.common.BitMatrix
//import com.google.zxing.qrcode.QRCodeWriter
//
//fun generateQRCode(text: String, width: Int, height: Int): Bitmap? {
//    try {
//        val bitMatrix: BitMatrix = QRCodeWriter().encode(
//            text,
//            BarcodeFormat.QR_CODE,
//            width,
//            height
//        )
//        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
//        for (x in 0 until width) {
//            for (y in 0 until height) {
//                bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
//            }
//        }
//        return bitmap
//    } catch (e: WriterException) {
//        e.printStackTrace()
//    }
//    return null
//}
//
class HomeFragment : Fragment(R.layout.fragment_home){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}