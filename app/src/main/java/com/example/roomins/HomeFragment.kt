import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.roomins.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 이미지뷰 가져오기
        val imageView: ImageView = view.findViewById(R.id.hotel_imageview)

        // 이미지뷰를 맨 앞으로 가져오기
        imageView.bringToFront()
    }
}
