package com.santos.bankchallengue.presentation.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santos.bankchallengue.data.model.TaskEntity
import com.santos.bankchallengue.databinding.ItemTaskBinding
import com.santos.bankchallengue.presentation.util.setSafeOnClickListener

class TaskAdapter(val onTaskSelected: ((TaskEntity) -> Unit)) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    var items: List<TaskEntity> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var itemSelected: Int = -1


    inner class TaskViewHolder(
        private val binding: ItemTaskBinding,
        val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TaskEntity) {
            with(binding) {
                tvTaskTitle.text = item.name
                ivTaskMenu.setSafeOnClickListener {
                    notifyItemChanged(itemSelected)
                    itemSelected = adapterPosition
                    onTaskSelected(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            parent.context
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}