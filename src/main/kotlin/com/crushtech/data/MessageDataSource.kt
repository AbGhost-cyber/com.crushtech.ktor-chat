package com.crushtech.data

import com.crushtech.data.model.Message

interface MessageDataSource {
    suspend fun getAllMessages(): List<Message>

    suspend fun insertMessage(message: Message): Boolean
}