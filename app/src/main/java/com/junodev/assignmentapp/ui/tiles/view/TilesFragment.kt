package com.junodev.assignmentapp.ui.tiles.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.junodev.assignmentapp.R
import com.junodev.assignmentapp.models.presentation.Tiles
import com.junodev.assignmentapp.ui.tiles.viewmodel.TilesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TilesFragment : Fragment(R.layout.fragment_tiles) {

    private val viewModel: TilesViewModel by viewModel()
    private lateinit var adapter: TilesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.initViews()
        initObservers()
    }

    private fun View.initViews() {
        adapter = TilesAdapter(::deleteTile)
        val recycler = findViewById<RecyclerView>(R.id.tiles_recycler_view)
        recycler.layoutManager = GridLayoutManager(
            requireContext(),
            resources.getInteger(R.integer.span_count)
        )
        recycler.adapter = adapter
    }

    private fun initObservers() {
        viewModel.tiles.observe(viewLifecycleOwner, ::show)
    }

    private fun show(tiles: Tiles) {
        adapter.bind(tiles)
    }

    private fun deleteTile(number: Int) {
        viewModel.deleteTile(number)
    }

    companion object {
        fun newInstance() = TilesFragment()
    }
}