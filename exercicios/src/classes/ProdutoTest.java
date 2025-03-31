package classes;

public class ProdutoTest {
	
	public static void main(String[] args) {
		// new instância e produto e o Construtor
		Produto p1 = new Produto();
		p1.nome = "Notebool";
		p1.preco = 4256.89;
		p1.desconto = 0.25;
		
		var p2 = new Produto();
		p2.nome = "Caneta Preta";
		p2.preco = 12.56;
		p2.desconto = 0.29;
		
		System.out.println(p1.nome);
		System.out.println(p2.nome);
		                    
		                       //metodo   e parametro 
		double precoFinal1 = p1.precoComDesconto();
		double precoFinal2 = p2.precoComDesconto();
		double mediaCarrinho = (precoFinal1 + precoFinal2) / 2;
		
		System.out.printf("Média do carrinho = R$%.2f.", mediaCarrinho);

	}

}
