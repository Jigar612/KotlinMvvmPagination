package com.example.myapplicationwithpaging3

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationwithpaging3.adapter.general.LoadingStateAdapter
import com.example.myapplicationwithpaging3.adapter.pagingnation.PageListAdapter
import com.example.myapplicationwithpaging3.databinding.ActivityMainBinding
import com.example.myapplicationwithpaging3.entity.UserEntity
import com.example.myapplicationwithpaging3.helper.gone
import com.example.myapplicationwithpaging3.helper.visible
import com.example.myapplicationwithpaging3.model.UserDataModel
import com.example.myapplicationwithpaging3.retrofit.ApiService
import com.example.myapplicationwithpaging3.viewmodelss.MainViewModel
import com.example.myapplicationwithpaging3.viewmodelss.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
//Demo
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()
    private val userViewModel : UserViewModel by viewModels()
    private val list : ArrayList<UserEntity>? =null
    var useList : PagingData<UserDataModel>?= null
    lateinit var abc : String
    @Inject
    lateinit var pageinUserAdapter: PageListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        initViewModel()

    }

    fun initRecyclerView() {
        // binding.apply {
        rvList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(
                applicationContext,
                DividerItemDecoration.VERTICAL
            )
            addItemDecoration(decoration)
            adapter = pageinUserAdapter.withLoadStateHeaderAndFooter(
                header = LoadingStateAdapter { pageinUserAdapter::retry },
                footer = LoadingStateAdapter { pageinUserAdapter::retry }
            )
        }
    }

    private fun initViewModel() {
        lifecycleScope.launchWhenCreated {
            mainViewModel.getAllUserList().collectLatest {
                binding.apply {
                    progressBar.gone()
                    rvList.visible()
                }
                pageinUserAdapter.submitData(it)


            }
        }


    }
}