package uz.infinityandro.moviestream.presenter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.target.Target
import uz.infinityandro.moviestream.app.App
import uz.infinityandro.moviestream.databinding.ItemTrendingBinding
import uz.infinityandro.moviestream.domain.data.ItemsItems

class TrendingAdapter(var listener: (model: ItemsItems) -> Unit) :
    RecyclerView.Adapter<TrendingAdapter.VH>() {
    private val banners: ArrayList<ItemsItems> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addFiles(banners: List<ItemsItems>) {
        this.banners.clear()
        this.banners.addAll(banners)
        notifyDataSetChanged()
    }

    inner class VH(var binding: ItemTrendingBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("CheckResult")
        fun bind(i: ItemsItems) = with(binding) {
            val thumblain = Glide.with(App.instance).load(i.image)
            Glide.with(App.instance).asBitmap().load(i.image)
                .format(DecodeFormat.PREFER_RGB_565)
                .override(Target.SIZE_ORIGINAL)
                .into(trendImage)
            root.setOnClickListener {
                listener(i)
            }
            name.text = i.title
            rate.text = i.imDbRating

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemTrendingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(banners[position])
    }

    override fun getItemCount(): Int {
        return banners.count()
    }
}