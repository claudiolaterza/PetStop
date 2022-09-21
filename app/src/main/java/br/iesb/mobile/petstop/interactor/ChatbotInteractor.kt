package br.iesb.mobile.petstop.interactor

import android.content.Context
import br.iesb.mobile.petstop.repository.ChatbotRepository
import br.iesb.mobile.petstop.dataclass.DialogflowRequest

class ChatbotInteractor(context: Context) {
    private val repository = ChatbotRepository(context, "https://dialogflow-petstop.herokuapp.com/")

    fun sendText(request: DialogflowRequest, callback: (String) -> Unit) {
        repository.sendText(request, callback)
    }

    fun verifyEmpty(text: String, callback: (String) -> Unit) {
        if (text.isEmpty()) {
            callback("EMPTY")
        } else {
            callback("OK")
        }
    }
}