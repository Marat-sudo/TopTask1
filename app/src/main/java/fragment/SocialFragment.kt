package fragment

import MessageDialogAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.top.R
import models.MessageDialog

class SocialFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MessageDialogAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_social, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerViewMessages)
        setupRecyclerView()
        loadMockData()
    }

    private fun setupRecyclerView() {
        adapter = MessageDialogAdapter(emptyList()) { dialog ->
            // Обработка нажатия на диалог
            Toast.makeText(requireContext(), "дальше лень", Toast.LENGTH_SHORT).show()

        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@SocialFragment.adapter
            // this@SocialFragment ссылка на фрагмент
        }
    }

    private fun loadMockData() {
        // я хз что тут писать но пусть будет
        val dialogs = listOf(
            MessageDialog(
                id = 1,
                userName = "Пользователь 1",
                userAvatar = R.drawable.ic_avatar_1,
                lastMessage = "Hello",
                lastMessageTime = "12:33",
                unreadCount = 2
            ),
            MessageDialog(
                id = 2,
                userName = "Пользователь 1",
                userAvatar = R.drawable.ic_avatar_2,
                lastMessage = "sms",
                lastMessageTime = "был недавно",
                unreadCount = 0
            ),
            MessageDialog(
                id = 3,
                userName = "Пользователь 3",
                userAvatar = R.drawable.ic_avatar_3,
                lastMessage = "UwU",
                lastMessageTime = "12:46",
                unreadCount = 5
            )
        )

        adapter.updateData(dialogs)
    }
}