package com.oppong.codechallenge.autolisting

import android.widget.Button
import com.oppong.codechallenge.activities.BasePresenter
import com.oppong.codechallenge.activities.BaseView

interface MainBinder {
    interface Presenter : BasePresenter {
        fun onViewCreated()
        fun sortCars(byPrice: Boolean = true)
        fun getCarsAdaptor(): CarsAdapter
        fun setSwitchState(activeButton : Button, inActiveButton : Button)
    }

    interface View :
        BaseView<Presenter> {
        fun displayCars()
        fun updateRecyclerViewAdaptor()
    }
}