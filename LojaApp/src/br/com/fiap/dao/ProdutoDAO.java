package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.ProdutoTO;

public class ProdutoDAO {
	
	private static List<ProdutoTO> listaProduto;

	public ProdutoDAO() {
		
		if(listaProduto == null) {
			listaProduto = new ArrayList<ProdutoTO>();
			
			ProdutoTO pto = new ProdutoTO();
			pto.setCodigo(1);
			pto.setTitulo("Gravador");
			pto.setQuantidade(20);
			pto.setPreco(145.89);
			listaProduto.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(2);
			pto.setTitulo("Mouse");
			pto.setQuantidade(100);
			pto.setPreco(99.98);
			listaProduto.add(pto);
			
			pto = new ProdutoTO();
			pto.setCodigo(3);
			pto.setTitulo("Teclado");
			pto.setQuantidade(67);
			pto.setPreco(110.45);
			listaProduto.add(pto);

			pto = new ProdutoTO();
			pto.setCodigo(4);
			pto.setTitulo("Alcool Gel");
			pto.setQuantidade(1000);
			pto.setPreco(23.77);
			listaProduto.add(pto);

			pto = new ProdutoTO();
			pto.setCodigo(5);
			pto.setTitulo("Pilhas AA");
			pto.setQuantidade(2000);
			pto.setPreco(2.98);
			listaProduto.add(pto);
			
		}
		
	}
	
	//LISTA TODOS OS PRODUTOS
	public List<ProdutoTO> select(){
		return listaProduto;
	}

	//LISTA UM PRODUTO
	public ProdutoTO select(int id){
		
		for (int i = 0; i < listaProduto.size(); i++) {
			if (listaProduto.get(i).getCodigo() == id ) {
				return listaProduto.get(i);
			}
		}
		
		return null;
	}

	//INSERE UM PRODUTO NA BASE
	public boolean insert(ProdutoTO pto) {
		//GERADOR DE CÓDIGO/PRIMARY KEY
		pto.setCodigo(listaProduto.size() + 1);
		
		//RETORNANDO A RESPOSTA QUE FOI INSERIDO O
		//CADASTRO COM SUCESSO
		return listaProduto.add(pto);		
	}
	
	public void update(ProdutoTO pto) {
		
		//CRIANDO O OBJETO LOCALMENTE PARA INSERIR O CÓDIGO
		// E REALIZAR A ATUALIZAÇÃO DOS DADOS
		ProdutoTO p = select(pto.getCodigo());
		p.setPreco(pto.getPreco());
		p.setQuantidade(pto.getQuantidade());
		p.setTitulo(pto.getTitulo());
				
	}
	
	public void delete(int id) {
		listaProduto.remove(select(id));
	}

	
}
