package com.example.easynvestapp.data.repository

import com.example.easynvestapp.data.response.ServerResponse
import com.example.easynvestapp.utils.ResultSimulation
import com.example.easynvestapp.utils.mapToResult
import com.google.gson.Gson

class MainRepositoryMockImpl : MainRepository {

    override suspend fun getApiResult(): ResultSimulation {

        return ResultSimulation.SuccessSimulation(
            Gson().fromJson(
                "{\"investmentParameter\":{\"investedAmount\":32323.0,\"yearlyInterestRate\":9.5512,\"maturityTotalDays\":1981,\"maturityBusinessDays\":1409,\"maturityDate\":\"2023-03-03T00:00:00\",\"rate\":123.0,\"isTaxFree\":false},\"grossAmount\":60528.20,\"taxesAmount\":4230.78,\"netAmount\":56297.42,\"grossAmountProfit\":28205.20,\"netAmountProfit\":23974.42,\"annualGrossRateProfit\":87.26,\"monthlyGrossRateProfit\":0.76,\"dailyGrossRateProfit\":0.000445330025305748,\"taxesRate\":15.0,\"rateProfit\":9.5512,\"annualNetRateProfit\":74.17}",
                ServerResponse::class.java
            ).mapToResult()
        )

    }
}