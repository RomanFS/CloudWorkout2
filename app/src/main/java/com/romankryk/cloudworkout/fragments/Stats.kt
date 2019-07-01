package com.romankryk.cloudworkout.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.romankryk.cloudworkout.R
import kotlinx.android.synthetic.main.stats.*


class Stats : SimpleFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chartSettings()
        stats_items.layoutManager = GridLayoutManager(context, 2)
        stats_items.adapter = StatsAdapter()
    }

    private fun chartSettings() {
        chart1.data = generateBarData(1, 15f, 4)
        chart1.setScaleEnabled(false)
        chart1.axisLeft.textColor = ContextCompat.getColor(context!!, R.color.statusGray)
        chart1.axisRight.textColor = ContextCompat.getColor(context!!, R.color.statusGray) // left y-axis
        chart1.xAxis.textColor = ContextCompat.getColor(context!!, R.color.statusGray)
        chart1.legend.textColor = ContextCompat.getColor(context!!, R.color.statusGray)
        chart1.barData.barWidth = 1f
    }
}