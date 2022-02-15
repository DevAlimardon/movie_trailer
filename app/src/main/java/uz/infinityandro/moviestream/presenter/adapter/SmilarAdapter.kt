package uz.infinityandro.moviestream.presenter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.infinityandro.moviestream.app.App
import uz.infinityandro.moviestream.databinding.ItemSmilarBinding
import uz.infinityandro.moviestream.domain.data.SimilarsItemD

class SmilarAdapter(var listener:(model:SimilarsItemD)->Unit) : RecyclerView.Adapter<SmilarAdapter.VH>() {

    private val banners: ArrayList<SimilarsItemD> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addFiles(banners: List<SimilarsItemD>) {
        this.banners.clear()
        this.banners.addAll(banners)
        notifyDataSetChanged()
    }

    inner class VH(val binding: ItemSmilarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(similarsItem: SimilarsItemD) = with(binding) {
            Glide.with(App.instance).load(similarsItem.image).into(image)
            name.setText(similarsItem.title)
            root.setOnClickListener {
                listener(similarsItem)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemSmilarBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(banners[position])
    }

    override fun getItemCount(): Int {
        return banners.count()
    }

}