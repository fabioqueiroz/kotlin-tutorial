package com.fq.navigationtutorial

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.fq.navigationtutorial.databinding.FragmentSecondBlankBinding
import com.fq.navigationtutorial.databinding.FragmentSoundsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SoundsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SoundsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentSoundsBinding
    private lateinit var catFightMedia : MediaPlayer
    private lateinit var ballImage: ImageView

    @SuppressLint("ClickableViewAccessibility")
    val listener = View.OnTouchListener { view, motionEvent ->
        if (motionEvent.action == MotionEvent.ACTION_MOVE) {
            view.y = motionEvent.rawY - view.height/2
            view.x = motionEvent.rawX - view.width/2
        }
        true
    }

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
        //return inflater.inflate(R.layout.fragment_sounds, container, false)
        binding = FragmentSoundsBinding.inflate(inflater, container, false)
        binding.ballImageView.setOnTouchListener(listener)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //var catFightMedia = MediaPlayer.create(requireActivity(), R.raw.cat_fight)
        catFightMedia = MediaPlayer.create(requireActivity(), R.raw.cat_fight)
        binding.fightImageButton.setOnClickListener {
            catFightMedia.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        catFightMedia.release()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SoundsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SoundsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}