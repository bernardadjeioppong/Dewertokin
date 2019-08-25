package com.oppong.codechallenge.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import com.oppong.codechallenge.R
import com.oppong.codechallenge.autolisting.DependencyInjectorImplementation
import com.oppong.codechallenge.autolisting.MainBinder
import com.oppong.codechallenge.autolisting.MainPresenter
import com.oppong.codechallenge.customviews.SwitchView

class MainActivity : AppCompatActivity(), MainBinder.View {

    private lateinit var switch: SwitchView
    private lateinit var overLay: View
    private lateinit var carsRecyclerView: RecyclerView
    private lateinit var viewPresenter: MainBinder.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()
        supportActionBar?.title = resources.getString(R.string.title)
        setPresenter(
            MainPresenter(
                this,
                DependencyInjectorImplementation()
            )
        )
        viewPresenter.onViewCreated()
        setUpViewActions()
    }

    private fun initializeViews() {
        switch = findViewById(R.id.switchview)
        carsRecyclerView = findViewById(R.id.recyclerView)
        overLay = findViewById(R.id.overlay)
    }

    private fun setUpViewActions() {
        switch.sortByPriceButton.setOnClickListener {
            viewPresenter.sortCars(byPrice = true)
            viewPresenter.setSwitchState(switch.sortByPriceButton, switch.sortByNameButton)
        }
        switch.sortByNameButton.setOnClickListener {
            viewPresenter.sortCars(byPrice = false)
            viewPresenter.setSwitchState(switch.sortByNameButton, switch.sortByPriceButton)
        }
    }

    override fun updateRecyclerViewAdaptor() {
        carsRecyclerView.adapter = viewPresenter.getCarsAdaptor()
    }

    override fun displayCars() {
        carsRecyclerView.setHasFixedSize(false)
        carsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        carsRecyclerView.adapter = viewPresenter.getCarsAdaptor()

    }

    override fun onDestroy() {
        viewPresenter.onDestroy()
        super.onDestroy()
    }

    override fun setPresenter(presenter: MainBinder.Presenter) {
        this.viewPresenter = presenter
    }


}
