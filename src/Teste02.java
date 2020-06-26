import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

//Desenvolvido por Caio Marinho Coelho
public class Teste02 {

	public static void main(String[] args) throws IOException {
		
		//Contado que será utilizado no Hash
		Integer cont = 1;
		//Declação do Hash com o Key sendo a Sting passada e o Integer sendo o contado que irá definir quantas vezes ela apareceu
		Map<String, Integer> map = new HashMap<String, Integer>();
		//Lista utilizada para inserir a linha do arquivo .txt
		List<String> list = new ArrayList<String>();

		//Salvar o arquivo na variável file
		File file = new File("teste.txt");
		//Classe do Java para implementar a abertura do arquivo
		BufferedReader in = new BufferedReader(new FileReader(file));
		//Variável criada para receber as linhas do arquivo .txt
		String ler = "";

		//Leitura do arquivo
		while (in.ready()) {
			//Salvando na variável ler a linha do txt com tratamento de espaço e UpperCase (letras maiúsculas)
			ler = in.readLine().trim().toUpperCase();
			//Biblioteca para remover os "|" e salvar as strings
			StringTokenizer str = new StringTokenizer(ler, "|");
			//Laço que irá percorrer todas as posições do "string" e adicionar cada uma em uma posição da lista temporária
			for (int x = 0; x <= 49; x++) {
				list.add((String) str.nextElement());

			}
			//Laço que irá percorrer a lista da primeira a 50 posição
			for (int x = 0; x <= 49; x++) {
				//Salvar a string na variavel test
				String test = list.get(x);
				//Percorre o HashMap e salva na varíavel key caso aquele valor já exista
				String key = map.entrySet().stream().filter(e -> e.getKey().equals(test)).findFirst()
						.map(Map.Entry::getKey).orElse(null);
				//Verifica se a variável key é nula ou não, caso seja irá inserir um item no Hash, com a key sendo a string e o value um contador que inicia com 1
				//Caso já exista aquela key no Hask, ele irá somar 1 ao contador, significando que houve mais uma ocorrência daquela string
				if (key != null) {
					map.put(test, map.get(test) + 1);
				} else {
					map.put(test, cont);
				}

			}
			//Zerando o ArrayList para ser utilizado nas próxima linha do arquivo .txt
			list = new ArrayList<String>();
		}
		
		//Laço utilizado para mostrar os itens do Hash
		//Foi usado para teste
		//for(Entry<String, Integer> conteudo : map.entrySet()) {
		//	 System.out.println(conteudo.getKey() + " ------ "+ conteudo.getValue());
		//}
		
		//Ordenação dos itens do Hash pelo Valeu, isto é, ordenação em ordem descrescente pelo comparingByValue (comparação pelo contador, que é o value)
		map.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) 
        .forEach(System.out::println); // or any other terminal method
	}
}


