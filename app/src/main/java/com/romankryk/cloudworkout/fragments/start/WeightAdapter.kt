package com.romankryk.cloudworkout.fragments.start

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.romankryk.cloudworkout.R

class WeightAdapter internal constructor(view: View) : RecyclerView.Adapter<WeightAdapter.ViewHolder>() {
    private val weight: TextView = view.findViewById(R.id.weight)
    private var size: Int = 0

    internal fun setSize(size: Int) {
        this.size = size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.number_list_item_kg, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: called.")

        holder.num.text = (position + size).toString()

        holder.parentLayout.setOnClickListener {
            Log.d(TAG, "onClick: clicked on: " + (position + size))
            //Toast.makeText(mContext, String.valueOf(position + size), Toast.LENGTH_SHORT).show();

            weight.text = (position + size).toString()
        }
    }

    override fun getItemCount(): Int {
        return 100
    }


    class ViewHolder @SuppressLint("ResourceType")
    constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var num: TextView = itemView.findViewById(R.id.rv_num_item)
        var parentLayout: RelativeLayout = itemView.findViewById(R.id.parent_layout)

    }

    companion object {

        private val TAG = "WeightAdapter"
    }
}
