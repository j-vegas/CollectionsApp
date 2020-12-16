package com.jvegas.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.jvegas.movie.adapter.ResultAdapter
import com.jvegas.movie.models.MovieApiResponse
import com.jvegas.movie.models.ResultsItem
import com.jvegas.movie.services.MovieApiServices
import com.jvegas.movie.services.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieActivity : AppCompatActivity() {

    private lateinit var results: ArrayList<ResultsItem>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ResultAdapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        getPopularMovies()

        swipeRefreshLayout = findViewById(R.id.swiperefresh)
        swipeRefreshLayout.setColorSchemeResources(R.color.design_default_color_primary)
        swipeRefreshLayout.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                getPopularMovies()
            }
        })
    }

    private fun getPopularMovies() {
        val movieApiServices: MovieApiServices = RetrofitInstance.getService()

        val call: Call<MovieApiResponse> =
            movieApiServices.getPopularMovies(getString(R.string.api_key))
        call.enqueue(object : Callback<MovieApiResponse> {
            override fun onResponse(
                call: Call<MovieApiResponse>,
                response: Response<MovieApiResponse>
            ) {
                val movieApiResponse: MovieApiResponse? =
                    response.body()
                if (movieApiResponse?.results != null) {
                    results = movieApiResponse.results as ArrayList<ResultsItem>
                    fillRecyclerView()
                    swipeRefreshLayout.isRefreshing = false
                }
            }

            override fun onFailure(call: Call<MovieApiResponse>, t: Throwable) {

            }
        })
    }

    private fun fillRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        adapter = ResultAdapter(results)

//                if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
//                }

        val layout = GridLayoutManager(this@MovieActivity, 2)
        recyclerView.layoutManager = layout

        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }
}