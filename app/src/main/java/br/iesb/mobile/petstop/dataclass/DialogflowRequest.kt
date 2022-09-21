package br.iesb.mobile.petstop.dataclass

data class DialogflowRequest(
    val text: String,
    val email: String,
    val sessionId: String
)