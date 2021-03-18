package com.example.easynvestapp.data.model

data class Result(
    val valorAplicadoInicialmente: Double,
    val valorBrutoDoInvestimento: Double,
    val valorDoRendimento: Double,
    val irSobreInvestimento: Double,
    val valorLiquidoDoInvestimento: Double,
    val dataDeResgate: String,
    val diasCorridos: Int,
    val rendimentoMensal: Double,
    val percentualDoCdi: Double,
    val rentabilidadeAnual: Double,
    val rentabilidadeNoPeriodo: Double
)
