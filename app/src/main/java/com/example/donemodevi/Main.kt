package com.example.donemodevi

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.donemodevi.databinding.ActivityMainBinding
class Main : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.fbb.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        binding.hkkButton1.setOnClickListener { view ->
            val intent = Intent(this,HKKActivity::class.java)
            startActivity(intent)
        }
        val listView = findViewById<ListView>(R.id.listView)
        val names = arrayOf("", "İstanbul", "Ankara", "İzmir", "Bursa", "Antalya", "Muğla", "İzmit", "Mersin", "Trabzon", "Batman", "Ordu", "Çanakkale", "Erzurum")
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, names
        )
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, DBActivity::class.java)
            val bundle = Bundle()
            bundle.putString("Yazi", names[i])
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}