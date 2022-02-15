package uz.infinityandro.moviestream.domain.data

import com.google.gson.annotations.SerializedName

data class MovieDetail(

	@field:SerializedName("keywords")
	val keywords: String? = null,

	@field:SerializedName("year")
	val year: String? = null,

	@field:SerializedName("directors")
	val directors: String? = null,

	@field:SerializedName("genreList")
	val genreList: List<GenreListItemD>? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("tvEpisodeInfo")
	val tvEpisodeInfo: Any? = null,

	@field:SerializedName("imDbRating")
	val imDbRating: String? = null,

	@field:SerializedName("trailer")
	val trailer: Trailer? = null,

	@field:SerializedName("runtimeStr")
	val runtimeStr: String? = null,

	@field:SerializedName("plotLocal")
	val plotLocal: String? = null,

	@field:SerializedName("companies")
	val companies: String? = null,

	@field:SerializedName("plot")
	val plot: String? = null,

	@field:SerializedName("companyList")
	val companyList: List<CompanyListItemD>? = null,

	@field:SerializedName("genres")
	val genres: String? = null,

	@field:SerializedName("ratings")
	val ratings: Any? = null,

	@field:SerializedName("actorList")
	val actorList: List<ActorListItemD>? = null,

	@field:SerializedName("imDbRatingVotes")
	val imDbRatingVotes: String? = null,

	@field:SerializedName("tvSeriesInfo")
	val tvSeriesInfo: Any? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("languageList")
	val languageList: List<LanguageListItemD>? = null,

	@field:SerializedName("wikipedia")
	val wikipedia: Any? = null,

	@field:SerializedName("fullCast")
	val fullCast: Any? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("fullTitle")
	val fullTitle: String? = null,

	@field:SerializedName("images")
	val images: Any? = null,

	@field:SerializedName("runtimeMins")
	val runtimeMins: String? = null,

	@field:SerializedName("languages")
	val languages: String? = null,

	@field:SerializedName("releaseDate")
	val releaseDate: String? = null,

	@field:SerializedName("similars")
	val similars: List<SimilarsItemD>? = null,

	@field:SerializedName("posters")
	val posters: Any? = null,

	@field:SerializedName("errorMessage")
	val errorMessage: Any? = null,

	@field:SerializedName("metacriticRating")
	val metacriticRating: String? = null,

	@field:SerializedName("directorList")
	val directorList: List<DirectorListItemD>? = null,

	@field:SerializedName("writers")
	val writers: String? = null,

	@field:SerializedName("stars")
	val stars: String? = null,

	@field:SerializedName("countries")
	val countries: String? = null,

	@field:SerializedName("countryList")
	val countryList: List<CountryListItemD>? = null,

	@field:SerializedName("plotLocalIsRtl")
	val plotLocalIsRtl: Boolean? = null,

	@field:SerializedName("keywordList")
	val keywordList: List<String?>? = null,

	@field:SerializedName("originalTitle")
	val originalTitle: String? = null,

	@field:SerializedName("awards")
	val awards: String? = null,

	@field:SerializedName("tagline")
	val tagline: String? = null,

	@field:SerializedName("starList")
	val starList: List<StarListItemD>? = null,

	@field:SerializedName("contentRating")
	val contentRating: String? = null,

	@field:SerializedName("boxOffice")
	val boxOffice: BoxOffice? = null,

	@field:SerializedName("writerList")
	val writerList: List<WriterListItem?>? = null
)

data class ActorListItemD(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("asCharacter")
	val asCharacter: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class WriterListItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class LanguageListItemD(

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class SimilarsItemD(

	@field:SerializedName("imDbRating")
	val imDbRating: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("fullTitle")
	val fullTitle: String? = null,

	@field:SerializedName("year")
	val year: String? = null,

	@field:SerializedName("plot")
	val plot: String? = null,

	@field:SerializedName("genres")
	val genres: String? = null,

	@field:SerializedName("directors")
	val directors: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("stars")
	val stars: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class BoxOffice(

	@field:SerializedName("grossUSA")
	val grossUSA: String? = null,

	@field:SerializedName("openingWeekendUSA")
	val openingWeekendUSA: String? = null,

	@field:SerializedName("cumulativeWorldwideGross")
	val cumulativeWorldwideGross: String? = null,

	@field:SerializedName("budget")
	val budget: String? = null
)

data class StarListItemD(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class CountryListItemD(

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class GenreListItemD(

	@field:SerializedName("value")
	val value: String? = null,

	@field:SerializedName("key")
	val key: String? = null
)

data class CompanyListItemD(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class DirectorListItemD(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class Trailer(

	@field:SerializedName("fullTitle")
	val fullTitle: String? = null,

	@field:SerializedName("linkEmbed")
	val linkEmbed: String? = null,

	@field:SerializedName("year")
	val year: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

	@field:SerializedName("errorMessage")
	val errorMessage: String? = null,

	@field:SerializedName("videoId")
	val videoId: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("videoTitle")
	val videoTitle: String? = null,

	@field:SerializedName("imDbId")
	val imDbId: String? = null,

	@field:SerializedName("videoDescription")
	val videoDescription: String? = null,

	@field:SerializedName("uploadDate")
	val uploadDate: Any? = null,

	@field:SerializedName("thumbnailUrl")
	val thumbnailUrl: String? = null
)
