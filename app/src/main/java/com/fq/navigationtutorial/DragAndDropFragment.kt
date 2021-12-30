package com.fq.navigationtutorial

import android.R
import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipDescription
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
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
    private lateinit var imageSpinner: Spinner
    private lateinit var selectedTopic: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        (activity as MainActivity)?.setActionBarTitle("Cell Biology Test")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDragAndDropBinding.inflate(inflater, container, false)
        attachOnDragListener()
        assignQuestionTexts()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSpinner = binding.imageSelectorSpinner
        setSpinnerLayout(imageSpinner)
        binding.imageSelectorButton.setOnClickListener {
//            selectedTopic = imageSpinner.selectedItem.toString()
//            getImagesByTopic(selectedTopic)
            getImagesByTopic(imageSpinner.selectedItem.toString())
        }
    }
    //TODO: complete method
    private fun getImagesByTopic(topic: String) {
        when(topic) {
            "Cell organelles" -> setImages(Topic.CELL_ORGANELLES)
            "Topic 2" -> setImages(Topic.TOPIC_2)
            "Topic 3" -> setImages(Topic.TOPIC_3)
            else -> null
        }
    }
    //TODO: complete method
    private fun setImages(topic: Topic) {
        var imageOne: ImageView
        var imageTwo: Drawable?
        var imageThree: Drawable?
        var imageFour: Drawable?

        when(topic) {
            Topic.CELL_ORGANELLES -> {
                //R.drawable.
            }

        }

        //binding.dragImageView.setImageResource()
    }

    //TODO: move to a helper class
    private fun setSpinnerLayout(spinner: Spinner): Unit {
        with(spinner)
        {
            adapter = adapterFactory(spinner)
            setSelection(0, false)
            prompt = "Select the topic"
            gravity = android.view.Gravity.CENTER
        }
    }
    //TODO: move to a helper class
    private fun adapterFactory(spinner: Spinner): ArrayAdapter<String> {
        var spinnerOptions = when(spinner){
            imageSpinner -> Data.getImageSpinnerOptions()
            else -> arrayOf()
        }

        var adapter = ArrayAdapter(spinner.context, R.layout.simple_spinner_item, spinnerOptions)
        adapter.setDropDownViewResource(R.layout.select_dialog_singlechoice)

        return adapter
    }

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

        setClickListenerToImage(binding.dragImageView, "ImageOneData")
        setClickListenerToImage(binding.dragImageView2, "ImageTwoData")
        setClickListenerToImage(binding.dragImageView3, "ImageThreeData")
        setClickListenerToImage(binding.dragImageView4, "ImageFourData")
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

                val destination = view as ConstraintLayout
                destination.addView(v)
                v.visibility = View.VISIBLE

                var draggedObject = when(dragData.toString()) {
                    "ImageOneData" -> "Golgi Apparatus"
                    "ImageTwoData" -> "Mitochondria"
                    "ImageFourData" -> "Nucleus"
                    "ImageThreeData" -> "Ribosomes"
                    else -> ""
                }

                if(destination == binding.imageDropAreaOne && draggedObject == "Golgi Apparatus" ||
                    destination == binding.imageDropAreaTwo && draggedObject == "Mitochondria" ||
                    destination == binding.imageDropAreaThree && draggedObject == "Ribosomes" ||
                    destination == binding.imageDropAreaFour && draggedObject == "Nucleus") {
                    Toast.makeText(this@DragAndDropFragment.context, "Correct, it's the $draggedObject!", Toast.LENGTH_SHORT).show()
                }
                else if(destination == binding.imageSourceArea) {
                    Toast.makeText(this@DragAndDropFragment.context, "Let's try again!", Toast.LENGTH_SHORT).show()
                }
                else {
                    Toast.makeText(this@DragAndDropFragment.context, "Wrong answer: $draggedObject", Toast.LENGTH_SHORT).show()
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

    private fun assignQuestionTexts() {
        var data = Data.getDragOptionsQuestions()
        displayQuestionDialog(binding.cardAreaOneButton, "1. Question One", data[0])
        displayQuestionDialog(binding.cardAreaTwoButton, "2. Question Two", data[1])
        displayQuestionDialog(binding.cardAreaThreeButton, "3. Question Three", data[2])
        displayQuestionDialog(binding.cardAreaFourButton, "3. Question Three", data[3])
    }

    private fun displayQuestionDialog(button: Button, title: String, message: String) {
        button.setOnClickListener {
            val builder = this.context?.let { it -> AlertDialog.Builder(it) }
            builder?.setTitle(title)
            builder?.setMessage(message)
            builder?.setNegativeButton("Close") { dialog, id ->
                //Toast.makeText(this.context,"No", Toast.LENGTH_SHORT).show()
            }
            builder?.show()
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