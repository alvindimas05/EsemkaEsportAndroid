package my.alvindimas05.esportesemka.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.alvindimas05.esportesemka.databinding.RecyclerTeamItemBinding

class RecyclerViewTeamAdapter (
    val avt: Activity,
    val count: Int
) : RecyclerView.Adapter<RecyclerViewTeamAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = RecyclerTeamItemBinding.inflate(avt.layoutInflater)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = count

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    class ViewHolder (
        val binding: RecyclerTeamItemBinding
    ) : RecyclerView.ViewHolder(binding.root)
}