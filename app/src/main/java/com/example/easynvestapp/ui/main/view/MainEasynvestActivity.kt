package com.example.easynvestapp.ui.main.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.easynvestapp.R
import com.example.easynvestapp.data.api.RetrofitBuilder
import com.example.easynvestapp.data.model.Result
import com.example.easynvestapp.ui.base.ViewModelFactory
import com.example.easynvestapp.ui.main.viewmodel.MainViewModel
import com.example.easynvestapp.utils.ResultSimulation
import com.example.easynvestapp.utils.addPercentSymbol
import com.example.easynvestapp.utils.dateFormat
import com.example.easynvestapp.utils.formatForBrazilianCurrency

class MainEasynvestActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupObservers()

    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(RetrofitBuilder.apiService)
        ).get(MainViewModel::class.java)
    }

    private fun setupUI(parametersResult: Result) {
        val totalDaSimulacao = findViewById<TextView>(R.id.totalDaSimulacaoTV)
        val rendimentoTotal = findViewById<TextView>(R.id.rendimentoTotalTV)
        val valorAplicadoInicialmente =
            findViewById<TextView>(R.id.valorAplicadoInicialmenteResultadoTV)
        val valorBrutoDoInvestimento =
            findViewById<TextView>(R.id.valorBrutoDoInvestimentoResultadoTV)
        val valorDoRendimento = findViewById<TextView>(R.id.valorDoRendimentoResultadoTV)
        val irDoInvestimento = findViewById<TextView>(R.id.irDoInvestimentoResultadoTV)
        val valorLiquidoDoInvestimento =
            findViewById<TextView>(R.id.valorLiquidoDoInvestimentoResultadoTV)
        val dataDeResgate = findViewById<TextView>(R.id.dataDeResgateResultadoTV)
        val diasCorridos = findViewById<TextView>(R.id.diasCorridosResultadoTV)
        val rendimentoMensal = findViewById<TextView>(R.id.rendimentoMensalResultadoTV)
        val percentualDoCdi = findViewById<TextView>(R.id.percentualDoCdiResultadoTV)
        val rentabilidadeAnual = findViewById<TextView>(R.id.rentabilidadeAnualResultadoTV)
        val rentabilidadeNoPeriodo = findViewById<TextView>(R.id.rentabilidadeNoPeriodoResultadoTV)

        totalDaSimulacao.text =
            parametersResult.valorBrutoDoInvestimento.formatForBrazilianCurrency()
        rendimentoTotal.text =
            "Rendimento total de ${parametersResult.valorDoRendimento.formatForBrazilianCurrency()}"
        valorAplicadoInicialmente.text =
            parametersResult.valorAplicadoInicialmente.formatForBrazilianCurrency()
        valorBrutoDoInvestimento.text =
            parametersResult.valorBrutoDoInvestimento.formatForBrazilianCurrency()
        valorDoRendimento.text = parametersResult.valorDoRendimento.formatForBrazilianCurrency()
        irDoInvestimento.text = parametersResult.irSobreInvestimento.formatForBrazilianCurrency()
        valorLiquidoDoInvestimento.text =
            parametersResult.valorLiquidoDoInvestimento.formatForBrazilianCurrency()
        dataDeResgate.text = parametersResult.dataDeResgate.dateFormat()
        diasCorridos.text = parametersResult.diasCorridos.toString()
        rendimentoMensal.text = parametersResult.rendimentoMensal.toString().addPercentSymbol()
        percentualDoCdi.text = parametersResult.percentualDoCdi.toString().addPercentSymbol()
        rentabilidadeAnual.text = parametersResult.rentabilidadeAnual.toString().addPercentSymbol()
        rentabilidadeNoPeriodo.text =
            parametersResult.rentabilidadeNoPeriodo.toString().addPercentSymbol()
    }

    private fun setupObservers() {
        viewModel.eventView.observe(this, Observer {
            it?.let {
                when (it) {
                    is ResultSimulation.SuccessSimulation -> setupUI(it.resultSimulation)
                    is ResultSimulation.ErrorSimulation -> {

                    }
                }
            }
        })
        viewModel.getResult()
    }
}