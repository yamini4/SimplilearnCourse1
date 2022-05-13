package finalProject_course1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Lockedme_com {

	static Scanner sc = new Scanner(System.in);
	static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		System.out.println("\n\n******************** Welcome to Lockedme.com **************************");
		System.out.println("\n\t\tApplication Name: Virtual Key Repository\n");
		System.out.println("******************** Developer Details **************************\n\n");
		LocalDate myDateObj = LocalDate.now(); // Create a date object
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
		String formattedDate = myDateObj.format(myFormatObj);
		System.out.println("\t\tName:  Yamini Garudachalam\n\t\tDesignation: Software Developer\n\t\tDate: "+formattedDate+"\n\n");
		OptionsSelection();
	}

	static void OptionsSelection() throws IOException {
		System.out.println("enter 1: for get file names in ascending order.\nenter 2: for Business Level Operation.\nenter 3: Close the Application");
        int x = sc.nextInt();
        switch(x) {
        case 1:
        	//Arrange the files in ascending order according to their name
        	sort();
        	break;
        case 2:
        	//for business level operations
        	System.out.println("enter 1 : add file\nenter 2:  delete file\nenter 3:  search file\nenter 4:  go back");
        	int input = sc.nextInt();
        	if(input==1) {
        		//add new file(create new file)
        		newFile();
        	}else if(input==2){
        		//delete particular file
        		deleteFile();
        	}else if(input==3) {
        		//search file
        		searchFile();
        	}else if(input==4) {
        		//go back
        		OptionsSelection();
        	}else {
        		System.out.println("Please enter valid input");
        	}
        	break;
        case 3:
        	//to close the application
        	System.out.println("Your application was closed");
        	break;
        default:
        	System.out.println("Please enter the valid input");
        }
	}
	public static void sort() {
		String strPath ="C:\\Users\\Yamini\\OneDrive\\Desktop\\simplilearn\\";
		
		File directory = new File(strPath);
		
		String[] flistArray = directory.list();
		
		Arrays.sort(flistArray);
		System.out.println(Arrays.asList(flistArray));
	}
	public static void newFile() {
		String strPath = "", strName = "", text = "";
		try {
			strPath ="C:\\Users\\Yamini\\OneDrive\\Desktop\\simplilearn\\";
			System.out.println("Enter the file name:");
			strName = br.readLine();
			System.out.println("Enter the string which one you want to add in the created file:");
			text = br.readLine();
			
			File file1 = new File(strPath+strName+".txt");
			Path fileName = Path.of(strPath+strName+".txt");
			
			file1.createNewFile();
			Files.writeString(fileName, text);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteFile() {
		String strName= "";
		String strPath ="C:\\Users\\Yamini\\OneDrive\\Desktop\\simplilearn\\";
        
		File directory = new File(strPath);
		String[] flist = directory.list();
		System.out.println(Arrays.toString(flist));
		System.out.println("Enter your file name:(ex: 'yummy.txt' format)");
		try {
			strName = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = new File(strPath+strName);
		if(file.delete()) {
			System.out.println("File Deleted Succesfully");
		}else {
			System.out.println("Failed to delete the file\n'I think your file doesn't exist'");
		}
	}
	//linear search used in this
	public static void searchFile() throws IOException{
		String strName= "";
		String strPath ="C:\\Users\\Yamini\\OneDrive\\Desktop\\simplilearn\\";
				
		File directory = new File(strPath);
		
		String[] flist = directory.list();
		int flag=0;
		if(flist == null) {
			System.out.println("Empty Directory");
		}else {
			System.out.println("Enter your file name with extension:(ex:yummy.txt)");
			strName = br.readLine();
			
			for(int i=0;i<flist.length;i++) {
				if(flist[i].equals(strName)) {
					System.out.println(flist[i]+" found");
					flag = 1;
				}
			}
			if(flag == 0) {
				System.out.println("File Not Found");
			}
		}
	}
}


















