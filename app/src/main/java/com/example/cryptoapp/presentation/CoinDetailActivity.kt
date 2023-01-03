package com.example.cryptoapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoapp.addFavorites.presentation.FavoriteCoinListFragment
import com.example.cryptoapp.databinding.ActivityCoinDetailBinding
import com.example.cryptoapp.domain.CoinItem
import com.example.cryptoapp.presentation.CoinDetailFragment
import com.squareup.picasso.Picasso

class CoinDetailActivity : AppCompatActivity() {


    private val binding by lazy { ActivityCoinDetailBinding.inflate(layoutInflater) }

    private var screenMode = MODE_UNKNOWN
    private var coinFromSymbol = CoinItem.UNDEFINED_FROMSYMBOL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        parseIntent()
//        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
//            finish()
//            return
//        }
        if (savedInstanceState == null ){
            launchRightMode()
        }

    }

    private fun launchRightMode () {
        val fragment = when (screenMode) {
            MODE_COIN_DETAIL -> CoinDetailFragment.newInstance(coinFromSymbol)
            MODE_FAVORITE_LIST -> FavoriteCoinListFragment.newInstance()
            else      -> throw RuntimeException("Unknown screen mode $screenMode")
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_coin_detail, fragment)
            .commit()
    }

    private fun parseIntent () {
        if (!intent.hasExtra(EXTRA_SCREEN_MODE)) {
            throw RuntimeException ("Param screen mode is absent")
        }
        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
        if (mode != MODE_FAVORITE_LIST && mode != MODE_COIN_DETAIL) {
            throw RuntimeException ("Unknown screen mode $mode")
        }
        screenMode = mode
        if (screenMode == MODE_COIN_DETAIL) {
            if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
                throw RuntimeException("Param from symbol is absent")
            }
            coinFromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL) ?: EMPTY_FROM_SYMBOL
        }
    }

    companion object {

        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val MODE_FAVORITE_LIST = "mode_favorite"
        private const val MODE_COIN_DETAIL = "mode_coin"
        const val EXTRA_FROM_SYMBOL = "fSym"
        private const val EMPTY_FROM_SYMBOL = ""
        private const val MODE_UNKNOWN = ""

        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_COIN_DETAIL)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }

        fun newIntent(context: Context) : Intent {
            val intent =Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, MODE_FAVORITE_LIST)
            return intent
        }

    }
}