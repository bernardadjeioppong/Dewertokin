package com.oppong.codechallenge.autolisting

import android.content.Context
import android.widget.Button
import com.oppong.codechallenge.R
import com.oppong.codechallenge.application.MyApplication
import com.oppong.codechallenge.models.Car

class MainPresenter(
    view: MainBinder.View,
    dependencyInjector: DependencyInjector
) : MainBinder.Presenter {
    private val carsRepository = dependencyInjector.carsRepository()
    private var view: MainBinder.View? = view
    private var cars : MutableList<Car> = mutableListOf()
    private lateinit var carsAdapter: CarsAdapter

    override fun onDestroy() {
        this.view = null
    }

    override fun onViewCreated() {
        loadCars()
    }

    override fun sortCars(byPrice: Boolean) {
        if(byPrice) {
            cars = cars.sortedWith (Comparator{ a, b ->
                when {
                    a.amount!! > b.amount!! -> 1
                    a.amount < b.amount -> -1
                    else -> 0
                }
            } ) as MutableList
        } else
            cars.sortBy { it.model }

        carsAdapter = CarsAdapter(cars, view as Context)
        view?.updateRecyclerViewAdaptor()
    }

    override fun setSwitchState(activeButton: Button, inActiveButton: Button) {
        activeButton.let {
            it.setBackgroundResource(R.color.colorPrimary)
            it.setTextColor(MyApplication.appContext.resources.getColor(R.color.white))
        }

        inActiveButton.let {
            it.setTextColor(MyApplication.appContext.resources.getColor(R.color.colorPrimary))
            it.setBackgroundResource(R.color.white)
        }
    }

    override fun getCarsAdaptor() = carsAdapter

    private fun loadCars() {
        cars = carsRepository.loadCars()
        carsAdapter = CarsAdapter(cars, view as Context)
        view?.displayCars()
    }


}
