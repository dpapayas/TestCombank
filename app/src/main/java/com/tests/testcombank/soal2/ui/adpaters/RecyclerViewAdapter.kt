package com.tests.testcombank.soal2.ui.adpaters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tests.testcombank.R
import com.tests.testcombank.soal2.model.User

open class RecyclerViewAdapter
constructor(
    private val adapterCallback: AdapterCallback
) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private lateinit var userList: List<User>

    fun updateList(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.recycler_row_list,
                parent,
                false
            )
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])
        holder.itemView.setOnClickListener {
            adapterCallback.onItemEditClick(userList[position])
        }
        holder.btnDelete.setOnClickListener {
            adapterCallback.onDeletes(userList[position].id!!)
        }
    }

    override fun getItemCount() = userList.size

    interface AdapterCallback {
        fun onItemEditClick(user: User)
        fun onDeletes(id: String)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var textViewName: TextView = view.findViewById(R.id.text_view_name)
        private val textViewEmail: TextView = view.findViewById(R.id.text_view_email)
        private val textViewStats: TextView = view.findViewById(R.id.text_view_stats)
        internal val btnDelete: Button = view.findViewById(R.id.btnDelete)

        fun bind(data: User) {
            textViewName.text = data.name
            textViewEmail.text = data.email
            textViewStats.text = data.status
        }
    }

    init {
        userList = ArrayList()
    }
}
