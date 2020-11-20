package com.guagua.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.TextView
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CompileTkActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var adapter: CompileTkAdapter? = null

    private val dataStore: DataStore<Preferences> = createDataStore(name = "Setting")
    private val EXAMPLE_COUNTER = preferencesKey<Int>("example_counter4")
    private val EXAMPLE_COUNTER1 = preferencesKey<Int>("example_counter5")

    private var index = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_dan)

        index = intent.getIntExtra("Type", -1)
        title = if (index == 1) "编译判断" else "编译填空"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = CompileTkAdapter(intent.getIntExtra("Type", -1))
        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)

        val exampleCounterFlow: Flow<Int> = dataStore.data
            .map { preferences ->
                preferences[when (index) {
                    1 -> EXAMPLE_COUNTER
                    else -> EXAMPLE_COUNTER1
                }] ?: 0
            }
        lifecycleScope.launch(Dispatchers.IO) {
            exampleCounterFlow.collectLatest {
                withContext(Dispatchers.Main) {
                    Log.d("ssss", "it =-=== $it")
                    recyclerView.scrollToPosition(it)
                }
            }
        }

        recyclerView.addOnScrollListener(
            RecyclerViewPageChangeListenerHelper(snapHelper,
                object : RecyclerViewPageChangeListenerHelper.OnPageChangeListener {
                    override fun onScrollStateChanged(
                        recyclerView: RecyclerView,
                        newState: Int
                    ) {
                    }

                    override fun onScrolled(
                        recyclerView: RecyclerView,
                        dx: Int,
                        dy: Int
                    ) {
                    }

                    override fun onPageSelected(position: Int) {
                        lifecycleScope.launch(Dispatchers.IO) {
                            Log.d("ssss", "====sssss======================")
                            incrementCounter(position)
                        }
                    }
                })
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("sss", "onOptionsItemSelected, itemId: " + item.itemId)
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private suspend fun incrementCounter(position: Int) {
        dataStore.edit { settings ->
            settings[when (index) {
                1 -> EXAMPLE_COUNTER
                else -> EXAMPLE_COUNTER1
            }] = position
        }
    }
}