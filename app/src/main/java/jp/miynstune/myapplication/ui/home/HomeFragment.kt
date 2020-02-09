package jp.miynstune.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import jp.miynstune.myapplication.InfinitePagerRecyclerAdapter
import jp.miynstune.myapplication.PagerRecyclerAdapter
import jp.miynstune.myapplication.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private val items: MutableList<String> = mutableListOf(
        "Page 1",
        "Page 2",
        "Page 3",
        "Page 4"
    )
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })

        val viewpager2 : ViewPager2 = root.findViewById(R.id.viewpager2)
        viewpager2.adapter = InfinitePagerRecyclerAdapter(items)
        viewpager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        return root
    }
}