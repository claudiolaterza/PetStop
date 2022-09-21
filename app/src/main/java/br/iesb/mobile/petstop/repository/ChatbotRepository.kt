package br.iesb.mobile.petstop.repository

import android.content.Context
import br.iesb.mobile.petstop.repository.apiretrofit.RetrofitInit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import br.iesb.mobile.petstop.dataclass.DialogflowRequest
import br.iesb.mobile.petstop.repository.apiretrofit.dto.ChatbotDTO


interface ChatBotService{
    @POST("api/message/text/send")
    @Headers("Content-Type: application/json")
    fun sendText(
        @Body send : DialogflowRequest
    )
    :Call<List<ChatbotDTO?>>

}

class ChatbotRepository(context: Context, url: String) : RetrofitInit(context, url) {
    private val service = retrofit.create(ChatBotService::class.java)

    fun sendText(request: DialogflowRequest, callback: (String) -> Unit) {
        service.sendText(request).enqueue(object : Callback<List<ChatbotDTO?>> {
            override fun onFailure(call: Call<List<ChatbotDTO?>>, t: Throwable) {
                callback("ERROR")
            }

            override fun onResponse(
                call: Call<List<ChatbotDTO?>>,
                response: Response<List<ChatbotDTO?>>
            ) {
                val list = response.body()

                list?.forEach { dto ->
                    if (dto != null) {
                        dto.queryResult?.fulfillmentText?.let { callback(it) }
                    }
                }
            }

        })
    }
}