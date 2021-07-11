package com.example.listadecompras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtItem = findViewById<EditText>(R.id.edtItem)
        val btnInserir = findViewById<Button>(R.id.btnInserir)
        val listItem = findViewById<ListView>(R.id.listView)

        val itemAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        listItem.adapter = itemAdapter

        btnInserir.setOnClickListener {
            val item = edtItem.text.toString()
            
            if(item.length > 0){
                itemAdapter.add(item)
                edtItem.text.clear()
            }
            else{
                edtItem.error = "Preencha um valor"
            }

        }

        listItem.setOnItemLongClickListener { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->
            val item = itemAdapter.getItem(position)

            itemAdapter.remove(item)

            true
        }
    }
}