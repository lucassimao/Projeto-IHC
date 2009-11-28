import org.zkoss.zkgrails.*

class EditarContatoComposer extends GrailsComposer {
    
    def textNome
	def textEndereco
	def textEmail
	def textTelefone
	def textCelular
	def btnSalvar
    
    def editarContatoFacade
    
 
    def afterCompose = { c ->
        // initialize component here
    }
}
