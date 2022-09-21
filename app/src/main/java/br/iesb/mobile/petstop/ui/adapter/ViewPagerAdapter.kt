package br.iesb.mobile.petstop.ui.adapter
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.iesb.mobile.petstop.ui.fragment.onboarding.screen.Onboarding1Fragment
import br.iesb.mobile.petstop.ui.fragment.onboarding.screen.Onboarding2Fragment
import br.iesb.mobile.petstop.ui.fragment.onboarding.screen.Onboarding3Fragment

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager){

    private val fragments = listOf(
        Onboarding1Fragment(),
        Onboarding2Fragment(),
        Onboarding3Fragment(),

    )
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

}