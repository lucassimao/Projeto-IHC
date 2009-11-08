package br.ifpi

class Reuniao extends Compromisso {

	Set<Contato> membros
	
    static hasMany={membros:Contato}
}
