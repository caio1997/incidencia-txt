import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

//Desenvolvido por Caio Marinho Coelho
public class Teste02 {

	public static void main(String[] args) throws IOException {

		// Contado que será utilizado no Hash
		Integer cont = 1;

		// Declação do Hash com o Key sendo a Sting passada e o Integer sendo o contado
		// que irá definir quantas vezes ela apareceu
		Map<String, Integer> map = new HashMap<String, Integer>();

		// Lista utilizada para inserir a linha do arquivo .txt
		List<String> list = new ArrayList<String>();

		// Salvar o arquivo na variável file
		File file = new File("teste.txt");

		// Classe do Java para implementar a abertura do arquivo
		BufferedReader in = new BufferedReader(new FileReader(file));

		// Variável criada para receber as linhas do arquivo .txt
		String ler = "";

		// Leitura do arquivo
		while (in.ready()) {

			// Salvando na variável ler a linha do txt com tratamento de espaço e UpperCase
			// (letras maiúsculas)
			ler = in.readLine().trim().toUpperCase();

			// Biblioteca para remover os "|" e salvar as strings
			StringTokenizer str = new StringTokenizer(ler, "|");

			// Laço que irá percorrer todas as posições do "string" e adicionar cada uma em
			// uma posição da lista temporária
			for (int x = 0; x <= 49; x++) {
				list.add((String) str.nextElement());

			}
			// Laço que irá percorrer a lista da primeira a 50 posição
			for (int x = 0; x <= 49; x++) {

				// Salvar a string na variavel test
				String test = list.get(x);

				// Percorre o HashMap e salva na varíavel key caso aquele valor já exista
				String key = map.entrySet().stream().filter(e -> e.getKey().equals(test)).findFirst()
						.map(Map.Entry::getKey).orElse(null);

				// Verifica se a variável key é nula ou não, caso seja irá inserir um item no
				// Hash, com a key sendo a string e o value um contador que inicia com 1
				// Caso já exista aquela key no Hask, ele irá somar 1 ao contador, significando
				// que houve mais uma ocorrência daquela string
				if (key != null) {
					map.put(test, map.get(test) + 1);
				} else {
					map.put(test, cont);
				}

			}

			// Zerando o ArrayList para ser utilizado nas próxima linha do arquivo .txt
			list = new ArrayList<String>();
		}

		// Ordenação dos itens do Hash pelo Value, isto é, ordenação em ordem
		// descrescente pelo comparingByValue (comparação pelo contador, que é o value)
		// - > e salvar no Hash order
		Map<String, Integer> order = map.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		
		// Nessa laço ele irá percorrer o Hash order e mostrando apenas apenas os 50
		// primeiros mil itens do Hash, uma vez que ele foi ordenado em ordem
		// descrescente pelo (value) e salvo em um novo hash (order) no método acima
		int var = 0;
		for (Entry<String, Integer> conteudo : order.entrySet()) {
			
			//Irá printar apenas a key do hask, que no caso é a String
			//A string foi colocado como key uma vez que a key não pode se repetir, e é o que queriamos com a string
			//Já o value, foi um integer contador, utilizado para definir quantas vezes aquela string
			//se repetiu ou esteve presente dentro do arquivo .txt
			System.out.println(conteudo.getKey());

			// Essa linha a baixo irá printar na tela o key (string) do hash e seu
			// value(número de ocorrencia) - Utilizado para teste da implementação
			// System.out.println(conteudo.getKey() + " ------ "+ conteudo.getValue());;
			
			//Variável utilizada como contador para saber quantos itens já foram mostrados
			var++;
			
			// Irá mostrar os itens do hash até que o var seja menor ou igual a 50 mil,
			// isto é, irá mostrar os 50 mil resultados mais frequentes na tela
			// Caso queira mostrar apenas as 10 primeiras por exemplo, mudar esse
			// (var>=50000) para (var=>10)
			if (var >= 50000) {
				break;
			}
		}
	}
}
