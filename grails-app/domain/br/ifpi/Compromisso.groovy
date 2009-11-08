package br.ifpi

class Compromisso {

	Strign descricao
	Date data
	String local
	String horario
	
    static constraints = {
		descricao(nullable:false,blank:false)
		data(nullable:false,blank:false)
		local(nullable:false,blank:false)
		horario(nullable:false,blank:false)
	}
}
