package uz.infinityandro.moviestream.domain.data

import com.google.gson.annotations.SerializedName

data class SearchMovie(

	@field:SerializedName("expression")
	val expression: String? = null,

	@field:SerializedName("searchType")
	val searchType: String? = null,

	@field:SerializedName("errorMessage")
	val errorMessage: String? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem>? = null
)

data class ResultsItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("resultType")
	val resultType: String? = null
)
