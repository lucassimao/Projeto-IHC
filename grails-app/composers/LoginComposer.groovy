import org.zkoss.zkgrails.*
import br.ifpi.*
import org.zkoss.zhtml.Messagebox
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.Sessions
import org.zkoss.zk.ui.Session

class LoginComposer extends GrailsComposer {
    
    def groupboxCriarAgendaVirtual    
    def loginFacade
	def textSenha
	def textUsuario
	def btnEntrar
	def btnLimpar
    
    def onClick_btnEntrar() {
		def c = Contato.findByLoginAndSenha(textUsuario.value,textSenha.value)
		if (c){
			Sessions.current.removeAttribute('loginIncorreto')
			Sessions.current.setAttribute('usuario',c)
			Executions.current.sendRedirect('/main.zul')
		}
		else{
			Sessions.current.setAttribute('loginIncorreto',true)
			Executions.current.sendRedirect('/login.zul')
		}
    }
	
	def onClick_btnLimpar(){
		textUsuario.value = ''
		textSenha.value=''
		
	}
	
    def afterCompose = { c ->
        
    }
}
