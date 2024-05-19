package com.example.lab_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_8.databinding.RecycleViewBinding


class PhonesAdapter(
    private val items: List<Pair<String, String?>>,
    private val onItemClick: (position: Int) -> Unit
) :
    RecyclerView.Adapter<PhonesAdapter.PhoneHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneHolder {
        val binding = RecycleViewBinding.inflate(LayoutInflater.from(parent.context))
        return PhoneHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: PhoneHolder, position: Int) {
        val phoneName = items[position]
        holder.bind(phoneName.first, phoneName.second)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // Holds the views for adding it to image and text
    class PhoneHolder(
        private val binding: RecycleViewBinding,
        private val onItemClick: (position: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.btnPhone.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(phoneName: String, imageUrl: String?) {
            Glide.with(binding.imageView)
                .load(imageUrl)
                .centerCrop()
                .placeholder(binding.imageView.drawable)
                .error(R.drawable.ic_launcher_background)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(binding.imageView)
            binding.btnPhone.text = phoneName
        }
    }
}