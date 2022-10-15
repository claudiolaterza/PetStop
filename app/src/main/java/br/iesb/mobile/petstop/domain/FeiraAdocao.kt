package br.iesb.mobile.petstop.domain

import android.widget.CalendarView

data class FeiraAdocao(
    var id: Long? = null,
    var name: String? = null,
    var local: String? = null,
    var avaliacao: Int? = null,
    var latitude: String? = null,
    var longitude: String? = null,
    var data: String? = null
)