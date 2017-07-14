/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.ImportExportLink;

import csheets.core.Spreadsheet;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * thread that will allow the link between the file and the program
 * @author Ana Pacheco (1130679)
 */
public class ImportThread implements Runnable {

	private final FileLink fileLink;
	private ImportTxtLink importLink;
	private Path path;
	private String fileName;
	private final Spreadsheet sheet;

	/**
	 * Sets the FileLink to this Thread
	 *
	 * @param fileLink
	 */
	public ImportThread(FileLink fileLink) {
		this.fileLink = fileLink;
		this.sheet = fileLink.getSheet();
	}

	/**
	 * run method of the thread
	 *
	 */
	@Override
	public void run() {
		importLink = new ImportTxtLink(sheet);
		String absolutePath = fileLink.getFile().getAbsolutePath();
		String sPath = absolutePath.
			substring(0, absolutePath.lastIndexOf(File.separator));
		path = Paths.get(sPath);
		fileName = absolutePath.
			substring((absolutePath.lastIndexOf(File.separator) + 1));
		watchDirectory();

	}

	/**
	 * Method that keeps track of the changes in the directory
	 */
	@SuppressWarnings("unchecked")
	public void watchDirectory() {
		try {
			FileSystem fileSystem = path.getFileSystem();

			WatchService service = fileSystem.newWatchService();
			importLink.fileImport(fileLink);
			path.register(service, ENTRY_MODIFY);
			WatchKey watchKey = null;
			for (;;) {
				sleep(100);
				watchKey = service.take();
				WatchEvent.Kind<?> kind = null;
				for (WatchEvent<?> watchEvent : watchKey.pollEvents()) {
					kind = watchEvent.kind();
					Path fileName = ((WatchEvent<Path>) watchEvent).context();
					if (OVERFLOW == kind) {
						continue;
					} else if (ENTRY_MODIFY == kind && fileName.toString().
						equals(this.fileName)) {
						importLink.fileImport(fileLink);
					}
				}

				if (!watchKey.reset()) {
					break;
				}
			}
		} catch (IOException ex) {
		} catch (InterruptedException ex) {
		}
	}
}
