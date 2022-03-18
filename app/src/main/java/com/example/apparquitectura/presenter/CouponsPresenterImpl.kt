package com.example.apparquitectura.presenter

import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.model.CouponsInteractor
import com.example.apparquitectura.model.CouponsInteractorImpl
import com.example.apparquitectura.view.CouponView

class CouponsPresenterImpl(var couponView : CouponView) : CouponsPresenter {
    private  var couponInteractor : CouponsInteractor = CouponsInteractorImpl(this)
    override fun showCoupons(coupons: ArrayList<Coupon>) {
        couponView.showCoupons(coupons)
    }

    override fun getCoupons() {
        couponInteractor.getCouponsApi()
    }


}