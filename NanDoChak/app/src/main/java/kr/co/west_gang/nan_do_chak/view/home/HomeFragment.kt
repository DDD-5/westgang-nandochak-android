package kr.co.west_gang.nan_do_chak.view.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseFragment
import kr.co.west_gang.nan_do_chak.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val layoutResourceId: Int = R.layout.fragment_home

    private val viewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    companion object{
        fun create() = HomeFragment()
    }
}