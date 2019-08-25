package com.oppong.codechallenge.models

import java.io.Serializable

data class Car(
    val id: String,
    val model: String,
    val immatriculation: String,
    val price: Price?,
    val amount: Double?
) : Serializable


