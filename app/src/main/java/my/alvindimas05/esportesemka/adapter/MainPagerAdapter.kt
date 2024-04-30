package my.alvindimas05.esportesemka.adapter

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import my.alvindimas05.esportesemka.Api
import my.alvindimas05.esportesemka.databinding.FragmentMainPlayerBinding
import my.alvindimas05.esportesemka.databinding.FragmentMainTeamBinding
import java.util.Locale

private const val NUMPAGES = 2
class MainPagerAdapter (
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = NUMPAGES
    override fun createFragment(position: Int): Fragment {
        return when(position){
            1 -> FragmentPlayer()
            else -> FragmentTeam()
        }
    }
}

class FragmentTeam : Fragment() {
    private lateinit var binding: FragmentMainTeamBinding
    private lateinit var adapter: RecyclerViewTeamAdapter
    private lateinit var teamData: List<RecyclerViewTeamAdapter.TeamItem>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainTeamBinding.inflate(inflater, container, false)
        binding.recyclerview.layoutManager = GridLayoutManager(inflater.context, 2)
        getApiData(inflater)

        return binding.root
    }
    private fun onSearchChange(text: Editable?){
        adapter.items = teamData.filter { it.name.contains(text.toString().toUpperCase(Locale.ROOT)) }
        adapter.notifyDataSetChanged()
    }
    private fun getApiData(inflater: LayoutInflater){
        val queue = Volley.newRequestQueue(inflater.context)
        val request = StringRequest(Api.baseUrl + "api/teams", {
            val type = object : TypeToken<List<RecyclerViewTeamAdapter.TeamItem>>() {}.type
            teamData = Gson().fromJson(it, type)

            adapter = RecyclerViewTeamAdapter(inflater.context as Activity, teamData)
            binding.recyclerview.adapter = adapter
            binding.search.addTextChangedListener { text -> onSearchChange(text) }
        }, { it.printStackTrace() })
        queue.add(request)
    }
}

class FragmentPlayer : Fragment() {
    private lateinit var binding: FragmentMainPlayerBinding
    private lateinit var adapter: RecyclerViewPlayerAdapter
    private lateinit var playerData: List<RecyclerViewPlayerAdapter.PlayerItem>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainPlayerBinding.inflate(inflater, container, false)
        binding.recyclerview.layoutManager = GridLayoutManager(inflater.context, 2)
        getApiData(inflater)

        return binding.root
    }
    private fun onSearchChange(text: Editable?){
        adapter.items = playerData.filter { it.ign.contains(text.toString())
                || it.playerRole.name.contains(text.toString())
                || it.team.name.contains(text.toString()) }
        adapter.notifyDataSetChanged()
    }
    private fun getApiData(inflater: LayoutInflater){
        val queue = Volley.newRequestQueue(inflater.context)
        val request = StringRequest(Api.baseUrl + "api/players", {
            val type = object : TypeToken<List<RecyclerViewPlayerAdapter.PlayerItem>>() {}.type
            playerData = Gson().fromJson(it, type)
            adapter = RecyclerViewPlayerAdapter(inflater.context as Activity, playerData)
            binding.recyclerview.adapter = adapter
            binding.search.addTextChangedListener { text -> onSearchChange(text) }
        }, { it.printStackTrace() })
        queue.add(request)
    }
}