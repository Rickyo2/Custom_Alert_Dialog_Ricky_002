package com.example.customalertdialogricky002

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnKenalan = findViewById<Button>(R.id.btnKenalan)

        btnKenalan.setOnClickListener {
            val infLateView = layoutInflater.inflate(R.layout.layout_alert, null)
            val etNama = infLateView.findViewById<EditText>(R.id.etNama)
            val alb = AlertDialog.Builder(this@MainActivity)
            with(alb) {
                setTitle("Mau Kenalan?")
                setIcon(R.drawable.maskot_kotlin)
                setView(infLateView)
                setCancelable(false)
                setPositiveButton("Selesai") { _, _ ->
                    val nama = if ("${etNama.text}".isNotEmpty()) "${etNama.text}" else "orang asing"
                    Toast.makeText(this@MainActivity,"Salam Kenal, $nama!", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("Siape Lu?") { _, _ ->
                    Toast.makeText(this@MainActivity, "Sombong Amat Sih!", Toast.LENGTH_SHORT).show()
                }
                setNeutralButton("Maaf, cuma numpang lewat", null) //Tidak ada feedback dari aplikasi
                create().show()
            }
        }
    }
}