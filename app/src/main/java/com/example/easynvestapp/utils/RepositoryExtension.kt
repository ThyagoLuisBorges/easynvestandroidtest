package com.example.easynvestapp.utils

import com.example.easynvestapp.data.model.Result
import com.example.easynvestapp.data.response.ServerResponse

fun ServerResponse.mapToResult(): Result {
    return Result(
        valorAplicadoInicialmente = this.investmentParameter.investedAmount,
        valorBrutoDoInvestimento = this.grossAmount,
        valorDoRendimento = this.grossAmountProfit,
        irSobreInvestimento = this.taxesRate,
        valorLiquidoDoInvestimento = this.netAmount,
        dataDeResgate = this.investmentParameter.maturityDate,
        diasCorridos = this.investmentParameter.maturityTotalDays,
        rendimentoMensal = this.monthlyGrossRateProfit,
        percentualDoCdi = this.investmentParameter.rate,
        rentabilidadeAnual = this.annualGrossRateProfit,
        rentabilidadeNoPeriodo = this.rateProfit
    )
}