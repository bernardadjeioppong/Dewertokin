package com.oppong.codechallenge.autolisting

import android.content.Context
import android.os.Handler
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.oppong.codechallenge.R
import com.oppong.codechallenge.models.Car

class CarsAdapter(
    var cars: List<Car>,
    val context: Context
) : RecyclerView.Adapter<CarsAdapter.CarViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CarViewHolder {
        return CarViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.car_recycle_cell,
                viewGroup,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bindView(position)
    }

    inner class CarViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val model: TextView = view.findViewById(R.id.model)
        private val immatriculation: TextView = view.findViewById(R.id.immatriculation)
        private val price: TextView = view.findViewById(R.id.price)
        private val spinner: ProgressBar = view.findViewById(R.id.progressBar)

        fun bindView(position: Int) {
            val car = cars[position]

            model.text = car.model
            immatriculation.text = car.immatriculation
            price.text = car.price?.price
            spinner.visibility = View.INVISIBLE

            view.setOnClickListener {
                spinner.visibility = View.VISIBLE
                Handler().postDelayed({

                    spinner.visibility = View.INVISIBLE
                    when (price.visibility) {
                        View.VISIBLE -> price.visibility = View.GONE
                        View.GONE -> price.visibility = View.VISIBLE
                    }

                }, 3000)
            }
        }
    }
}


