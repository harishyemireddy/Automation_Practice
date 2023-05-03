package commonUtilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs {
	String Path ="";
	File file;
	//This method is used to create file
	public String createNewFile(String fileName) throws IOException {
		File file = new File("./Logs/"+createFolder()+"/"+fileName);
		if(file.createNewFile()) {
			System.out.println("File Created");
			System.out.println("Path of the File =" + file.getAbsolutePath());
		}
		else {
			System.out.println("File already exists");
		}
		return file.getAbsolutePath();
	}

	//This method is used to return the get the file name for the log file
	public String getFileName() {
		return "Log-"+getDate()+".txt";
	}
	//This method is used to return the date for the log file
	public String getDate() {
		Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy");
        return dateFormat.format(date);
	}
	public String timeStamp() {
		Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy h-m-s");
        return dateFormat.format(date);
	}
	//This method is used to write into file
	public void writeToFile(String filePath, String fileInfo) throws IOException {
		File file = new File(filePath);
        FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        bw.write(timeStamp()+"-"+fileInfo);
        pw.println();
        bw.close();
	}

	//This method is used to log the message
	public void Log(String logMessage) throws IOException {
		Path = createNewFile(getFileName());
		writeToFile(Path,logMessage);
	}

	//This method is used to get the folder name with date
	public String getFolderName() {
		return "Tracking-"+getDate();
	}
	//This method is used to create folder
	public String createFolder() {
		String folderName = getFolderName();
		file = new File("./Logs/"+folderName);
		boolean bool = file.mkdir();
	      if(bool){
	         System.out.println("Directory created successfully");
	      } else {
	         System.out.println("Sorry couldn�t create specified directory");
	      }
	      return folderName;
	}

}
