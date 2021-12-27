package com.fq.navigationtutorial

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.fq.navigationtutorial.databinding.FragmentDragAndDropBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DragAndDropFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DragAndDropFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentDragAndDropBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_drag_and_drop, container, false)
        binding = FragmentDragAndDropBinding.inflate(inflater, container, false)
        attachOnDragListener()
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        attachOnDragListener()
//    }

    private fun setClickListenerToImage(imageView: ImageView, dataText: String) {
        imageView.setOnLongClickListener {
            val item = ClipData.Item(dataText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(dataText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true
        }
    }

    private fun setDragListenerToArea(constraintLayout: ConstraintLayout) {
        constraintLayout.setOnDragListener(dragListener)
    }

    private fun attachOnDragListener() {
        setDragListenerToArea(binding.imageSourceArea)
        setDragListenerToArea(binding.imageDropAreaOne)
        setDragListenerToArea(binding.imageDropAreaTwo)
        setDragListenerToArea(binding.imageDropAreaThree)
        setDragListenerToArea(binding.imageDropAreaFour)

        setClickListenerToImage(binding.dragView, "Test ClipData text")
        setClickListenerToImage(binding.dragImageView, "Image view text")
        setClickListenerToImage(binding.dragImageView2, "Orange ball text")
        setClickListenerToImage(binding.dragCoffeeImageView, "Coffee image text")
    }

    private fun setAlphaValue(value: Float) {
        binding.cardAreaOne.alpha = value
        binding.cardAreaTwo.alpha = value
        binding.cardAreaThree.alpha = value
        binding.cardAreaFour.alpha = value
    }

    private val dragListener = View.OnDragListener { view, dragEvent ->
        when(dragEvent.action){
            DragEvent.ACTION_DRAG_STARTED -> {
                dragEvent.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                setAlphaValue(0.5f)
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                setAlphaValue(1.0f)
                val item = dragEvent.clipData.getItemAt(0)
                val dragData = item.text

                view.invalidate()

                val v = dragEvent.localState as View
                val owner = v.parent as ViewGroup
                owner.removeView(v)

                val destination = view as ConstraintLayout //RelativeLayout //LinearLayout
                destination.addView(v)
                v.visibility = View.VISIBLE

                var draggedObject = when(dragData.toString()) {
                    "Test ClipData text" -> "Black Box"
                    "Image view text" -> "Ball Image"
                    "Orange ball text" -> "Orange Ball"
                    "Coffee image text" -> "Coffee Image"
                    else -> ""
                }

                if(destination == binding.imageDropAreaOne && draggedObject == "Black Box" ||
                    destination == binding.imageDropAreaTwo && draggedObject == "Ball Image") {
                    Toast.makeText(this@DragAndDropFragment.context, "Correct: $draggedObject", Toast.LENGTH_SHORT).show()
                    //binding.dragView.setImageResource(R.drawable.bar)
                }
                else if(destination == binding.imageSourceArea) {
                    Toast.makeText(this@DragAndDropFragment.context, "Let's try again!", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this@DragAndDropFragment.context, "Wrong object: $draggedObject", Toast.LENGTH_SHORT).show()
                }

                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                view.invalidate()
                true
            }
            else -> false
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DragAndDropFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DragAndDropFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}