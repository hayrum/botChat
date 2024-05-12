package com.example.botmessages.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.botmessages.R
import com.example.botmessages.data.Message
import com.example.botmessages.databinding.MessageItemBinding
import com.example.botmessages.utils.Constants.RECEIVE_ID
import com.example.botmessages.utils.Constants.SEND_ID

/**
 * This class is responsible for displaying the messages in the RecyclerView.
 */
class MessagingAdapter : RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>() {

    var messagesList = mutableListOf<Message>()

    //inner class.
    inner class MessageViewHolder(val binding: MessageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                messagesList.removeAt(bindingAdapterPosition)
                notifyItemRemoved(bindingAdapterPosition)
            }
        }
    }

    //create view holder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            MessageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    //get item count.
    override fun getItemCount(): Int {
        return messagesList.size
    }

    //bind view holder.
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currencyMessage = messagesList[position]
        when (currencyMessage.id) {
            SEND_ID -> {
                with(holder.binding) {
                    tvMessage.apply {
                        text = currencyMessage.message
                        isVisible = true
                    }
                    tvBotMessage.isInvisible = true
                }
            }

            RECEIVE_ID -> {
                with(holder.binding) {
                    tvBotMessage.apply {
                        text = currencyMessage.message
                        isVisible = true
                    }
                    tvMessage.isInvisible = true
                }
            }
        }
    }

    //insert message into list.
    fun insertMessage(message: Message) {
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
    }
}