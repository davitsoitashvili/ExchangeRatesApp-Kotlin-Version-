@file:Suppress("DEPRECATION")

package com.example.exchangeratesapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.crashlytics.android.Crashlytics
import kotlinx.android.synthetic.main.fragment_banks.*

@Suppress("DEPRECATION")
class BanksFragment : Fragment() {

    private val id: Int? by lazy {
        this.arguments!!.getInt("ID")
    }

    private val viewModel: RetrofitRequestViewModel by lazy {
        ViewModelProviders.of(this).get(RetrofitRequestViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_banks, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.setId(id)
        viewModel.currencyModelLiveData.observe(viewLifecycleOwner, Observer {
            SellUSD.text = "Sell USD: ${it.sellUSD}"
            BuyUSD.text = "Buy USD: ${it.buyUSD}"
            SellEUR.text = "Sell EUR: ${it.sellEUR}"
            BuyEUR.text = "Buy EUR: ${it.buyEUR}"
        })
        viewModel.bankModelLiveData.observe(viewLifecycleOwner, Observer {
            Glide.with(this).load(it.image).into(bankImage)
        })
    }


    companion object {
        fun newInstance(id: Int): BanksFragment {
            val bundle: Bundle = Bundle()
            bundle.putInt("ID", id)
            val fragment: BanksFragment = BanksFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}







