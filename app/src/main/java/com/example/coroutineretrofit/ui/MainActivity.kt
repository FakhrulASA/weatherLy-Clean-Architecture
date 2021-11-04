package com.example.coroutineretrofit.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutineretrofit.adapter.PostAdapter
import com.example.coroutineretrofit.R
import com.example.coroutineretrofit.model.WeatherRequestModel
import com.example.coroutineretrofit.repository.WeatherRepository
import com.example.coroutineretrofit.util.Util.isInternetAvailable
import com.example.coroutineretrofit.util.Util.showToast

class MainActivity : AppCompatActivity(), LocationListener {
    private lateinit var weatherRepository: WeatherRepository
    private lateinit var postAdapter: PostAdapter
    private lateinit var recyclerView: RecyclerView
    private val REQUEST_LOCATION_PERMISSION = 1
    private lateinit var name: TextView
    private lateinit var temp: TextView
    private lateinit var des: TextView
    private lateinit var weatherRequestModel: WeatherRequestModel
    val postViewModel: PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        name = findViewById(R.id.textView)
        temp = findViewById(R.id.temperature)
        des = findViewById(R.id.sky)
        weatherRequestModel= WeatherRequestModel()
        val locManager = getSystemService(LOCATION_SERVICE) as LocationManager

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        locManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            1000L,
            500.0f,
            mLocationListener
        )

        recyclerView = findViewById(R.id.recycleLayout)


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


    }

    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun enableMyLocation() {
        if (isPermissionGranted()) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }

        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf<String>(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_PERMISSION
            )
        }
    }

    @SuppressLint("SetTextI18n")
    private val mLocationListener: LocationListener = LocationListener { location->
        if (isInternetAvailable(this)) {
            weatherRepository = WeatherRepository()
            postViewModel.getWeather(
                weatherRequestModel.apply {
                    lat=location.latitude
                    lon=location.longitude
                }
            )
            postViewModel.error.observe(this) {
                when (it.isError) {
                    true -> showToast(this, it.message)
                    false -> {
                        postViewModel.myResponse.observe(this, Observer { post ->
                            name.text = "Current weather: " + post.data?.get(0)?.cityName
                            temp.text = "Temperature\n" + post.data?.get(0)?.temp + "°C"
                            des.text = "Sky status\n" + post.data?.get(0)?.weather?.description
                        })
                    }
                }
            }

        } else {
            showToast(this, "Internet Not Available")
        }
    }


    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recycleLayout)
        postAdapter = PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter

        }
    }

    override fun onLocationChanged(p0: Location) {
        TODO("Not yet implemented")
    }
}
