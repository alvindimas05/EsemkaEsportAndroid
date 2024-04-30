package my.alvindimas05.esportesemka.adapter

import android.app.Activity
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import my.alvindimas05.esportesemka.Api
import my.alvindimas05.esportesemka.databinding.RecyclerPlayerItemBinding

class RecyclerViewPlayerAdapter (
    private val avt: Activity,
    var items: List<PlayerItem>
) : RecyclerView.Adapter<RecyclerViewPlayerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = RecyclerPlayerItemBinding.inflate(avt.layoutInflater)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.name.text = item.ign + " (" + item.team.name + ")"
        holder.binding.role.text = item.playerRole.name
        Glide.with(holder.itemView.context).load(Api.baseUrl + "players/" + item.image)
            .into(holder.binding.image)
    }

    class ViewHolder (
        val binding: RecyclerPlayerItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

    data class PlayerItem(val team: PlayerTeam, val ign: String, val playerRole: PlayerRole, val image: String)
    data class PlayerRole(val name: String)
    data class PlayerTeam(val name: String)
}