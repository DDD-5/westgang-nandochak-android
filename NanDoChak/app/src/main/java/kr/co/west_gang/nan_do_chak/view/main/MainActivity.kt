package kr.co.west_gang.nan_do_chak.view.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.west_gang.nan_do_chak.R
import kr.co.west_gang.nan_do_chak.architecture.BaseActivity
import kr.co.west_gang.nan_do_chak.databinding.ActivityMainBinding
import kr.co.west_gang.nan_do_chak.util.AppConfig
import kr.co.west_gang.nan_do_chak.util.AppConfig.FRAGMENT_ID_HOME
import kr.co.west_gang.nan_do_chak.util.AppConfig.TAG_DEBUG
import kr.co.west_gang.nan_do_chak.util.logD
import kr.co.west_gang.nan_do_chak.view.account.AccountFragment
import kr.co.west_gang.nan_do_chak.view.alarm.AlarmFragment
import kr.co.west_gang.nan_do_chak.view.home.HomeFragment

class MainActivity : BaseActivity() {

    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)
    private val viewModel: MainViewModel by viewModels()

    private lateinit var homeFragment: HomeFragment
    private lateinit var alarmFragment: AlarmFragment
    private lateinit var accountFragment: AccountFragment

    private var lastActivePage: Fragment? = null
    private val fragmentTransaction
        get() = supportFragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        logD(TAG_DEBUG, "Main Activity onCreate")

        initFragments(savedInstanceState)
        initNavigationTab()

        observeLiveData()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (!::homeFragment.isInitialized && !::alarmFragment.isInitialized && !::accountFragment.isInitialized) {
            return
        }

        if (homeFragment.activity != null && alarmFragment.activity != null && accountFragment.activity != null) {
            with(supportFragmentManager) {
                putFragment(outState, AppConfig.FRAGMENT_ID_HOME, homeFragment)
                putFragment(outState, AppConfig.FRAGMENT_ID_ALARM, alarmFragment)
                putFragment(outState, AppConfig.FRAGMENT_ID_ACCOUNT, accountFragment)
            }
        }

        super.onSaveInstanceState(outState)
    }

    private fun initFragments(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            with(supportFragmentManager) {
                homeFragment =
                        getFragment(savedInstanceState, AppConfig.FRAGMENT_ID_HOME) as HomeFragment?
                                ?: HomeFragment.create()
                alarmFragment =
                        getFragment(savedInstanceState, AppConfig.FRAGMENT_ID_ALARM) as AlarmFragment?
                                ?: AlarmFragment.create()
                accountFragment = getFragment(
                        savedInstanceState,
                        AppConfig.FRAGMENT_ID_ACCOUNT
                ) as AccountFragment?
                        ?: AccountFragment.create()
            }
        } ?: run {
            homeFragment = HomeFragment.create()
            alarmFragment = AlarmFragment.create()
            accountFragment = AccountFragment.create()
        }
        lastActivePage = supportFragmentManager.findFragmentById(R.id.mainContainerFrame)

        binding.bottomTab.itemIconTintList = null
        val mainContainerFrame = R.id.mainContainerFrame

        homeFragment.also {
            if (!it.isAdded) {
                fragmentTransaction.add(mainContainerFrame, it).commitAllowingStateLoss()
                lastActivePage = it
            }
        }

        alarmFragment.also {
            if (!it.isAdded) {
                fragmentTransaction.add(mainContainerFrame, it).hide(it).commitAllowingStateLoss()
            }
        }

        accountFragment.also {
            if (!it.isAdded) {
                fragmentTransaction.add(mainContainerFrame, it).hide(it).commitAllowingStateLoss()
            }
        }
    }

    private fun initNavigationTab() {
        binding.bottomTab.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    if (isCurrentActivePage(homeFragment)) {
                        showPage(PAGE_IDX_HOME)
                    }
                }
                R.id.alarmFragment -> {
                    if (isCurrentActivePage(alarmFragment)) {
                        showPage(PAGE_IDX_ALARM)
                    }

                }
                R.id.accountFragment -> {
                    if (isCurrentActivePage(accountFragment)) {
                        showPage(PAGE_IDX_ACCOUNT)
                    }
                }
            }
            true
        }
    }

    private fun showPage(pageIndex: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            val currentPage = supportFragmentManager.fragments[pageIndex]
            lastActivePage?.let {
                fragmentTransaction.hide(it).show(currentPage).commitAllowingStateLoss()
                lastActivePage = currentPage
                val currentItemId = binding.bottomTab.menu.getItem(pageIndex).itemId
                binding.bottomTab.menu.findItem(currentItemId).setChecked(true)
            } ?: return@launch
        }
    }

    private fun isCurrentActivePage(currentPage: Fragment) = lastActivePage != currentPage

    private fun observeLiveData() {
    }

    companion object {
        const val PAGE_IDX_HOME = 0
        const val PAGE_IDX_ALARM = 1
        const val PAGE_IDX_ACCOUNT = 2
    }
}