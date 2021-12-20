package com.fq.navigationtutorial

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.fq.navigationtutorial.databinding.FragmentAddCardBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddCardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddCardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentAddCardBinding
    private lateinit var navController: NavController
    lateinit var surveyViewModel: SurveyViewModel
    lateinit var testImage: Object

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
        //return inflater.inflate(R.layout.fragment_add_card, container, false)
        binding = FragmentAddCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        surveyViewModel = ViewModelProvider(requireActivity()).get(SurveyViewModel::class.java)
        var surveyModel = surveyViewModel.surveyLiveModel.value

//        //////// test
//        var spinner: Spinner = binding.addCardSpinner.findViewById(R.id.addCardSpinner)
//        ArrayAdapter.createFromResource(
//            binding.addCardSpinner.context,
//            R.array.image_options,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner.adapter = adapter
//        }
//        Log.d("spinner", spinner.count.toString())
//        /////////////////

        ////// test 2
//        val data = arrayOf("Java", "Python", "C++", "C#", "Angular", "Go")
//
//        val adapter = ArrayAdapter(this, R.layout.spinner_item_selected, data)
//        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
//
//        val spinner = binding.addCardSpinner.findViewById<Spinner>(R.id.spinner)
//        spinner.adapter = adapter
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
//                Toast.makeText(this@AddCardFragment, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {
//
//            }
//        }
        /////////////////

        binding.submitCardButton.setOnClickListener {
            navController.navigate(R.id.action_addCardFragment_to_surveyFragment)

            if (surveyModel != null)
            {
                var name = binding.addCardName.text.toString()
                var rating = binding.addCardRating.rating
                var image = R.drawable.bar

                when(binding.addCardSpinner.selectedItem)
                {
                    //"Bar" -> image = R.drawable.bar
                    "Cafe" -> image = R.drawable.coffee
                    "Restaurant" -> image = R.drawable.restaurant
                }
                surveyModel.survey.add(SurveyItem(name, rating, image))
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddCardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddCardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}