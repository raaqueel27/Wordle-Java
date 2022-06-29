package io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Writer {

    private String fileName;
	
	public Writer(String fileName) {
		this.fileName=fileName;
	}
	
	public void resetFile() {
		String currentDir=System.getProperty("user.dir");
		String writingPath=currentDir+fileName;
		Path path = Paths.get(writingPath);
		path.toFile().delete();
		try {
			path.toFile().createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeLine(String line) {
		//Esta línea contiene la path en la que se está ejecutando java
		String currentDir=System.getProperty("user.dir");
		//Y esta el subdirectorio en el que se encuentra el fichero de datos
		String writingPath=currentDir+fileName;
		//El objeto "path" referencia a la path completa del fichero
		Path path = Paths.get(writingPath);
		try {
			BufferedWriter bw=Files.newBufferedWriter(path,
					Charset.forName("ISO-8859-1"),
					StandardOpenOption.APPEND, StandardOpenOption.WRITE);
			bw.write(line);
			bw.newLine();
			bw.close();
		} catch(Exception e) {
			System.err.println(e);
		}
	}
    
}