package jp.miynstune.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InfinitePagerRecyclerAdapter(private val items: List<String>) : RecyclerView.Adapter<InfinitePagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfinitePagerViewHolder =
        InfinitePagerViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pager, parent, false))

    override fun onBindViewHolder(holder: InfinitePagerViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = Int.MAX_VALUE
}

class InfinitePagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textView: TextView = itemView.findViewById(R.id.page_name)

    fun bind(position: Int) {
        textView.text = position.toString()
    }
}
