package my.alvindimas05.esportesemka.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import my.alvindimas05.esportesemka.Api
import my.alvindimas05.esportesemka.databinding.RecyclerTeamItemBinding

class RecyclerViewTeamAdapter(
    private val avt: Activity,
    var items: List<TeamItem>
) : RecyclerView.Adapter<RecyclerViewTeamAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = RecyclerTeamItemBinding.inflate(avt.layoutInflater)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.name.text = items[position].name
        Glide.with(holder.itemView.context).load(Api.baseUrl + "logos/" + items[position].logo500)
            .into(holder.binding.image)
    }

    class ViewHolder (
        val binding: RecyclerTeamItemBinding
    ) : RecyclerView.ViewHolder(binding.root)
    data class TeamItem(val name: String, val logo500: String)
}

