package br.com.fiap.bo;

import java.util.List;

import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.to.ProdutoTO;

public class ProdutoBO {
	
	private ProdutoDAO pdo;
	
	public List<ProdutoTO> listar(){
		pdo = new ProdutoDAO();
		return pdo.select();
	}

	public ProdutoTO listar(int id){
		pdo = new ProdutoDAO();
		//REGRAS DE NEG�CIO
		return pdo.select(id);
	}
	
	public boolean cadastrar(ProdutoTO pto) {
		pdo = new ProdutoDAO();
		//REGRAS DE NEG�CIO
		return pdo.insert(pto);
	}
	
	public void atualiza(ProdutoTO pto) {
		pdo = new ProdutoDAO();
		//REGRAS DE NEG�CIO
		pdo.update(pto);
	}

	public void remover(int id) {
		pdo = new ProdutoDAO();
		//REGRAS DE NEG�CIO
		pdo.delete(id);
	}
	
}
