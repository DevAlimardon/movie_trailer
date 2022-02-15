package uz.infinityandro.moviestream.presenter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.target.Target
import uz.infinityandro.moviestream.app.App
import uz.infinityandro.moviestream.databinding.ItemAnyBinding
import uz.infinityandro.moviestream.domain.data.ItemsItem

class AnyAdapter(val listener:(model:ItemsItem)->Unit) : RecyclerView.Adapter<AnyAdapter.VH>() {
    private val banners: ArrayList<ItemsItem> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addFiles(banners: List<ItemsItem>) {
        this.banners.clear()
        this.banners.addAll(banners)
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemAnyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemsItem: ItemsItem) = with(binding) {
            Glide.with(App.instance).asBitmap().load(itemsItem.image)
                .format(DecodeFormat.PREFER_RGB_565)
                .override(Target.SIZE_ORIGINAL)
                .into(imageAny)
            root.setOnClickListener {
                listener(itemsItem)
            }
            textName.text = "${itemsItem.title} ${itemsItem.year}"
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemAnyBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(banners[position])
    }

    override fun getItemCount(): Int {
        return banners.count()
    }
}