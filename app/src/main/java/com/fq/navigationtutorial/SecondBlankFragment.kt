package com.fq.navigationtutorial

import android.R
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fq.navigationtutorial.databinding.FragmentSecondBlankBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondBlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondBlankFragment : Fragment(), AdapterView.OnItemSelectedListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentSecondBlankBinding
    private lateinit var textViewModel: TextViewModel
    private lateinit var testSpinner: Spinner
    private lateinit var test2Spinner: Spinner
    private lateinit var test3Spinner: Spinner

    var languages = arrayOf("Java", "PHP", "Kotlin", "Javascript", "Python", "Swift")

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
        //return inflater.inflate(R.layout.fragment_second_blank, container, false)
        binding = FragmentSecondBlankBinding.inflate(inflater, container, false)

        test3Spinner = Spinner(binding.test3Spinner.context)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewModel = ViewModelProvider(requireActivity()).get(TextViewModel::class.java)
        var myModel = textViewModel.myLiveModel.value

        textViewModel.myLiveModel.observe(viewLifecycleOwner, Observer {
            if(myModel != null)
            {
                binding.textView2.text ="Name: " + myModel.name + ", age: " + myModel.age
            }
        })

        testSpinner = binding.testSpinner
        test2Spinner = binding.test2Spinner

        test3Spinner = binding.test3Spinner

        var arrayAdapter = ArrayAdapter(binding.test3Spinner.context, R.layout.simple_spinner_item, Data.getLanguages())
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        with(test3Spinner)
        {
            adapter = arrayAdapter
            setSelection(0, false)
            onItemSelectedListener = this@SecondBlankFragment
            prompt = "Select your favourite language"
            gravity = Gravity.CENTER
        }

        binding.spinnerTestButton.setOnClickListener {
            Log.d("test spinners", testSpinner.selectedItem.toString()
                    + ", " + test2Spinner.selectedItem.toString()
                    + ", " + test3Spinner.selectedItem.toString())
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondBlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondBlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Log.d("test spinners", testSpinner.selectedItem.toString()
                + ", **** " + test2Spinner.selectedItem.toString()
                + ", **** " + test3Spinner.selectedItem.toString())
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}