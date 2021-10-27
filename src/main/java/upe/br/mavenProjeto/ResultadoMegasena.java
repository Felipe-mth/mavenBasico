package upe.br.mavenProjeto;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

	/**
	
	* Classe que obtém os números do último sorteio da mega-sena.
	
	*/
	
public class ResultadoMegasena {
	/** URL que possui as dezenas sorteadas. */
	private final static String URL = "http://loterias.caixa.gov.br/wps/portal/loterias";

	/**
	* Método que se conecta ao site da CEF para obter as dezenas
	do último sorteio.
	* @return array de Strings, onde cada elemento é uma dezena
	sorteada.
	*/

	public static Elements[] obtemUltimoResultado() {
		//Criação do cliente HTTP que fará a conexão com o site
		HttpClient httpclient = new DefaultHttpClient();
		try {
			// Definição da URL a ser utilizada
			HttpGet httpget = new HttpGet(URL);
			// Manipulador da resposta da conexão com a URL
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			// Resposta propriamente dita
			String html = httpclient.execute(httpget, responseHandler);
			//Retorno das dezenas, após tratamento
			return obterDezenas(html);
		} catch (Exception e) {
			// Caso haja erro, dispara exceção.
			throw new RuntimeException("Um erro inesperado ocorreu.", e);
		} finally {
			//Destruição do cliente para liberação dos recursos do sistema.
			httpclient.getConnectionManager().shutdown();
		}
	}

	/**
	* Tratamento da resposta HTML obtida pelo método obtemUltimoResultado().
	* @param html resposta HTML obtida
	* @return array de Strings, onde cada elemento é uma dezena
	sorteada.
	*/
	private static Elements[] obterDezenas(String html) {
		// Posição inicial de onde começam as dezenas
		Document doc = Jsoup.parse(html);
		
		Elements resultadoMegaSena = doc.getElementsByClass("resultado-loteria mega-sena");
		Elements resultadoLotoFacil = doc.getElementsByClass("simple-table lotofacil");
		Elements resultadoQuina = doc.getElementsByClass("resultado-loteria quina");
		
		Elements[] resultadoLoteria = {resultadoMegaSena, resultadoLotoFacil, resultadoQuina};
		
		return resultadoLoteria;
	}
}