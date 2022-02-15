package uz.infinityandro.moviestream.presenter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.infinityandro.moviestream.app.App
import uz.infinityandro.moviestream.databinding.ItemGenreBinding
import uz.infinityandro.moviestream.domain.data.ActorListItemD

class GenreAdapter(var listener:(model:ActorListItemD)->Unit) : RecyclerView.Adapter<GenreAdapter.VH>() {
    private val banners: ArrayList<ActorListItemD> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addFiles(banners: List<ActorListItemD>) {
        this.banners.clear()
        this.banners.addAll(banners)
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemGenreBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemSoon: ActorListItemD) = with(binding) {
            Glide.with(App.instance).load(itemSoon.image).into(imageFilm)
            name.setText(itemSoon.name)
            root.setOnClickListener {
                listener(itemSoon)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(banners[position])
    }

    override fun getItemCount(): Int {
        return banners.count()
    }
}