package com.example.top

import adapter.ContactAdapter
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.top.databinding.ActivityCallBinding
import models.Contact

class Call : AppCompatActivity() {

    private lateinit var binding: ActivityCallBinding
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupSearch()
        setupFab()
        loadContacts()
    }

    private fun setupRecyclerView() {
        adapter = ContactAdapter(emptyList())

        binding.recyclerViewContacts.apply {
            layoutManager = LinearLayoutManager(this@Call)
            adapter = this@Call.adapter
        }
    }

    private fun setupSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterContacts(query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterContacts(newText ?: "")
                return true
            }
        })
    }

    private fun filterContacts(query: String) {
        val allContacts = getAllContacts()
        val filtered = if (query.isEmpty()) {
            allContacts
        } else {
            allContacts.filter { contact ->
                contact.name.contains(query, ignoreCase = true) ||
                        contact.phoneNumber.contains(query) ||
                        contact.city.contains(query, ignoreCase = true)
            }
        }
        adapter.updateContacts(filtered)
    }

    private fun setupFab() {
        binding.fabAddContact.setOnClickListener {
            Toast.makeText(this, "Добавление нового контакта", Toast.LENGTH_SHORT).show()
            // Здесь открывается экран добавления контакта
        }
    }

    private fun loadContacts() {
        // Загружаем тестовые данные
        val contacts = getAllContacts()
        adapter.updateContacts(contacts)
    }

    private fun getAllContacts(): List<Contact> {
        return listOf(
            Contact(1, "Иван Иванов", "+7 (999) 123-45-67", "Москва", R.drawable.ic_avatar_1),
            Contact(2, "Мария Петрова", "+7 (988) 765-43-21", "Санкт-Петербург", R.drawable.ic_avatar_2),
            Contact(3, "Алексей Сидоров", "+7 (916) 555-33-22", "Казань", R.drawable.ic_avatar_3),
            Contact(4, "Елена Козлова", "+7 (903) 444-11-00", "Новосибирск", 0),
            Contact(5, "Дмитрий Смирнов", "+7 (925) 777-88-99", "Екатеринбург", R.drawable.ic_avatar_1),
            Contact(6, "Анна Морозова", "+7 (909) 222-33-44", "Нижний Новгород", R.drawable.ic_avatar_2),
            Contact(7, "Сергей Волков", "+7 (915) 666-77-88", "Челябинск", 0),
            Contact(8, "Татьяна Павлова", "+7 (901) 999-11-22", "Самара", R.drawable.ic_avatar_3)
        )
    }
}