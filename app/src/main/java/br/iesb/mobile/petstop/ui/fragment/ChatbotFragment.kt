package br.iesb.mobile.petstop.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.iesb.mobile.petstop.R
import br.iesb.mobile.petstop.ui.adapter.ChatbotAdapter
import br.iesb.mobile.petstop.viewmodel.ChatbotViewModel
import kotlin.random.Random
import java.util.*
import kotlinx.android.synthetic.main.fragment_chatbot.*

class ChatbotFragment : Fragment() {


    //by lazy inicia a variavel apenas quando ela for ser utilizada
    private val viewModel: ChatbotViewModel by lazy  {
        ViewModelProvider(this).get(ChatbotViewModel::class.java)
    }

    private lateinit var adapter: ChatbotAdapter
    private lateinit var input: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chatbot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        input = inputchatbot
        initRecyclerView()

        btenviarchatbot.setOnClickListener{
            sendText()
        }

    }

    private fun initRecyclerView() {
        adapter = ChatbotAdapter(activity?.applicationContext)
        listamsgchatbot.layoutManager = LinearLayoutManager(activity?.applicationContext)
        listamsgchatbot.adapter = adapter
    }

    private fun sendText() {
        val message = inputchatbot.text.toString()

        viewModel.verifyEmpty(message) { response ->
            if (response == "OK") {
                adapter.addMessage(message, "USER")
                input.text = ""

                val data = Date().toString().substring(0, 10).replace(" ", "")
                val random = Random.nextInt(10000000, 1000000000)
                val sessionId = data + random

                viewModel.sendText(
                    message,
                    "apppetstop@gmail.com",
                    sessionId
                ) { chatMessage ->
                    adapter.addMessage(chatMessage, "Chatbot")
                }
            }
        }
    }


}