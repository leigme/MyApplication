package me.leig.myapplication.modules.home.controller

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.home_item.view.*
import me.leig.myapplication.R
import me.leig.myapplication.modules.home.controller.ModuleListAdapter.ModuleViewHolder
import me.leig.myapplication.modules.home.data.ModuleBean

/**
 *
 *
 * @author leig.
 * @version 29/10/2017.
 */
class ModuleListAdapter(private val ctx: Context, private val list: ArrayList<ModuleBean>, private val itemClickListener: (ModuleBean) -> Unit): RecyclerView.Adapter<ModuleViewHolder>() {

    override fun onBindViewHolder(holder: ModuleViewHolder?, position: Int) {
        holder!!.bind(ctx, list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ModuleViewHolder {
        return ModuleViewHolder(LayoutInflater.from(ctx).inflate(R.layout.home_item, parent, false), itemClickListener)
    }

    class ModuleViewHolder(val view: View, val itemClickListener: (ModuleBean) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bind(ctx: Context, mb: ModuleBean) {
            view.tv_id.text = mb.id.toString()
            view.tv_title.text = mb.title
            Glide.with(ctx).load(mb.img).into(view.iv_img)
            view.setOnClickListener {
                itemClickListener(mb)
            }
        }
    }
}