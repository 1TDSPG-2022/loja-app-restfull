package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.ProdutoBO;
import br.com.fiap.to.ProdutoTO;

@Path("/produto")
public class ProdutoResource {

	ProdutoBO pbo = new ProdutoBO();
	
	
	//GET-ALL
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProdutoTO> buscar(){
		return pbo.listar();
	}

	//GET-ID
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProdutoTO buscar(@PathParam("id") int id){
		return pbo.listar(id);
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ProdutoTO produto,@Context UriInfo uriInfo) {
		//ADICIONAR O OBJETO AO MÉTODO DE CADASTRO
		pbo.cadastrar(produto);
		
		//CONSTRUIR A URI QUE SERÁ RETORNADA NO CONTEXTO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		
		//SEPARANDO E CONVERTENDO O CÓDIGO DO PRODUTO
		builder.path( Integer.toString(produto.getCodigo()));
		
		//CONSTRUINDO O STATUS DE RETORNO
		return Response.created(builder.build()).build();
		
	}
	
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(ProdutoTO produto, @PathParam("id") int id) {
		//SETANDO O ID DO PRODUTO
		produto.setCodigo(id);
		//EXECUTANDO A ATUALIZACAO
		pbo.atualiza(produto);
		
		//RETORNANDO O STATUS
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		pbo.remover(id);
	}
	
}
