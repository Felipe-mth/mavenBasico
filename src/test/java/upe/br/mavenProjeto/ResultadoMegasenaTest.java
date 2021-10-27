package upe.br.mavenProjeto;

import org.junit.Test;
import org.jsoup.select.Elements;

import junit.framework.TestCase;

public class ResultadoMegasenaTest extends TestCase {
	/** Número de dezenas esperadas no resultado da mega-sena. */
	private final static int DEZENAS_MEGASENA = 17;
        private final static int DEZENAS_LOTO = 44;
        private final static int DEZENAS_QUINA = 14;
	/**
	* Teste do método obtemUltimoResultado()
	*/
	@Test
	public void testObtemUltimoResultado() {
		Elements[] ultimoResultado = ResultadoMegasena.obtemUltimoResultado();
		assertNotNull(ultimoResultado);
                
            for (Elements ultimoResultado1 : ultimoResultado) {
                assertTrue(ultimoResultado1.text().length() == DEZENAS_MEGASENA 
                       || ultimoResultado1.text().length() == DEZENAS_LOTO 
                       || ultimoResultado1.text().length() == DEZENAS_QUINA);
            }
	}
}
