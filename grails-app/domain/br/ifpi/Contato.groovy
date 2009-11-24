package br.ifpi

public enum Sexo{
	Masculino,Feminino
}
class Contato {
	String nome
	String email
	String login
	String senha
	Date dataNascimento
	Sexo sexo = Sexo.Masculino
	
    static constraints = {
		nome(nullable:false,blank:false)
		login(nullable:false,blank:false)
		senha(nullable:false,blank:false)
		dataNascimento(nullable:false,blank:false)
		email(nullable:true,blank:true,email:true)
	}
}
