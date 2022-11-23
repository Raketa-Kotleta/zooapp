package com.example.zooapp

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener

class ZooListFragment:Fragment(R.layout.fragment_list_zoo), com.example.zooapp.OnItemClickListener {
    private lateinit var ZooRV: RecyclerView
    private lateinit var zooListViewModel: ZooViewModel
    companion object{
        @JvmStatic
        fun newInstance()=ZooListFragment();
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutView = inflater.inflate(R.layout.fragment_list_zoo,container, false)
        ZooRV = layoutView.findViewById(R.id.zoo_rv)

        return layoutView
    }

    override fun onClick(zoo: Zoo) {
        Log.i("click","Нажали ${zoo.name}")
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ZooRV.layoutManager = LinearLayoutManager(this.context)
        val activity: MainActivity = getActivity() as MainActivity
        zooListViewModel = activity.ZooList!!
        updateUI(zooListViewModel.zoos.value)
    }

    private inner class StudentListAdapter(private val orderItems: MutableList<Zoo>, val itemClickListener : com.example.zooapp.OnItemClickListener)
        :RecyclerView.Adapter<ZooHolder>() {
        private var selectedItem: Int? = null
        override  fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ZooHolder {
            val view = layoutInflater.inflate(R.layout.zoo_list_element, parent, false)
            return ZooHolder(view)
        }

        override fun getItemCount(): Int = orderItems.size

        override  fun onBindViewHolder(holder: ZooHolder, position: Int) {
            holder.bind(orderItems[position], itemClickListener)
            holder.itemView.setOnLongClickListener{
                selectedItem = holder.adapterPosition
                notifyDataSetChanged()
                true
            }

            if (selectedItem == position)
                holder.itemView.setBackgroundColor(Color.parseColor("#BFFF9E"))
            else holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }

    }

    private inner class ZooHolder(view: View)
        :RecyclerView.ViewHolder(view) {

        private lateinit var zoo: Zoo
        private var nameTextView: TextView = itemView.findViewById(R.id.name_textview_v)
        private var idTextView: TextView = itemView.findViewById(R.id.id_textview_v)
        private var addressTextView: TextView = itemView.findViewById(R.id.adding_info)

        fun bind(zoo: Zoo, clickListener: com.example.zooapp.OnItemClickListener) {
            this.zoo = zoo
            nameTextView.text = zoo.name
            idTextView.text = zoo.id.toString()
            addressTextView.text = zoo.address
            itemView.setOnClickListener {
                clickListener.onClick(zoo)
            }
        }

    }
    private fun updateUI(zooList: MutableList<Zoo>? = null) {
        if (zooList==null) return
        ZooRV.adapter = StudentListAdapter(zooList, this)
    }
}
interface OnItemClickListener{
    fun onClick(zoo: Zoo)
}