package kr.co.west_gang.nan_do_chak.view.account

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseFragment
import kr.co.west_gang.nan_do_chak.databinding.FragmentAccountBinding

class AccountFragment : BaseFragment<FragmentAccountBinding>() {

    override val layoutResourceId: Int = R.layout.fragment_account

    val viewModel by lazy {
        ViewModelProvider(this).get(AccountViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
    }

    companion object {
        fun create() = AccountFragment()
    }
}