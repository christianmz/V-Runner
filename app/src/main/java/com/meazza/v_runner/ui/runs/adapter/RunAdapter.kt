package com.meazza.v_runner.ui.runs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.meazza.v_runner.R
import com.meazza.v_runner.data.model.RunEntity
import com.meazza.v_runner.databinding.CardviewRunBinding


class RunAdapter : RecyclerView.Adapter<RunAdapter.Holder>() {

    private var onItemClickListener: ((RunEntity) -> Unit)? = null

    val differ = AsyncListDiffer(this, object : DiffUtil.ItemCallback<RunEntity>() {

        override fun areItemsTheSame(oldItem: RunEntity, newItem: RunEntity) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: RunEntity, newItem: RunEntity) =
            oldItem == newItem
    })

    fun setOnClickListener(listener: ((RunEntity) -> Unit)) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.cardview_run,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemBinding.run {
            run = differ.currentList[position]
            root.setOnClickListener {
                onItemClickListener?.let {
                    it(differ.currentList[position])
                }
            }
        }
    }

    override fun getItemCount() = differ.currentList.size

    inner class Holder(val itemBinding: CardviewRunBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}
