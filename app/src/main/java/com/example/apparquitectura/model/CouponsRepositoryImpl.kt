package com.example.apparquitectura.model

import android.util.Log
import com.example.apparquitectura.R
import com.example.apparquitectura.presenter.CouponsPresenter
import com.example.apparquitectura.view.RecyclerCouponsAdapter
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponsRepositoryImpl(var couponsPresenter: CouponsPresenter):CouponsRepository {

    //toda la lógica de conexión
    override fun getCouponsApi() {

        var coupons:ArrayList<Coupon> = arrayListOf()
        //hace parte del modelo
        val apiaAdapter = APIAdapter()
        val apiService = apiaAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t?.message ?: "")
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    var jsonObject = jsonElement.asJsonObject
                    var coupon = Coupon(jsonObject)
                    coupons.add(coupon)
                }
                couponsPresenter.showCoupons(coupons)
            }



        })

            //couponsPresenter.showCoupons()
    }
}