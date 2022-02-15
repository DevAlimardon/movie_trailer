package uz.infinityandro.moviestream.domain.data

import com.google.gson.annotations.SerializedName

data class ActorsData(

	@field:SerializedName("summary")
	val summary: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("knownFor")
	val knownFor: List<KnownForItem>? = null,

	@field:SerializedName("castMovies")
	val castMovies: List<CastMoviesItem>? = null,

	@field:SerializedName("awards")
	val awards: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("deathDate")
	val deathDate: Any? = null,

	@field:SerializedName("errorMessage")
	val errorMessage: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("birthDate")
	val birthDate: String? = null,

	@field:SerializedName("height")
	val height: String? = null
)

data class CastMoviesItem(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("year")
	val year: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class KnownForItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("fullTitle")
	val fullTitle: String? = null,

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("year")
	val year: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)
