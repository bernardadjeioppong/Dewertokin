package com.oppong.codechallenge.autolisting

import com.oppong.codechallenge.models.Car

interface CarsRepository {

    fun loadCars(): MutableList<Car>
}