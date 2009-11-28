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



class ContatosRenderer implements ListitemRenderer{

    def handler

    public void render(Listitem item,java.lang.Object data) {
		
        if (data && data instanceof Contato){
            new Listcell(parent:item,label:data.nome)
            new Listcell(label:data.endereco,parent:item)
            new Listcell(label:data.email,parent:item)
			new Listcell(label:data.telefone,parent:item)
			new Listcell(label:data.celular,parent:item)
        }
    }
}

class GerenciarContatosComposer extends GrailsComposer {
    
    def listBoxContatos
	def textboxProcurar
	def groupboxExcluirContato
	
    def gerenciarContatosFacade
    
    def afterCompose = { c ->
        listBoxContatos.itemRenderer = new ContatosRenderer()
        listBoxContatos.model = new ListModelList(Sessions.current.getAttribute('usuario').contatos)        
    }
	
	def onChanging_textboxProcurar(org.zkoss.zk.ui.event.InputEvent event){
		atualizarListBoxComQueryLike(event.value)  
	}
	
	def onClick_groupboxExcluirContato(){
		if (listBoxContatos.selectedIndex == -1)
			Messagebox.show('Selecione um contato primeiro!','Atencao',Messagebox.OK,Messagebox.INFORMATION)
		else{
			Contato c = listBoxContatos.model.getElementAt(listBoxContatos.selectedIndex)
			int res = Messagebox.show("Deseja realmente excluir ${c.nome} de sua lista de contatos?",
						'Confirmacao',Messagebox.OK|Messagebox.NO,Messagebox.QUESTION)
			if (res == Messagebox.OK){
				c.delete()
				atualizarListBoxComQueryLike(textboxProcurar.value)  
				Messagebox.show('Contato excluido!','Informacao',Messagebox.OK,Messagebox.INFORMATION)
			}
		}
		
	}
	
	def onClick_groupboxEditarContato(){
		if (listBoxContatos.selectedIndex == -1)
			Messagebox.show('Selecione um contato primeiro!','Atencao',Messagebox.OK,Messagebox.INFORMATION)
		else{
			Sessions.current.setAttribute('contatoParaEditar', listBoxContatos.model.getElementAt(listBoxContatos.selectedIndex))
			Executions.current.sendRedirect('/editarContatos.zul')
		}
			
	}
	private void atualizarListBoxComQueryLike(String busca){
			Contato c = Sessions.current.getAttribute('usuario')
			//listBoxContatos.model = new ListModelList(Contato.findAll('from Contato c1,Contato c2 where c1=:contatoLogado and c2 in (c1.contatos) and lower(c2.nome) like lower(:valor)',
			//					[contatoLogado:c,valor:'%'+busca+'%']))  
			listBoxContatos.model = new ListModelList(c.contatos.collect{it -> return it.nome.toLowerCase().contains(busca.toLowerCase())})
	}
}
