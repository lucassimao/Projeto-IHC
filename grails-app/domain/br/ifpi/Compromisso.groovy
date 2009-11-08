package br.ifpi

class Compromisso {

	String descricao
	Date data
	String local
	String horario
	
    static constraints = {
		descricao(nullable:false,blank:false)
		data(nullable:false,blank:false)
		local(nullable:false,blank:false)
		horario(nullable:false,blank:false)
	}
	static mapping ={
		tablePerHierarchy false
	}
}
