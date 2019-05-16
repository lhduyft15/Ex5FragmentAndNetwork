package  com.home.lhduy.fragnet.getJson

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.home.lhduy.fragnet.movieModel.MovieAdapter
import com.home.lhduy.fragnet.movieModel.Movie
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class GetJSON{

   fun getJsonFromApi(url : String,recycler : RecyclerView, activity : FragmentActivity?,context : Context?){

       var movies : ArrayList<Movie> = ArrayList()


       val client = OkHttpClient()
       val request = Request.Builder()
           .url(url)
           .build()
       client.newCall(request)
           .enqueue(object: Callback {

               override fun onFailure(call: Call, e: IOException) {

           }

                override fun onResponse(call: Call, response: Response) {
               if(response.isSuccessful) {

                   val json = response.body()!!.string()
                   val jsonObject = JSONObject(json)
                   val jsonDataMovie = jsonObject.get("results").toString()

                   val collectionType = object : TypeToken<Collection<Movie>>(){}.type

                   movies = Gson().fromJson(jsonDataMovie, collectionType)

                   activity?.runOnUiThread(
                       Runnable {
                           recycler.layoutManager = LinearLayoutManager(activity)
                           val adapter = MovieAdapter(movies)
                           recycler.adapter = adapter
                       }
                   )
               }
           }
       })
   }

}