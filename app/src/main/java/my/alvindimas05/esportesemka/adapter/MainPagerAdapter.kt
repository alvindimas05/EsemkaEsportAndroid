package my.alvindimas05.esportesemka.adapter

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import my.alvindimas05.esportesemka.databinding.FragmentMainPlayerBinding
import my.alvindimas05.esportesemka.databinding.FragmentMainTeamBinding

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
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = RecyclerViewTeamAdapter(inflater.context as Activity, 6)
        binding = FragmentMainTeamBinding.inflate(inflater, container, false)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = GridLayoutManager(inflater.context, 2)

        return binding.root
    }
}

class FragmentPlayer : Fragment() {
    private lateinit var binding: FragmentMainPlayerBinding
    private lateinit var adapter: RecyclerViewPlayerAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = RecyclerViewPlayerAdapter(inflater.context as Activity, 6)
        binding = FragmentMainPlayerBinding.inflate(inflater, container, false)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = GridLayoutManager(inflater.context, 2)

        return binding.root
    }
}