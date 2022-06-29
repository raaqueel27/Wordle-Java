package io;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Reader {
    private String fileName;
	
	public Reader(String fileName) {
		this.fileName=fileName;
	}
	
	/**
	 * Lee el contenido de alumnado.dat y lo vuelva
	 * a una estructura ArrayList<String>
	 * @return
	 */
	public ArrayList<String> readLines(){
		ArrayList<String> lines=new ArrayList<String>();
		//Esta l�nea contiene la path en la que se est� ejecutando java
		String currentDir=System.getProperty("user.dir");
		//Y esta el subdirectorio en el que se encuentra el fichero de datos
		String readingPath=currentDir+fileName;
		//El objeto "path" referencia a la path completa del fichero
		Path path = Paths.get(readingPath);
		
		//Este string contiene en cada momento la �ltima linea le�da 
		String oneLine;		
		try {
			//Este "buffer de entry" es la conexi�n entre el fichero en el sistema operativo y java
			//Precisamente a trav�s de este buffer se realiza la lectura
			BufferedReader entry=Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));
			//El m�todo readLine() devuelve una l�nea del fichero y avanza a la siguiente
			oneLine = entry.readLine();
			//Mientras se devuelve una l�nea, sigue pidiendo otra
			while(oneLine!=null) {
				//Y cada l�nea se a�ade al ArrayList (aunque podr�a realizarse cualquier acci�n)
				lines.add(oneLine);
				//Se lee otra l�na
				oneLine=entry.readLine();
			}
			//Se cierra el buffer de entry.
			entry.close();
		} catch(FileNotFoundException e) { // Se ejecuta si el fichero no existe
			System.err.println("Fichero no encontrado");
		} catch(EOFException eofe) { // Se ejecuta si se intenta leer de un archivo cuyo final se ha alcanzado previamente
			System.out.println("Fichero finalizado");
		} catch(IOException ioe) { //Se ejecuta si ocurre alg�n otro error durante la lectura.
			System.out.println(ioe);
		}
		return lines;
	}
}