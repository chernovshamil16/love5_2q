package com.example.love5_2.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.love5_2.databinding.ItemHistoryBinding
import com.example.love5_2.love.LoveModel

class HistoryAdapter (private var list : List<LoveModel>): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    var onClick: ((LoveModel) -> Unit)? = null
    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun Bind(loveModel: LoveModel) {
            binding.fname.text = loveModel.firstname
            binding.sname.text = loveModel.secondname

            itemView.setOnClickListener {
                onClick?.invoke(loveModel)


            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.Bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size




    }

}