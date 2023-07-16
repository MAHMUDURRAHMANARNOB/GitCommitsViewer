package com.mahmudur.gitcommitviewer

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahmudur.gitcommitviewer.databinding.ActivityMainBinding
import com.mahmudur.gitcommitviewer.model.CommitViewModel
import com.mahmudur.gitcommitviewer.model.dataModel
import com.mahmudur.gitcommitviewer.utils.CommitAdapter
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private val commitViewModel: CommitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val commitAdapter = CommitAdapter()

        val recyclerView: RecyclerView = findViewById(R.id.commitsRV)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = commitAdapter
        }
        // Observe the commitFlow and submit data to the adapter
            lifecycleScope.launch {
                commitViewModel.commitFlow.collect { pagingData: PagingData<dataModel.Commit> ->
                commitAdapter.submitData(pagingData)
            }
        }

    }
}