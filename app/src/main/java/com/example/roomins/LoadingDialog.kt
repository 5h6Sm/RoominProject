import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import com.example.roomins.R

class LoadingDialog(context: Context) : Dialog(context) {
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_loading)
        window?.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        setCancelable(false)

        val messageTextView: TextView = findViewById(R.id.text_message)
        messageTextView.text = "서비스 준비 중입니다"
    }

    override fun show() {
        super.show()
        handler.postDelayed({ dismiss() }, 1000) // 2초 후에 dismiss() 실행
    }

    override fun dismiss() {
        handler.removeCallbacksAndMessages(null) // 지연 실행 취소
        super.dismiss()
    }
}
