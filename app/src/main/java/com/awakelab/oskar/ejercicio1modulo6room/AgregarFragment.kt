package com.awakelab.oskar.ejercicio1modulo6room

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBindings
import com.awakelab.oskar.ejercicio1modulo6room.databinding.FragmentAgregarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

lateinit var binding: FragmentAgregarBinding

class AgregarFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgregarBinding.inflate(layoutInflater, container, false)
        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.btnGuardar.setOnClickListener {
            val texto1 = binding.et1.text.toString()
            guardarTarea(texto1)
        }
    }

    private fun guardarTarea(texto: String) {
        val dao = TareaBaseDatos.getDatabase(requireContext()).getTaskDao()
        val tareaDao = Tarea(texto)
        GlobalScope.launch { dao.insertarTarea(tareaDao) }

    }


}