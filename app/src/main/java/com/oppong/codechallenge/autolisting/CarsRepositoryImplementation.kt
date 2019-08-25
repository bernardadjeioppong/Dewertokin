package com.oppong.codechallenge.autolisting

import android.content.Context
import android.util.Log
import com.oppong.codechallenge.R
import com.oppong.codechallenge.application.MyApplication
import com.oppong.codechallenge.helpers.JSONReader
import com.oppong.codechallenge.models.Car
import com.oppong.codechallenge.models.Price
import org.json.JSONObject

class CarsRepositoryImplementation : CarsRepository {

    private var cars: MutableList<Car> = mutableListOf()

    override fun loadCars(): MutableList<Car> {

        var cars: MutableList<Car> = mutableListOf()
        val carsJson = JSONReader.readJSON(MyApplication.appContext, R.raw.cars)
        val carsPrice = pricesFromJson(MyApplication.appContext)
        try {
            val json = JSONObject(carsJson)
            json.keys().forEach {
                val jsonObj = json.getJSONObject(it)
                val id = jsonObj.getString("id")
                val model = jsonObj.getString("Model")
                val immatriculation = jsonObj.getString("Immatriculation")
                val price = priceByID(carsPrice, id)
                cars.add(Car(id, model, immatriculation,price, price?.price?.replace(" Euro", "")?.replace(".", "")?.toDouble()))
            }
        } catch (e: Exception) {
            Log.e("Error", e.toString())
        }

        //cars = cars.sortedWith (compareBy{ it.amount } ) as MutableList
        cars = cars.sortedWith (Comparator{ a, b ->
            when {
                a.amount!! > b.amount!! -> 1
                a.amount < b.amount -> -1
                else -> 0
            }
        } ) as MutableList
        this.cars = cars
        return cars
    }

    private fun pricesFromJson(context: Context): MutableList<Price> {
        val prices: MutableList<Price> = mutableListOf()
        val pricesJson = JSONReader.readJSON(context, R.raw.prices)

        try {
            val json = JSONObject(pricesJson)
            json.keys().forEach {
                val jsonObj = json.getJSONObject(it)
                val id = jsonObj.getString("id")
                val price = jsonObj.getString("Price")
                prices.add(Price(id, price))
            }
        } catch (e: Exception) {
            Log.e("Error", e.toString())
        }
        return prices
    }

    private fun priceByID(prices: MutableList<Price>, id: String): Price? {
        return prices.firstOrNull { it.id == id }
    }
}