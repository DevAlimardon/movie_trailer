package uz.infinityandro.moviestream.presenter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.infinityandro.moviestream.databinding.ItemStreamBinding
import uz.infinityandro.moviestream.domain.data.ItemsItem

class StreamAdapter(var listener: (model: ItemsItem) -> Unit) :
    RecyclerView.Adapter<StreamAdapter.VH>() {
    private val banners: ArrayList<ItemsItem> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addFiles(banners: List<ItemsItem>) {
        this.banners.clear()
        this.banners.addAll(banners)
        notifyDataSetChanged()
    }

    inner class VH(var binding: ItemStreamBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(i: ItemsItem) = with(binding) {
            Glide.with(binding.root.context).load(i.image).into(image)
            root.setOnClickListener {
                listener(i)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemStreamBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(banners[position])
    }

    override fun getItemCount(): Int {
        return banners.count()
    }

}