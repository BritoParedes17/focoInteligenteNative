package com.example.pruebaconnavbar

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.pruebaconnavbar.databinding.FragmentSecondBinding
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import android.widget.Toast


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSelector1  = view.findViewById<Button>(R.id.color1)
        btnSelector1.setOnClickListener {
            val intent = Intent(activity, SelectColor1::class.java)
            startActivity(intent)
        }

        val buttonOn = view.findViewById<Button>(R.id.btnConsultar)
        buttonOn.setOnClickListener{View.OnClickListener {
            turnOnLED() }
        }

        
        /*binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }*/
    }

    private fun turnOnLED() {
        val client = OkHttpClient()

        var miVariable = "hola"
        println(miVariable)

        val request = Request.Builder()
            .url("http://www.google.com")
            .get()
            .build()

        try {
            val response = client.newCall(request).execute()
            if (response.isSuccessful) {
                println("Existos")
            } else {
                Toast.makeText(requireContext(), "La solicitud falló", Toast.LENGTH_SHORT).show()
                println("Fallo")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}