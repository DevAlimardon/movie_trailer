package uz.infinityandro.moviestream.presenter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.infinityandro.moviestream.app.App
import uz.infinityandro.moviestream.databinding.ItemBestMovieBinding
import uz.infinityandro.moviestream.domain.data.KnownForItem

class BestMovieAdapter : RecyclerView.Adapter<BestMovieAdapter.VH>() {

    private val banners: ArrayList<KnownForItem> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addFiles(banners: List<KnownForItem>) {
        this.banners.clear()
        this.banners.addAll(banners)
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemBestMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(knownForItem: KnownForItem) = with(binding) {
            Glide.with(App.instance).load(knownForItem.image).into(imageFilmActor)
            nameFilm.text = knownForItem.title
            role.text = "role: ${knownForItem.role}"

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemBestMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(banners[position])
    }

    override fun getItemCount(): Int {
        return banners.count()
    }
}