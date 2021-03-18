package com.example.easynvestapp.data.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class InvestmentParameter(
    val investedAmount: Double,
    val yearlyInterestRate: Double,
    val maturityTotalDays: Int,
    val maturityBusinessDays: Double,
    val maturityDate: String,
    val rate: Double,
    val isTaxFree: Boolean
): Parcelable
