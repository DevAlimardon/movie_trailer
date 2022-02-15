package uz.infinityandro.moviestream.domain.data

import com.google.gson.annotations.SerializedName

data class YouTubeData(

	@field:SerializedName("imDbId")
	val imDbId: String? = null,

	@field:SerializedName("fullTitle")
	val fullTitle: String? = null,

	@field:SerializedName("videoUrl")
	val videoUrl: String? = null,

	@field:SerializedName("year")
	val year: String? = null,

	@field:SerializedName("errorMessage")
	val errorMessage: String? = null,

	@field:SerializedName("videoId")
	val videoId: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: String? = null
)
