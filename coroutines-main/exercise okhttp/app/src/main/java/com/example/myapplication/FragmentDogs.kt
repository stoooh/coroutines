package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentSecondBinding
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val AUTHORIZATION_HEADER = "X-RapidAPI-Key"
const val KEY_AUTHORIZATION = "4aede6dd3dmsh8c92576de54e9c2p13ea05jsn5c558af1b1ff"

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .addHeader(AUTHORIZATION_HEADER, KEY_AUTHORIZATION)
            .build()
        Log.i("AuthorizationInterceptor", "request $request")
        return chain.proceed(newRequest)
    }
}


class FragmentFootball : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var rickAndMortyAPI: DogAPI

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        val authorization = AuthorizationInterceptor()

        val logging = HttpLoggingInterceptor()

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(authorization)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog-breeds2.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        rickAndMortyAPI = retrofit.create(DogAPI::class.java)

        lifecycleScope.launch {

            val breeds = rickAndMortyAPI.getDogs()
            binding.recyclerView.adapter = DogAdapter(breeds)

        }
    }
}