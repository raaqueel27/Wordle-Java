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
		//Esta línea contiene la path en la que se está ejecutando java
		String currentDir=System.getProperty("user.dir");
		//Y esta el subdirectorio en el que se encuentra el fichero de datos
		String readingPath=currentDir+fileName;
		//El objeto "path" referencia a la path completa del fichero
		Path path = Paths.get(readingPath);
		
		//Este string contiene en cada momento la última linea leída 
		String oneLine;		
		try {
			//Este "buffer de entry" es la conexión entre el fichero en el sistema operativo y java
			//Precisamente a través de este buffer se realiza la lectura
			BufferedReader entry=Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));
			//El método readLine() devuelve una línea del fichero y avanza a la siguiente
			oneLine = entry.readLine();
			//Mientras se devuelve una línea, sigue pidiendo otra
			while(oneLine!=null) {
				//Y cada línea se añade al ArrayList (aunque podría realizarse cualquier acción)
				lines.add(oneLine);
				//Se lee otra lína
				oneLine=entry.readLine();
			}
			//Se cierra el buffer de entry.
			entry.close();
		} catch(FileNotFoundException e) { // Se ejecuta si el fichero no existe
			System.err.println("Fichero no encontrado");
		} catch(EOFException eofe) { // Se ejecuta si se intenta leer de un archivo cuyo final se ha alcanzado previamente
			System.out.println("Fichero finalizado");
		} catch(IOException ioe) { //Se ejecuta si ocurre algún otro error durante la lectura.
			System.out.println(ioe);
		}
		return lines;
	}
}