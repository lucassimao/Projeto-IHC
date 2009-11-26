package br.ifpi

class Contato {
	String nome
	String email
	String login
	String senha
	String telefone
	String celular
	String endereco
	Set<Contato> contatos
	
	static hasMany= [contatos:Contato]
	
	static mapping = {
		contatos lazy: false
	}
	
    static constraints = {
		nome(nullable:false,blank:false)
		// Se for um contato cadastrado no sistema, ele terá senha
		login(nullable:true,blank:true)
		senha(nullable:true,blank:true)
		endereco(nullable:true,blank:true)
		telefone(nullable:true,blank:true)
		celular(nullable:true,blank:true)
		email(nullable:true,blank:true,email:true)
	}
}
