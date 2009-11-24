import org.zkoss.zkgrails.*
import br.ifpi.*
import org.zkoss.zhtml.Messagebox

class CadastroComposer extends GrailsComposer {
    
    def textboxNome    
	def dateboxNascimento
	def radiogroupSexo
	def textboxEmail
	def textboxSenha
	def textboxUsuario
	def btnCriarAgenda
	
    def cadastroFacade
    
	def onClick_btnCriarAgenda(){
		def c = new Contato(nome:textboxNome.value,dataNascimento:dateboxNascimento.value,
							email:textboxEmail.value,login:textboxUsuario.value,senha:textboxSenha.value)
		if (radiogroupSexo.selectedIndex==0)
			c.sexo = Sexo.Masculino
		else
			c.sexo = Sexo.Feminino
		
		if (c.validate()){
			c.save()
			Messagebox.show('Cadastro realizado com sucesso! Voce sera levado para a pagina de login!',
							'Cadastro realizado',Messagebox.OK,Messagebox.INFORMATION)
		}	
	}
    def afterCompose = { c ->

    }
}
