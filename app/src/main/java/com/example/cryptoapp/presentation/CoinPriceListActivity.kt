package com.example.cryptoapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.CoinDetailActivity
import com.example.cryptoapp.CoinViewModel
import com.example.cryptoapp.R
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.domain.CoinItem
import com.example.cryptoapp.presentation.adapter.CoinInfoAdapter
import javax.inject.Inject

class CoinPriceListActivity : AppCompatActivity() {

//
//    private lateinit var viewModel: CoinViewModel
//
//    @Inject
//    lateinit var viewModelFactory: ViewModelFactory
//
//    private val binding by lazy {
//        ActivityMainBinding.inflate(layoutInflater)
//    }
//
//    private val component by lazy {
//        (application as CryptoApp).component
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        component.inject(this)
//
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//        val adapter = CoinInfoAdapter(this)
//        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
//            override fun onCoinClick(coinPriceInfo: CoinItem) {
//                if (isOnePaneMode()) {
//                    launchDetailActivity(coinPriceInfo.fromsymbol)
//                } else {
//                    launchDetailFragment(coinPriceInfo.fromsymbol)
//                }
//            }
//        }
//        binding.rvCoinPriceList.adapter = adapter
//        binding.rvCoinPriceList.itemAnimator = null
//        viewModel = ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
//        viewModel.coinInfoList.observe(this) {
//            adapter.submitList(it)
//        }
//    }
//
//    private fun isOnePaneMode() = binding.fragmentContainer == null
//
//    private fun launchDetailActivity(fromSymbol: String) {
//        val intent = CoinDetailActivity.newIntent(
//            this@CoinPriceListActivity,
//            fromSymbol
//        )
//        startActivity(intent)
//    }
//
//    private fun launchDetailFragment(fromSymbol: String) {
//        supportFragmentManager.popBackStack()
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.fragment_container, CoinDetailFragment.newInstance(fromSymbol))
//            .addToBackStack(null)
//            .commit()
//    }
//}
    private lateinit var viewModel : CoinViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val component by lazy {
        (application as CryptoApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = CoinInfoAdapter(this)
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener{
            override fun onCoinClick(coinItem: CoinItem) {
                if (isOnPaneMode()) {
                    launchDetailActivity(coinItem.fromsymbol)
                } else {
                    launchDetailFragment(coinItem.fromsymbol)
                }
            }
        }
        binding.rvCoinPriceList.adapter = adapter
        viewModel = ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
        viewModel.coinInfoList.observe(this, Observer {
            adapter.submitList(it)
            Log.d("test", it.toString())
        })
    }

    private fun launchDetailActivity ( fromSymbol: String) {
        val intent = CoinDetailActivity.newIntent(this@CoinPriceListActivity, fromSymbol)
        startActivity(intent)
    }

    private fun isOnPaneMode () =binding.fragmentContainer == null

    private fun launchDetailFragment (fromSymbol: String) {
        supportFragmentManager.popBackStack()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, CoinDetailFragment.newInstance(fromSymbol))
            .addToBackStack(null)
            .commit()
    }
}