package models

data class MessageDialog(
    val id: Int,
    val userName: String,
    val userAvatar: Int, // ресурс иконки или URL
    val lastMessage: String,
    val lastMessageTime: String,
    val unreadCount: Int
)