package uz.infinityandro.moviestream.presenter.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.infinityandro.moviestream.app.App
import uz.infinityandro.moviestream.databinding.ItemSearchBinding
import uz.infinityandro.moviestream.domain.data.ResultsItem

class SearchAdapter(var listener:(model:ResultsItem)->Unit) :RecyclerView.Adapter<SearchAdapter.VH>(){
    private val banners: ArrayList<ResultsItem> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun addFiles(banners: List<ResultsItem>) {
        this.banners.clear()
        this.banners.addAll(banners)
        notifyDataSetChanged()
    }
 inner class VH(val binding:ItemSearchBinding):RecyclerView.ViewHolder(binding.root) {
     fun bind(resultsItem: ResultsItem)= with(binding){
         Glide.with(App.instance).load(resultsItem.image).into(image)
         name.setText(resultsItem.title)
         year.setText(resultsItem.description)
         root.setOnClickListener {
             listener(resultsItem)
         }
     }

 }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemSearchBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(banners[position])
    }

    override fun getItemCount(): Int {
        return banners.count()
    }
}