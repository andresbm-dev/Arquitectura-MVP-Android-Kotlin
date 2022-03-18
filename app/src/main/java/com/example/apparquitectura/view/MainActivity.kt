package com.example.apparquitectura.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.R
import com.example.apparquitectura.model.APIAdapter
import com.example.apparquitectura.presenter.CouponsPresenter
import com.example.apparquitectura.presenter.CouponsPresenterImpl
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//la clase MainActivity Es una clase Hija o Implementada de la interfaz de CouponView
//la clase MaincActivity esta implementando los métodos de la interfaz de CouponView
class MainActivity : AppCompatActivity() , CouponView{


    lateinit var rvCoupons :RecyclerView
    lateinit var couponsPresenter:CouponsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        couponsPresenter = CouponsPresenterImpl(this)
        //this es la misma MainActivity y es una clase de la misma naturaleza de
        //la clase padre que es la interfaz que recibe la clase CouponsPresenterImpl(couponsView:CouponsView)

         rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons.layoutManager = LinearLayoutManager(this)
        getCoupons()




    }

    override fun getCoupons() {
        couponsPresenter.getCoupons()    }

    override fun showCoupons(coupons: ArrayList<Coupon>) {
        rvCoupons.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
    }
}

