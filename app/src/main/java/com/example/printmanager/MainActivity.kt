package com.example.printmanager

import android.content.Context
import android.os.Bundle
import android.print.PrintManager
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.printmanager.databinding.WebviewActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: WebviewActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WebviewActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Load an HTML page.
        binding.wbPdf.loadUrl("file:///android_res/raw/motogp_stats.html")
        binding.wbPdf.settings.javaScriptEnabled = true
        binding.btPrint.setOnClickListener {
            showPreviewViaPrintManager()
        }
        Log.d("State:","onCreate")
        Toast.makeText(this,"State:onCreate",Toast.LENGTH_LONG).show()
    }

    private fun showPreviewViaPrintManager() {
        // Get the print manager.
        val printManager = getSystemService(
            Context.PRINT_SERVICE
        ) as PrintManager
        // Pass in the ViewView's document adapter.
        printManager.print("MotoGP stats", binding.wbPdf.createPrintDocumentAdapter("MotoGP"), null)
    }

    override fun onResume() {
        super.onResume()
        Log.d("State:","onResume")
        Toast.makeText(this,"State:onResume",Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("State:","onPause")
        Toast.makeText(this,"State:onPause",Toast.LENGTH_LONG).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("State:","onDestroy")
        Toast.makeText(this,"State:onDestroy",Toast.LENGTH_LONG).show()
    }
}