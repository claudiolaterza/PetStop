package br.iesb.mobile.petstop.domain

import android.widget.CalendarView

data class FeiraAdocao(
    var id: Long? = null,
    var name: String? = null,
    var local: String? = null,
    var avaliacao: Long? = null,
    var latitude: Long? = null,
    var longitude: Long? = null
    )