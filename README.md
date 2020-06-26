# incidencia-txt
Verificar a incidência de Strings em arquivo .txt

Descrição do problema: Dado um arquivo texto muito grande, que não caiba na memória – exemplo: 10GB , encontre as 50 mil frases mais frequentes. O formato do arquivo são linhas com até 50 frases divididas por pipe ( “|” ).
O código irá ler linha por linha do arquivo .txt e salvar um ArrayList temporário.
Após isso ele irá entrar em um laço para percorrer todas as posições desse ArraList e comparar se já existe no Hash.
Caso não exista ele irá adicionar a String (key) e um value(contador = 1), mostrando que aquela palavra tem uma ocorrência.
Caso já exista, ele irá apenas somar +1 no value, mostrando que houve mais uma ocorrência daquela palavra.
No final desse laço ele irá zerar o ArrayList e voltará ao laço principal, que irá ler a segunda linha do .txt realizando os mesmo passos sitados a cima.
Dessa forma serão salvos no Hash apenas 1 ocorrência de cada String, o que dirá sua quantidade será o contador.
Ao final é criado uma novo Hash porém dessa vez ordenado pelo value(contado)
Para finalizar foi criado um for que percorre todo o HashMap e mostra as primeiras 50 mil ocorrências, uma vez que o HashMap está ordenado pelo value(contador - valor de ocorrências da String)

Att Caio Marinho
