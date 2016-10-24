package com.wd;

import java.io.*;
import java.util.zip.*;

public class GZipper {

	public final static String GZIP_EXTENSION = ".gz";

	public static void main(String[] argv) throws IOException {
		String files[] = { "C:/Users/wylson/Desktop/test/domo.docx", "C:/Users/wylson/Desktop/test/jaxrs.pdf" };  
																													 
		for (int i = 0; i < files.length; i++) {
			gzipFile(files[i], "C:/Users/wylson/Desktop/test/zip", new File(files[i]).getName(), true);
		}

	}

	public static void gzipFile(String absolutePath, String destDirectory, String outputName, boolean deleteOrigine)
			throws IOException {
		InputStream fin = null;
		OutputStream fout = null;
		GZIPOutputStream gzout = null;
		try {
			fin = new FileInputStream(absolutePath);
			fout = new FileOutputStream(destDirectory + File.separator + outputName + GZIP_EXTENSION);
			gzout = new GZIPOutputStream(fout);
			for (int c = fin.read(); c != -1; c = fin.read()) {
				gzout.write(c);
			}
		} finally {
			if (gzout != null) {
				gzout.close();
			}
			if (fin != null) {
				fin.close();
			}
			if (fout != null) {
				fout.close();
			}
		}
		if (deleteOrigine) {
			File oriFile = new File(absolutePath);
			boolean done = oriFile.delete();
			if (done) {
				System.out.println("ok delete " + absolutePath);
			} else {
				System.out.println("ko delete " + absolutePath);
			}
		}
	}
}