package com.oppong.codechallenge.autolisting

interface DependencyInjector {
    fun carsRepository() : CarsRepository
}