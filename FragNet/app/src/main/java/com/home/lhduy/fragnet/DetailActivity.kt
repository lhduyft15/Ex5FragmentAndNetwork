package com.home.lhduy.fragnet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.home.lhduy.fragnet.movieModel.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private lateinit var selectedMovie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val b = getIntent().getExtras()
        selectedMovie = b.getParcelable("movie")

        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+selectedMovie.poster_path).into(imagePoster)
        TitleDetail.text = selectedMovie.title
        ReleaseDay.text = "Release day: "+selectedMovie.release_date
        ratingBarStyle.rating = selectedMovie.vote_average/2
        DetailDecription.text = selectedMovie.overview
    }
}
