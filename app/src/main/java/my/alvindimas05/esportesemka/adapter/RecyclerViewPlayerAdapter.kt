package my.alvindimas05.esportesemka.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.alvindimas05.esportesemka.databinding.RecyclerPlayerItemBinding

class RecyclerViewPlayerAdapter (
    val avt: Activity,
    val count: Int
) : RecyclerView.Adapter<RecyclerViewPlayerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = RecyclerPlayerItemBinding.inflate(avt.layoutInflater)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = count

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    class ViewHolder (
        val binding: RecyclerPlayerItemBinding
    ) : RecyclerView.ViewHolder(binding.root)
}