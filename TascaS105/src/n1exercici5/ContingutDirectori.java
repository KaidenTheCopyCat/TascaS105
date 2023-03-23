package n1exercici5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ContingutDirectori implements Serializable {

	private static final long serialVersionUID = 1L;
	private static List<String> fileList = new ArrayList<>();

	public static void llistaAlphaRecursiuATxtFile(String directoriPath) throws IOException {
		File directori = new File(directoriPath);

		File[] files = directori.listFiles();

		Arrays.sort(files);

		BufferedWriter bwriter = new BufferedWriter(new FileWriter("output.txt"));

		for (File file : files) {
			long ultimaModificaio = file.lastModified();
			Date data = new Date(ultimaModificaio);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dataFormatejada = format.format(data);

			if (file.isDirectory()) {
				bwriter.write("D: " + file.getName() + dataFormatejada + " Dintre del directori: ");
				llistaAlphaRecursiuATxtFile(file.getPath());
			} else {
				bwriter.write("F: " + file.getName() + dataFormatejada);
			}
		}

		bwriter.close();
	}

	public static void mostraFitxer(String fitxerPath) throws IOException {
		File file = new File(fitxerPath);

		BufferedReader reader = new BufferedReader(new FileReader(file));

		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

		reader.close();
	}

	public static void llistaAlphaRecursiuASerFile(String folderPath) throws IOException {
		File folder = new File(folderPath);

		File[] files = folder.listFiles();

		Arrays.sort(files);

		FileOutputStream fileOut = new FileOutputStream("contingutDirectori.ser");

		ObjectOutputStream out = new ObjectOutputStream(fileOut);

		for (File file : files) {
			if (file.isDirectory()) {
				llistaAlphaRecursiuASerFile(file.getPath());
			} else {
				
				out.writeObject(file);
			}
		}
		out.close();
		fileOut.close();
	}

	public static void deserialitzar(String filePath) throws IOException, ClassNotFoundException {
		
		FileInputStream fileIn = new FileInputStream(filePath);

		ObjectInputStream in = new ObjectInputStream(fileIn);

		File[] files = (File[]) in.readObject();

		in.close();
		fileIn.close();

		for (File file : files) {
			System.out.println(file.getName());
		}
	}
	
	

	// Ara el programa ha de serialitzar un Objecte Java a un fitxer .ser i després
	// l’ha de desserialitzar

	// Afegeix la funcionalitat de llegir qualsevol fitxer TXT i mostra el seu
	// contingut per consola.

	// Modifica l’exercici anterior.
	// Ara, en lloc de mostrar el resultat per la pantalla, guarda el resultat en un
	// fitxer TXT.

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
