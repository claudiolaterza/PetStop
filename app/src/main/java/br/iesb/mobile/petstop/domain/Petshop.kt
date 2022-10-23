package br.iesb.mobile.petstop.domain

import com.google.firebase.database.DatabaseReference

class Petshop (
    val id: String? = null,
    val telefone: String? = null,
    val name: String? = null,
    val endereco: String? = null,
    val lat: String? = null,
    val long: String? = null,
    val cnpj: String? = null,
    val email: String? = null,
    val venda_produtos : String? = null,
    val banho : String? = null,
    val exame : String? = null,
    val tosa : String? = null,
    val serv_veteterinaio : String? = null,
    val internacao : String? = null,
    val atendimento_24h : String? = null
)
