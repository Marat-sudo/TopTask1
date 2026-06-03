package adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {


    private val fragmentsList = mutableListOf<Fragment>()
    private val titlesList = mutableListOf<String>()


    fun addFragment(fragment: Fragment, title: String) {
        fragmentsList.add(fragment)
        titlesList.add(title)
    }


    override fun getItemCount(): Int = fragmentsList.size


    override fun createFragment(position: Int): Fragment = fragmentsList[position]


    fun getTitle(position: Int): String = titlesList[position]
}