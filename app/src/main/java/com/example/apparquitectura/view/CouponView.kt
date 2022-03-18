package com.example.apparquitectura.view

import com.example.apparquitectura.model.Coupon

interface CouponView {

    fun getCoupons()

    fun showCoupons( coupons : ArrayList<Coupon>)   //en el constructor esta la lista que vamos a recibir del presentador
}