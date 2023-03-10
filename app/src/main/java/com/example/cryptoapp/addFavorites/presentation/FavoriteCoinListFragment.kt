package com.example.cryptoapp.addFavorites.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoapp.CoinDetailActivity
import com.example.cryptoapp.databinding.FaragmentFavoriteCoinListBinding
import com.example.cryptoapp.domain.CoinItem
import com.example.cryptoapp.presentation.CoinDetailFragment
import com.example.cryptoapp.presentation.CryptoApp
import com.example.cryptoapp.presentation.adapter.CoinInfoAdapter
import com.example.cryptoapp.presentation.viewModel.ViewModelFactory
import javax.inject.Inject

class FavoriteCoinListFragment : Fragment() {

    private lateinit var viewModel : FavoriteCoinViewModel

    @Inject
    lateinit var viewModelFactory : ViewModelFactory

    private lateinit var adapter : CoinInfoAdapter

    private var _binding: FaragmentFavoriteCoinListBinding? = null
    private val binding : FaragmentFavoriteCoinListBinding
    get() = _binding ?: throw RuntimeException("FragmentCoinDetailBinding is null")

    private val component by lazy {
        (requireActivity().application as CryptoApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FaragmentFavoriteCoinListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CoinInfoAdapter(requireContext())
        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener{
            override fun onCoinClick(coinItem: CoinItem) {
                launchDetailActivity(coinItem.fromsymbol)
            }
        }
        binding.rvCoinPriceList.adapter = adapter
        viewModel = ViewModelProvider(this, viewModelFactory)[FavoriteCoinViewModel::class.java]
        viewModel.favoriteCoinList.observe(viewLifecycleOwner, Observer{
            adapter.submitList(it)
        })
        setupSwipeListener(binding.rvCoinPriceList)
    }

    private fun setupSwipeListener (rvFavoriteCoin: RecyclerView) {
        val callback = object :ItemTouchHelper.SimpleCallback(0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val coin = adapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteFavoriteCoin(coin.fromsymbol)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvFavoriteCoin)
    }

    private fun launchDetailActivity ( fromSymbol: String) {
        val intent = CoinDetailActivity.newIntent(requireContext(), fromSymbol)
        startActivity(intent)
    }

    companion object {
        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val MODE_FAVORITE_LIST = "mode_favorite"

        fun newInstance(): Fragment {
            return FavoriteCoinListFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_SCREEN_MODE, MODE_FAVORITE_LIST)
                }
            }
        }
    }
}