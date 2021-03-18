package com.example.easynvestapp.utils

import java.text.DecimalFormat
import java.util.*

fun Double.formatForBrazilianCurrency(): String {
    val brazilianFormat = DecimalFormat
        .getCurrencyInstance(Locale("pt", "br"))
    return brazilianFormat.format(this)
}