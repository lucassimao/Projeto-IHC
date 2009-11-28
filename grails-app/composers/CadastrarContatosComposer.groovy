import org.zkoss.zkgrails.*
import org.zkoss.zul.ListitemRenderer
import org.zkoss.zul.Listitem
import org.zkoss.zhtml.Messagebox
import br.ifpi.*
import org.zkoss.zul.ListModelList
import org.zkoss.zk.ui.Sessions
import org.zkoss.zk.ui.Executions
import org.zkoss.zk.ui.Session
import org.zkoss.zul.Listcell

class CadastrarContatosComposer extends GrailsComposer {
    
    def textBoxNome
    def textBoxEndereco
    def textBoxEmail
	def btnSalvarECadastrarOutro
	def btnSalvar
	def textBoxCelular
	def textBoxTelefone
	def groupboxLimparFormulario
	def btnProcurarContato
	def winCadastrarContato
    
    def cadastrarContatosFacade
    
    
    def afterCompose = { c ->
        println applicationScope
    }
	
	def onClick_btnSalvar(){
		salvar()
		Executions.current.sendRedirect('/meusContatos.zul')
	}
	
	def onClick_btnSalvarECadastrarOutro(){
		salvar()
		
		Executions.current.sendRedirect('/cadastrarContatos.zul')
	}	
	
	def onClick_groupboxLimparFormulario(){
		textBoxNome.constraint=null
		textBoxNome.value=''
		textBoxNome.constraint=new org.zkoss.zul.SimpleConstraint('no empty')
		textBoxEndereco.value=''
		textBoxEmail.value=''
		textBoxCelular.value=''
		textBoxTelefone.value=''
	}
	
	def onClick_btnProcurarContato(){
		def parametros = ['contatoASerAdicionado':null]
		def comp =  execution.createComponents('procurarContato.zul',winCadastrarContato,parametros)
		comp.doModal()
		if (parametros.contato)
			println parametros.contato
	}
	private void salvar(){
		def c = new Contato(nome:textBoxNome.value,endereco:textBoxEndereco.value,telefone:textBoxTelefone.value,celular:textBoxCelular.value,
							email:textBoxEmail.value)
		c.save()
		Contato user = Sessions.current.getAttribute('usuario')
		user.contatos << c
		user.save()
		Messagebox.show('Contato adicionado com sucesso!','Informacao',Messagebox.OK,Messagebox.INFORMATION)
	}
}
