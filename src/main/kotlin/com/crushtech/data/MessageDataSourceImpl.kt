package com.crushtech.data

import com.crushtech.data.model.Message
import org.litote.kmongo.coroutine.CoroutineDatabase

class MessageDataSourceImpl(
    db: CoroutineDatabase
) : MessageDataSource {
    private val messages = db.getCollection<Message>()

    override suspend fun getAllMessages(): List<Message> {
        return messages.find().descendingSort(Message::timestamp)
            .toList()
    }

    override suspend fun insertMessage(message: Message): Boolean = messages.insertOne(message).wasAcknowledged()

}
