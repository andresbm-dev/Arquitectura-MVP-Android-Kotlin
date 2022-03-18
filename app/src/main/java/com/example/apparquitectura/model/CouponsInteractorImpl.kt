package com.example.apparquitectura.model

import com.example.apparquitectura.presenter.CouponsPresenter

class CouponsInteractorImpl(var couponsPresenter: CouponsPresenter): CouponsInteractor {
    private var couponsRepository :CouponsRepository = CouponsRepositoryImpl(couponsPresenter)
    override fun getCouponsApi() {
        couponsRepository.getCouponsApi()
    }
}