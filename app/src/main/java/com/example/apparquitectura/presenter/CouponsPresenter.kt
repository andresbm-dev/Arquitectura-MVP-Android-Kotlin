package com.example.apparquitectura.presenter

import com.example.apparquitectura.model.Coupon

interface CouponsPresenter {
    //vista
    fun showCoupons( coupons : ArrayList<Coupon>) //tiene que ver con el envio de la lista de cupones a la vista entonces retorna los cupones
    //interactor (casos de yso -> acciones de que se reflejan hacia el usuario)
    fun getCoupons()

}