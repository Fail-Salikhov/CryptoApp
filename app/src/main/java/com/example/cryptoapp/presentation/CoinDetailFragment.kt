package com.example.cryptoapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.CoinDetailActivity
import com.example.cryptoapp.CoinViewModel
import com.example.cryptoapp.databinding.ActivityCoinDetailBinding
import com.example.cryptoapp.databinding.FragmentCoinDetailBinding
import com.squareup.picasso.Picasso

class CoinDetailFragment: Fragment() {

    private var _binding : FragmentCoinDetailBinding? = null
    val binding : FragmentCoinDetailBinding
    get() = _binding ?: throw RuntimeException("FragmentCoinDetailBinding")

    private lateinit var viewModel: CoinViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fromSymbol = getSymbol()
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbol).observe( viewLifecycleOwner) { it ->
            with(binding){
                tvPrice.text = it.price
                tvMinPrice.text = it.lowday
                tvMaxPrice.text = it.highday
                tvLastMarket.text = it.lastmarket
                tvLastUpdate.text = it.lastupdate
                tvFromSymbol.text = it.fromsymbol
                tvToSymbol.text = it.tosymbol
                Picasso.get().load(it.imageurl).into(ivLogoCoin)
                Log.d("testdetail", it.toString())
            }

        }
    }

    private fun getSymbol (): String {
        return requireArguments().getString(EXTRA_FROM_SYMBOL, EMPTY_FROM_SYMBOL)
    }

    companion object {
        const val EXTRA_FROM_SYMBOL = "fSym"
        private const val EMPTY_FROM_SYMBOL = ""

        fun newInstance (fromSymbol: String) :Fragment {
            return CoinDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_FROM_SYMBOL, fromSymbol)
                }
            }
        }
    }

}