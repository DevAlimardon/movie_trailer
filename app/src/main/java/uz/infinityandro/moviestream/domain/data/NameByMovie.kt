package uz.infinityandro.moviestream.domain.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NameByMovie(

	@field:SerializedName("errorMessage")
	val errorMessage: String? = null,

	@field:SerializedName("keyword")
	val keyword: String? = null,

	@field:SerializedName("items")
	val items: List<ItemsItem>? = null
)

data class ItemsItem(

	@field:SerializedName("imDbRating")
	val imDbRating: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("year")
	val year: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
):Serializable
