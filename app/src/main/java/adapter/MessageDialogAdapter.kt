import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.top.R
import models.MessageDialog

class MessageDialogAdapter(
    private var dialogs: List<MessageDialog>,
    private val onItemClick: (MessageDialog) -> Unit
) : RecyclerView.Adapter<MessageDialogAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivAvatar: ImageView = itemView.findViewById(R.id.ivAvatar)
        val tvUserName: TextView = itemView.findViewById(R.id.tvUserName)
        val tvLastMessage: TextView = itemView.findViewById(R.id.tvLastMessage)
        val tvMessageTime: TextView = itemView.findViewById(R.id.tvMessageTime)
        val tvUnreadCount: TextView = itemView.findViewById(R.id.tvUnreadCount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message_dialog, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dialog = dialogs[position]

        holder.tvUserName.text = dialog.userName
        holder.tvLastMessage.text = dialog.lastMessage
        holder.tvMessageTime.text = dialog.lastMessageTime

        // Устанавливаем аватар
        holder.ivAvatar.setImageResource(dialog.userAvatar)


        if (dialog.unreadCount > 0) {
            holder.tvUnreadCount.visibility = View.VISIBLE
            holder.tvUnreadCount.text = if (dialog.unreadCount > 99) "99+" else dialog.unreadCount.toString()
        } else {
            holder.tvUnreadCount.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {
            onItemClick(dialog)
        }
    }

    override fun getItemCount(): Int = dialogs.size

    // Метод для обновления данных
    fun updateData(newDialogs: List<MessageDialog>) {
        dialogs = newDialogs
        notifyDataSetChanged()
    }
}