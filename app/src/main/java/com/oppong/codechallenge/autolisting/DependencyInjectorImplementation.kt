package com.oppong.codechallenge.autolisting

class DependencyInjectorImplementation : DependencyInjector {
    override fun carsRepository() : CarsRepository =
        CarsRepositoryImplementation()
}
