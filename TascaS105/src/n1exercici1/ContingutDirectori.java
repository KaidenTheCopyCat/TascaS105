package n1exercici1;

import java.io.File;
import java.util.Arrays;

public class ContingutDirectori {

	public static void llistaAlpha(String directoriPath) {
		File directori = new File(directoriPath);

		File[] files = directori.listFiles();

		Arrays.sort(files);

		for (File file : files) {
			System.out.println(file.getName());
		}

	}

//Crea una classe que llisti alfabèticament el contingut d'un directori rebut per paràmetre. 
	// Crea un fitxer anomenat “readme.txt” per explicar el comando a executar a
	// cada exercici.
}
