package n1exercici2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ContingutDirectori {

	public static void llistaAlphaRecursiu(String directoriPath) {
		File directori = new File(directoriPath);

		File[] files = directori.listFiles();

		Arrays.sort(files);

		for (File file : files) {
			long ultimaModificaio = file.lastModified();
			Date data = new Date(ultimaModificaio);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dataFormatejada = format.format(data);

			if (file.isDirectory()) {
				System.out.println("D: " + file.getName() + dataFormatejada + " Dintre del directori: ");
				llistaAlphaRecursiu(file.getPath());
			} else {

				System.out.println("F: " + file.getName() + dataFormatejada);
			}
		}
	}

	/*
	 * Afegeix a la classe de l’exercici anterior, la funcionalitat de llistar un
	 * arbre de directoris amb el contingut de tots els seus nivells (recursivament)
	 * de manera que s'imprimeixin en pantalla en ordre alfabètic dins de cada
	 * nivell, indicant a més si és un directori (D) o un fitxer (F), i la seva
	 * última data de modificació.
	 */
//Crea una classe que llisti alfabèticament el contingut d'un directori rebut per paràmetre. 
	// Crea un fitxer anomenat “readme.txt” per explicar el comando a executar a
	// cada exercici.
}
