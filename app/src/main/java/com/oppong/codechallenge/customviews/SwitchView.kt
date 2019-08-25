package com.oppong.codechallenge.customviews

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import com.oppong.codechallenge.R

class SwitchView(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {
      var sortByPriceButton: Button
      var sortByNameButton: Button

    init{
        inflate(context, R.layout.segmentcontrol, this)
         sortByPriceButton = findViewById(R.id.priceSort)
         sortByNameButton = findViewById(R.id.nameSort)
    }
}