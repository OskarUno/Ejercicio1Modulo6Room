package com.awakelab.oskar.ejercicio1modulo6room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.awakelab.oskar.ejercicio1modulo6room.databinding.FragmentAgregarBinding

class AgregarFragment : Fragment() {
    lateinit var binding: FragmentAgregarBinding
    private val tareaViewModel: TareaViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAgregarBinding.inflate(layoutInflater, container, false)
        initListener()
        cargarTareas()
        return binding.root
    }

    private fun initListener() {
        binding.btnGuardar.setOnClickListener {
            val texto1 = binding.et1.text.toString()
            guardarTarea(texto1)
        }
    }

    private fun guardarTarea(texto: String) {
        val tareaDao = Tarea(texto)
        tareaViewModel.insertarTarea(tareaDao)
    }

    private fun cargarTareas() {
        tareaViewModel.obtenerTareas().observe(viewLifecycleOwner) {
            //recuperacion de la tarea desde ddbb
            val tareaRecuperada =
                it.joinToString("\n") { it.nombre }  //Convierte aformato con salto de linea
            binding.tv2.text = tareaRecuperada   //Lo envia a la pantalla
        }
    }
}
