package com.awakelab.oskar.ejercicio1modulo6room

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.awakelab.oskar.ejercicio1modulo6room.databinding.FragmentAgregarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

lateinit var binding: FragmentAgregarBinding
lateinit var repositorio: Repositorio

class AgregarFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAgregarBinding.inflate(layoutInflater, container, false)
        initRepositorio()
        initListener()
        cargarTareas()
        return binding.root
    }

    private fun initRepositorio() {
        repositorio = Repositorio(TareaBaseDatos.getDatabase(requireContext()).getTaskDao())
    }

    private fun initListener() {
        binding.btnGuardar.setOnClickListener {
            val texto1 = binding.et1.text.toString()
            guardarTarea(texto1)
        }
    }

    private fun guardarTarea(texto: String) {

        val tareaDao = Tarea(texto)
        GlobalScope.launch { repositorio.insertTask(tareaDao) }
    }

    private fun cargarTareas() {

        repositorio.getTareas().observe(requireActivity()) {
            //recuperacion de la tarea desde ddbb
            val tareaRecuperada =
                it.joinToString("\n") { it.nombre }  //Convierte aformato con salto de linea
            binding.tv2.text = tareaRecuperada   //Lo envia a la pantalla
        }
    }
}
