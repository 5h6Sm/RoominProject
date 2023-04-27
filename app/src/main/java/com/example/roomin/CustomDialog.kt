package com.example.roomin

import android.app.ActionBar.LayoutParams
import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import com.example.roomins.R

class CustomDialog(context: Context) {
    private val dialog = Dialog(context);

    fun myDig(){
        dialog.setContentView(R.layout.custom_dialog_screen)

        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.show();
    }
}