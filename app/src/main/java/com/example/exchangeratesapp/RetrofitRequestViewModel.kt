package com.example.exchangeratesapp

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_banks.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitRequestViewModel : ViewModel() {

    val currencyModelLiveData = MutableLiveData<CurrencyModel>()
    val bankModelLiveData = MutableLiveData<BankModel>()

    fun setId(id : Int?) {
        RequestTask().execute(id)
    }

    @SuppressLint("StaticFieldLeak")
    inner class RequestTask : AsyncTask<Int, Unit, Unit>() {

        override fun doInBackground(vararg params: Int?) {

            val currencyCall: Call<CurrencyModel> = apiHolder.getCurrency(params[0])
            currencyCall.enqueue(object : Callback<CurrencyModel> {
                override fun onFailure(call: Call<CurrencyModel>, t: Throwable) {

                }
                @SuppressLint("SetTextI18n")
                override fun onResponse(
                    call: Call<CurrencyModel>,
                    response: Response<CurrencyModel>
                ) {
                    currencyModelLiveData.value = response.body()
                }
            })

            val bankCall: Call<BankModel> = apiHolder.getBankNames(params[0])
            bankCall.enqueue(object : Callback<BankModel> {
                override fun onFailure(call: Call<BankModel>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<BankModel>,
                    response: Response<BankModel>
                ) {
                    bankModelLiveData.value = response.body()
                }
            })
        }
    }
}





