package br.ifpi

class Contato {
	String nome
	String endereco
	String email
	String telefone
	String celular
	
    static constraints = {
		nome(nullable:false,blank:false)
		endereco(nullable:true,blank:true)
		email(nullable:true,blank:true,email:true)
		telefone(nullable:true,blank:true)
		celular(nullable:true,blank:true)
	}
}
