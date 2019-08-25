package com.oppong.codechallenge.helpers

import android.content.Context

object JSONReader {

    fun readJSON(context: Context, resourceID: Int): String{
        val rawFile = context.resources.openRawResource(resourceID)
            .bufferedReader().use { it.readText() }
        return rawFile
    }
}