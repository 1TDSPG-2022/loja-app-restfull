package br.com.fiap.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dados")
public class PessoaResoure {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String[][] listaDados(){
		
		String[][] info = new String[3][3];
		//CABEÇALHO
		info[0][0] = "NOME";
		info[0][1] = "CPF";
		info[0][2] = "EMAIL";
		
		//1-LINHA
		info[1][0] = "Alê";
		info[1][1] = "12345678911";
		info[1][2] = "profalexandre.jesus@fiap.com.br";
		
		//1-LINHA
		info[2][0] = "Aríete";
		info[2][1] = "00000000000";
		info[2][2] = "ariete-pocket@server.com.br";
		
		return info;
		
	}
}
