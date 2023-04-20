package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


class tuesday : Fragment() {
    private lateinit var add: Button
    private lateinit var dialog: AlertDialog
    private lateinit var layout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_tuesday, container, false)
        add = view.findViewById(R.id.btntuesday)
        layout = view.findViewById(R.id.container2)

        buildDialog()

        add.setOnClickListener {
            dialog.show()
        }
        return view
    }

    private fun buildDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val view = requireActivity().layoutInflater.inflate(R.layout.dialog, null)

        val name = view.findViewById<EditText>(R.id.nameEdit)

        builder.setView(view)
            .setTitle("Enter name")
            .setPositiveButton("OK") { dialog, which ->
                addCard(name.text.toString())
            }
            .setNegativeButton("Cancel") { dialog, which ->

            }

        dialog = builder.create()
    }

    private fun addCard(name: String) {
        val view = requireActivity().layoutInflater.inflate(R.layout.card, null)

        val nameView = view.findViewById<TextView>(R.id.name)
        val delete = view.findViewById<Button>(R.id.delete)

        nameView.text = name

        delete.setOnClickListener {
            layout.removeView(view)
        }

        layout.addView(view)
    }
}
