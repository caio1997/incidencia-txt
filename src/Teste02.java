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
		
		//Contado que ser� utilizado no Hash
		Integer cont = 1;
		//Decla��o do Hash com o Key sendo a Sting passada e o Integer sendo o contado que ir� definir quantas vezes ela apareceu
		Map<String, Integer> map = new HashMap<String, Integer>();
		//Lista utilizada para inserir a linha do arquivo .txt
		List<String> list = new ArrayList<String>();

		//Salvar o arquivo na vari�vel file
		File file = new File("teste.txt");
		//Classe do Java para implementar a abertura do arquivo
		BufferedReader in = new BufferedReader(new FileReader(file));
		//Vari�vel criada para receber as linhas do arquivo .txt
		String ler = "";

		//Leitura do arquivo
		while (in.ready()) {
			//Salvando na vari�vel ler a linha do txt com tratamento de espa�o e UpperCase (letras mai�sculas)
			ler = in.readLine().trim().toUpperCase();
			//Biblioteca para remover os "|" e salvar as strings
			StringTokenizer str = new StringTokenizer(ler, "|");
			//La�o que ir� percorrer todas as posi��es do "string" e adicionar cada uma em uma posi��o da lista tempor�ria
			for (int x = 0; x <= 49; x++) {
				list.add((String) str.nextElement());

			}
			//La�o que ir� percorrer a lista da primeira a 50 posi��o
			for (int x = 0; x <= 49; x++) {
				//Salvar a string na variavel test
				String test = list.get(x);
				//Percorre o HashMap e salva na var�avel key caso aquele valor j� exista
				String key = map.entrySet().stream().filter(e -> e.getKey().equals(test)).findFirst()
						.map(Map.Entry::getKey).orElse(null);
				//Verifica se a vari�vel key � nula ou n�o, caso seja ir� inserir um item no Hash, com a key sendo a string e o value um contador que inicia com 1
				//Caso j� exista aquela key no Hask, ele ir� somar 1 ao contador, significando que houve mais uma ocorr�ncia daquela string
				if (key != null) {
					map.put(test, map.get(test) + 1);
				} else {
					map.put(test, cont);
				}

			}
			//Zerando o ArrayList para ser utilizado nas pr�xima linha do arquivo .txt
			list = new ArrayList<String>();
		}
		
		//La�o utilizado para mostrar os itens do Hash
		//Foi usado para teste
		//for(Entry<String, Integer> conteudo : map.entrySet()) {
		//	 System.out.println(conteudo.getKey() + " ------ "+ conteudo.getValue());
		//}
		
		//Ordena��o dos itens do Hash pelo Valeu, isto �, ordena��o em ordem descrescente pelo comparingByValue (compara��o pelo contador, que � o value)
		map.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) 
        .forEach(System.out::println); // or any other terminal method
	}
}


