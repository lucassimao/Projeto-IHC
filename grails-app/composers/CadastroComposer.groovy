import org.zkoss.zkgrails.*
import br.ifpi.*
import org.zkoss.zhtml.Messagebox
import org.zkoss.zk.ui.Executions

class CadastroComposer extends GrailsComposer {
    
    def textboxNome    
	def textboxEndereco
	def textboxEmail
	def textboxTelefone
	def textboxCelular
	def textboxUsuario
	def textboxSenha
	def btnCriarAgenda
	def btnVoltar
	
    def cadastroFacade
    
	def onClick_btnCriarAgenda(){
		def c = new Contato(nome:textboxNome.value,endereco:textboxEndereco.value,telefone:textboxTelefone.value,celular:textboxCelular.value,
							email:textboxEmail.value,login:textboxUsuario.value,senha:textboxSenha.value)
		
		if (c.validate()){
			c.save()
			Messagebox.show('Cadastro realizado com sucesso! Voce sera levado para a pagina de login!',
							'Cadastro realizado',Messagebox.OK,Messagebox.INFORMATION)
			Executions.current.sendRedirect('/login.zul')
		}	
	}
    def afterCompose = { c ->

    }
}
