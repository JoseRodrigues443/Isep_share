/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.ImportExportLink;

import csheets.core.Spreadsheet;
import java.io.File;

/**
 * class used to define the file that will be linked
 * @author Ana Pacheco (1130679)
 */
public class FileLink {
    
    private Spreadsheet sheet;
	private File fileName;
	private boolean headerOption;
	private String separator;
	private String header;

	public FileLink() {

	}

	public FileLink(Spreadsheet sheet, File fileName, boolean headerOption,
					String separator, String header) {
		this.sheet = sheet;
		this.fileName = fileName;
		this.headerOption = headerOption;
		this.header = header;
		this.separator = separator;
	}

	public FileLink(Spreadsheet sheet, File fileName) {
		this.sheet = sheet;
		this.fileName = fileName;
	}

	public Spreadsheet getSheet() {
		return sheet;
	}

	public File getFile() {
		return fileName;
	}

	public boolean getHeaderOption() {
		return headerOption;
	}

	public String getHeader() {
		return header;
	}

	public String getSeparator() {
		return separator;
	}
    
}
