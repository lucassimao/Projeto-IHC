import br.ifpi.*

class BootStrap {

     def init = { servletContext ->
		new Contato(login:'root',senha:'root',nome:'Lucas Simao',email:'aa@a.com',dataNascimento:new Date()).save()
		new Contato(login:'lala',senha:'lalaroot',nome:'João',email:'aaaaa@sss222a.wcom',dataNascimento:new Date()).save()
		new Contato(login:'lala2',senha:'2lalaroot',nome:'Maria',email:'aaaaa@sss222a.wcom',dataNascimento:new Date()).save()
     }
     def destroy = {
     }
} 