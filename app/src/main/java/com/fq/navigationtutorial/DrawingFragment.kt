package com.fq.navigationtutorial

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.fq.navigationtutorial.databinding.DrawingFragmentBinding

class DrawingFragment : Fragment() {

    private lateinit var binding: DrawingFragmentBinding
    private lateinit var drawingViewModel: DrawingViewModel
    private var isGreenBkg: Boolean = true

    companion object {
        fun newInstance() = DrawingFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.drawing_fragment, container, false)
        binding = DrawingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(DrawingViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        drawingViewModel = ViewModelProvider(this).get(DrawingViewModel::class.java)

        binding.colourButton.setOnClickListener {
            // change dynamically the background tint colour of an object
            ViewCompat.setBackgroundTintList(binding.colourButton, ContextCompat.getColorStateList(binding.colourButton.context, android.R.color.holo_red_dark))
            binding.drawingView.paint.color = Color.GREEN
            binding.colourButton.text = "RED"

            if (!isGreenBkg) {
                ViewCompat.setBackgroundTintList(binding.colourButton, ContextCompat.getColorStateList(binding.colourButton.context, android.R.color.holo_green_dark))
                binding.drawingView.paint.color = Color.RED
                binding.colourButton.text = "GREEN"
            }
            isGreenBkg = !isGreenBkg
        }

        binding.randomTextButton.setOnClickListener {
            var randomInt = (0..5).random()
            var languages = arrayOf("Java", "PHP", "Kotlin", "Javascript", "Python", "Swift")
            binding.randomTextView.text = languages[randomInt]
        }

        binding.clearButton.setOnClickListener {
            binding.drawingView.clearCanvas()

//            // pop up test
//            val intent = Intent(this@DrawingFragment.context, PopUpWindow::class.java)
//            intent.putExtra("popuptitle", "Error")
//            intent.putExtra("popuptext", "Sorry, that email address is already used!")
//            intent.putExtra("popupbtn", "OK")
//            intent.putExtra("darkstatusbar", false)
//            startActivity(intent)
        }
    }
}