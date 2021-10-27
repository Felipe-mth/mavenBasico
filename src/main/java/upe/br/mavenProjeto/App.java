package upe.br.mavenProjeto;

import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Elements[] resultadoLoteria = ResultadoMegasena.obtemUltimoResultado();
    	System.out.println("Resultado Megasena: " + resultadoLoteria[0].text());
    	System.out.println("Resultado Lotofácil: " + resultadoLoteria[1].text());
    	System.out.println("Resultado Megasena: " + resultadoLoteria[2].text());
    }
}
