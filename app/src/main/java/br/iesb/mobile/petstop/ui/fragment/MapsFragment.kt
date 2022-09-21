package br.iesb.mobile.petstop.ui.fragment

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.iesb.mobile.petstop.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {
    public var lati:Double = 0.1
    public var longe:Double = 0.1

    private val callback = OnMapReadyCallback { googleMap ->
        lati = -15.84328432 //modificar para pegar do banco
        longe = -47.8349832948 //modificar para pegar do banco
        val location = LatLng(lati, longe)
        googleMap.addMarker(MarkerOptions()
            .position(location)
            .title("TituloTeste"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 13f))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}