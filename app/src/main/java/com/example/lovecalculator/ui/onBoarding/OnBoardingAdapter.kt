package com.example.lovecalculator.ui.onBoarding

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemBoardingBinding

class OnBoardingAdapter(private val context: Context, private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private var data = arrayListOf(
        OnBoard(
            R.raw.love1,
            "love1"
        ),
        OnBoard(
            R.raw.love2,
            "love2"
        ),
        OnBoard(
            R.raw.love3,
            "love3"
        ), OnBoard(
            R.raw.love4,
            "love4"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size


    inner class OnBoardingViewHolder(private val binding: ItemBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.ivBoarding.setAnimation(onBoard.image!!)
            binding.tvTitle.text = onBoard.title

            if (adapterPosition == data.lastIndex) binding.tvSkip.text =
                context.getString(R.string.next) else context.getString(R.string.skip)
            binding.tvSkip.setOnClickListener {
                onClick()
            }
        }
    }
}