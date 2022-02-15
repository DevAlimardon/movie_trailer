package uz.infinityandro.moviestream.presenter.adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import uz.infinityandro.moviestream.app.App
import uz.infinityandro.moviestream.databinding.ItemAnyBinding
import uz.infinityandro.moviestream.domain.data.ItemTop

class TopAdapter(var listener: (model: ItemTop) -> Unit) : RecyclerView.Adapter<TopAdapter.VH>() {
    private val banners: ArrayList<ItemTop> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addFiles(banners: List<ItemTop>) {
        this.banners.clear()
        this.banners.addAll(banners)
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemAnyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemsItem: ItemTop) = with(binding) {
            root.setOnClickListener {
                listener(itemsItem)
            }
            Glide.with(App.instance).load(itemsItem.image).listener(object :
                RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

            })
                .format(DecodeFormat.PREFER_RGB_565)
                .override(Target.SIZE_ORIGINAL)
                .into(imageAny)
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