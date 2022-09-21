package br.iesb.mobile.petstop.domain

class Petshop (
    val telefone: Long?,
    val name: String?,
    val endereco: String?,
    val lat: Long?,
    val long: Long?,
    val cnpj: Long?,
    val id: Long?,
    val email: String? ){
    constructor() : this(null,null,null, null,null, null, null, null){
    }
}