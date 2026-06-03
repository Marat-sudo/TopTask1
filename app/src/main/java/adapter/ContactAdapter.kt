package adapter

import com.example.top.databinding.ItemContactBinding
import models.Contact
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.top.R
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(
    private var contacts: List<Contact>
) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    // ViewHolder с использованием ViewBinding
    class ContactViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.apply {
                tvContactName.text = contact.name
                tvPhoneNumber.text = contact.phoneNumber
                tvCity.text = contact.city

                // Устанавливаем фото (если ресурс не указан, используем стандартный)
                if (contact.photoResource != 0) {
                    ivContactPhoto.setImageResource(contact.photoResource)
                } else {
                    ivContactPhoto.setImageResource(R.drawable.ic_default_avatar)
                }

                // Обработка нажатия на иконку звонка
                ivCallIcon.setOnClickListener {
                    makeCall(contact.phoneNumber)
                }

                // Обработка нажатия на всю карточку
                root.setOnClickListener {
                    showContactDetails(contact)
                }
            }
        }

        private fun makeCall(phoneNumber: String) {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            itemView.context.startActivity(intent)
        }

        private fun showContactDetails(contact: Contact) {
            android.widget.Toast.makeText(
                itemView.context,
                "Выбран: ${contact.name}",
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemContactBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount(): Int = contacts.size

    // Метод для обновления данных
    fun updateContacts(newContacts: List<Contact>) {
        contacts = newContacts
        notifyDataSetChanged()
    }
}