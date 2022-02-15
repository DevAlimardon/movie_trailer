package uz.infinityandro.moviestream.presenter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cunoraz.continuouscrollable.ContinuousScrollableImageView
import uz.infinityandro.moviestream.R
import uz.infinityandro.moviestream.databinding.ItemSplashBinding

class SplashAdapter:RecyclerView.Adapter<SplashAdapter.VH>() {
    private val banners: ArrayList<Int> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addFiles(banners: List<Int>) {
        this.banners.clear()
        this.banners.addAll(banners)
        notifyDataSetChanged()
    }

    inner  class VH(var binding: ItemSplashBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(i: Int, position: Int) {
            if (position == 1 || position == 3) binding.premBannerColumn.setPadding(0, 100, 0, 0)
            if (position == 1 || position == 3) binding.premBannerColumn.setDirection(
                ContinuousScrollableImageView.DOWN
            ) else binding.premBannerColumn.setDirection(ContinuousScrollableImageView.UP)
            binding.premBannerColumn.setResourceId(i)

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemSplashBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(banners[position],position)
    }

    override fun getItemCount(): Int {
        return banners.count()
    }

}