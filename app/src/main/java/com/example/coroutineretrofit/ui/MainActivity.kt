package com.example.coroutineretrofit.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutineretrofit.adapter.PostAdapter
import com.example.coroutineretrofit.databinding.ActivityMainBinding
import com.example.coroutineretrofit.model.WeatherDataHourly
import com.example.coroutineretrofit.model.WeatherRequestModel
import com.example.coroutineretrofit.repository.WeatherRepository
import com.example.coroutineretrofit.util.Util.isInternetAvailable
import com.example.coroutineretrofit.util.Util.showToast

class MainActivity : AppCompatActivity(), LocationListener {
    private lateinit var weatherRepository: WeatherRepository
    private lateinit var postAdapter: PostAdapter
    private val REQUEST_LOCATION_PERMISSION = 1
    private lateinit var weatherRequestModel: WeatherRequestModel
    private lateinit var binding: ActivityMainBinding
    lateinit var locManager: LocationManager
    val postViewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        weatherRequestModel = WeatherRequestModel()
        initProgressBar()
        locManager = getSystemService(LOCATION_SERVICE) as LocationManager
        checkPermission()
    }

    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        } else {
            locManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000L,
                500.0f,
                mLocationListener
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.isNotEmpty()
            && grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            checkPermission()
        } else {
            checkPermission()
        }
    }

    private fun initProgressBar() {
        postViewModel.isLoading.observe(this, {
            when (it) {
                true -> binding.progressBar.visibility = View.VISIBLE
                false -> binding.progressBar.visibility = View.GONE
            }
        })
    }

    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }


    @SuppressLint("SetTextI18n")
    private val mLocationListener: LocationListener = LocationListener { location ->
        if (isInternetAvailable(this)) {
            weatherRepository = WeatherRepository()
            postViewModel.getWeather(
                weatherRequestModel.apply {
                    lat = location.latitude
                    lon = location.longitude
                }
            )
            postViewModel.getHourly(
                weatherRequestModel.apply {
                    lat = location.latitude
                    lon = location.longitude
                }
            )
            postViewModel.error.observe(this) {
                when (it.isError) {
                    true -> showToast(this, it.message)
                    false -> bindValue()
                }
            }

        } else {
            showToast(this, "Internet Not Available")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun bindValue() {
        try {

            postViewModel.myResponse.observe(this, Observer { post ->
                binding.textView.text = "Current weather: " + post.data?.get(0)?.cityName
                binding.temperature.text = "Temperature\n" + post.data?.get(0)?.temp + "°C"
                binding.windspeed.text = "Wind Speed\n" + post.data?.get(0)?.windSpd + "/km"
                binding.feels.text = "Wind Direction\n" + post.data?.get(0)?.windCdirFull
                binding.sky.text = "Sky status\n" + post.data?.get(0)?.weather?.description
            })
            postViewModel.myResponseHourly.observe(this, Observer { post ->
                initRecyclerView(post.data!!)
                showToast(this, post.data?.size.toString())
            })

        } catch (e: Exception) {
            showToast(this, e.message.toString())
        }
    }


    private fun initRecyclerView(weatherData: List<WeatherDataHourly.Companion.Datum>) {

        postAdapter = PostAdapter(this, weatherData)
        postAdapter.setData(weatherData)

        binding.recycleLayout.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter

        }
    }

    override fun onLocationChanged(p0: Location) {
        TODO("Not yet implemented")
    }
}
