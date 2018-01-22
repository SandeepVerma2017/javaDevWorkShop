package com.vehicle.file.io;

import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.activation.MimetypesFileTypeMap;

import org.apache.commons.lang.ArrayUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vehicle.domain.object.FileDomain;
import com.vehicle.domain.object.VehicleDomain;

public class FileReader {

	
/**
 *  Main method which run the methods to get
 *  1. All file information in a directory.
 *  2. All csv file information in a directory.
 *  3. All Excel file information in a directory.
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	FileReader fileinDirectory= new FileReader();	

//	 print all File in a directory.	
	List<FileDomain> fileCollection=fileinDirectory.getfileInfoDirectory();
		
	Iterator fileColIter=fileCollection.iterator();
	
	System.out.println("---------Printing the All file info in a Directory-----------------");	
	
	while (fileColIter.hasNext())
	{
		FileDomain fileinfo=(FileDomain) fileColIter.next();
		System.out.println("FileName::"+fileinfo.getFileName()+"--FileFileMimeType::"+fileinfo.getFileMimeType()
		+"--FileExt::"+fileinfo.getFileExt()+"--FileSize::"+fileinfo.getFileSize());
		
	}
	
  // printing all csv file information 	
	
	List<FileDomain> csvfileCollection=fileinDirectory.getCSVfileInfoFromDirectory();	
    Iterator csvfileColIter=csvfileCollection.iterator();
	
	System.out.println("---------Printing the CSV file info in a Directory-----------------");	
	
	while (csvfileColIter.hasNext())
	{
		FileDomain fileinfo=(FileDomain) csvfileColIter.next();
		System.out.println("FileName::"+fileinfo.getFileName()+"--FileFileMimeType::"+fileinfo.getFileMimeType()
		+"--FileExt::"+fileinfo.getFileExt()+"--FileSize::"+fileinfo.getFileSize());
		
	}
	
	
	// printing all Excel file information 	
	
		List<FileDomain> excelfileCollection=fileinDirectory.getExcelfileInfoFromDirectory();		
    	Iterator excelfileColIter=excelfileCollection.iterator();
		
		System.out.println("---------Printing the Excel file info in a Directory-----------------");	
		
		while (excelfileColIter.hasNext())
		{
			FileDomain fileinfo=(FileDomain) excelfileColIter.next();
			System.out.println("FileName::"+fileinfo.getFileName()+"--FileFileMimeType::"+fileinfo.getFileMimeType()
			+"--FileExt::"+fileinfo.getFileExt()+"--FileSize::"+fileinfo.getFileSize());
			
		}	
		
	}
	
	
/** 
 * Read the file information from a directory and return all file information in a File List. 
 */
public List<FileDomain>  getfileInfoDirectory()
{
	 // File info Object List  
	 List<FileDomain> FileDomainList= new ArrayList<FileDomain>(); 
	// get all the file information in a input directory and populate the list.
	List<File> filesInfo=Stream.of(new File("./input").listFiles()).collect(Collectors.toList());
  
	// populate the file info into FileObjectCache. 
	  Iterator itr=filesInfo.iterator();
	  while(itr.hasNext())
	  {
		  FileDomain FileInfo= new FileDomain();   
		 File fileHandle= (File)itr.next();
		 FileInfo.setFileName(fileHandle.getName().substring(0,fileHandle.getName().lastIndexOf(".")));
	     FileInfo.setFileSize(fileHandle.length());
		 FileInfo.setFileExt(fileHandle.getName().substring(fileHandle.getName().lastIndexOf(".")+1));		 
		 String mimeType = null;
		try {
			mimeType = Files.probeContentType(fileHandle.toPath());
			FileInfo.setFileMimeType(mimeType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		 
		 FileDomainList.add(FileInfo);	 
		  
	  }
	  return FileDomainList;


}


/** 
 * Read the csv file information from a directory and return all file information in a File List. 
 */
public List<FileDomain>  getCSVfileInfoFromDirectory()
{
	 // File info Object List  
	 List<FileDomain> FileDomainList= new ArrayList<FileDomain>(); 
	// get all the file information in a input directory and populate the list.
	List<File> filesInfo=Stream.of(new File("./input").listFiles()).filter(path -> path.toString().endsWith(".csv")).collect(Collectors.toList());
  
	// populate the file info into FileObjectCache. 
	  Iterator itr=filesInfo.iterator();
	  while(itr.hasNext())
	  {
		  FileDomain FileInfo= new FileDomain();   
		 File fileHandle= (File)itr.next();
		 FileInfo.setFileName(fileHandle.getName().substring(0,fileHandle.getName().lastIndexOf(".")));
	     FileInfo.setFileSize(fileHandle.length());
		 FileInfo.setFileExt(fileHandle.getName().substring(fileHandle.getName().lastIndexOf(".")+1));		 
		 String mimeType = null;
		try {
			mimeType = Files.probeContentType(fileHandle.toPath());
			FileInfo.setFileMimeType(mimeType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		 
		 FileDomainList.add(FileInfo);	 
		  
	  }
	  return FileDomainList;


}


/** 
 * Read the Excel file information from a directory and return all file information in a File List. 
 */
public List<FileDomain>  getExcelfileInfoFromDirectory()
{
	 // File info Object List  
	 List<FileDomain> FileDomainList= new ArrayList<FileDomain>(); 
	// get all the file information in a input directory and populate the list.
	List<File> filesInfo=Stream.of(new File("./input").listFiles()).filter(path -> path.toString().endsWith(".xlsx")).collect(Collectors.toList());
  
	// populate the file info into FileObjectCache. 
	  Iterator itr=filesInfo.iterator();
	  while(itr.hasNext())
	  {
		  FileDomain FileInfo= new FileDomain();   
		 File fileHandle= (File)itr.next();
		 FileInfo.setFileName(fileHandle.getName().substring(0,fileHandle.getName().lastIndexOf(".")));
	     FileInfo.setFileSize(fileHandle.length());
		 FileInfo.setFileExt(fileHandle.getName().substring(fileHandle.getName().lastIndexOf(".")+1));		 
		 String mimeType = null;
		try {
			mimeType = Files.probeContentType(fileHandle.toPath());
			FileInfo.setFileMimeType(mimeType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		 
		 FileDomainList.add(FileInfo);	 
		  
	  }
	  return FileDomainList;


}

/**
 * Reading Data from the csv files.
 * 
 * 
 */

public List<VehicleDomain> vehicleInformationFromCsvFile() {
List<VehicleDomain> vehicleCache =new ArrayList<VehicleDomain>();
try
{
Files.list(Paths.get("./input")).forEach(System.out::println);
List<File> Files1=Stream.of(new File("./input").listFiles()).filter(path -> path.toString().endsWith(".csv")).collect(Collectors.toList());

  
 // File info Object List  
 List<FileDomain> FileDomainList= new ArrayList<FileDomain>(); 
   
// populate the file info into FileObjectCache. 
  Iterator itr=Files1.iterator();
  while(itr.hasNext())
  {
	  FileDomain FileInfo= new FileDomain();   
	 File FileNameType= (File)itr.next();
	 FileInfo.setFileName(FileNameType.getName());
	 FileInfo.setFileSize(FileNameType.length());
	 FileInfo.setFilePath(FileNameType.getPath());
	 FileDomainList.add(FileInfo);
	  
  }
  
  Iterator FileDomainitr=FileDomainList.iterator();
   
  FileDomain FileInfo1;
  List <String> fileLines=new ArrayList<String>();
 

  // read the content of each file 
  
  while (FileDomainitr.hasNext())
  {
	  FileInfo1= (FileDomain)FileDomainitr.next();
	 System.out.println("FileName::- "+FileInfo1.getFileName()+"::FileSize::"+FileInfo1.getFileSize());  
	 String fileName = FileInfo1.getFilePath();
	 System.out.println("FileName::"+fileName);
	 try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

//			stream.forEach(System.out::println);
			fileLines=stream.collect(Collectors.toList());
			Iterator FileLineitr=	fileLines.iterator();

			// In a perticular file read the lines
			FileLineitr.next();
			while(FileLineitr.hasNext())
			{   
				
		       String line= (String)FileLineitr.next();
			List<String> words=	Arrays.asList(line.split(","));
			Iterator worditr=	words.iterator();
	
			// Break the lines into words 
			
			// skip the header line in a file.
			
			while(worditr.hasNext())
			{ 
				String Regno=(String)worditr.next();
				String Make=(String)worditr.next();
				String Colour=(String)worditr.next();
				
		System.out.println("XX::"+Regno+"::"+Make+"::"+Colour);	
	
		// populating the vehicle domain and adding to vehicle cache.
		      VehicleDomain vehicleInfo= new VehicleDomain();
		      vehicleInfo.setRegNo(Regno);
				vehicleInfo.setMake(Make);
				vehicleInfo.setColour(Colour);
				vehicleCache.add(vehicleInfo);
		//SOP debug statement		
		System.out.println("vehicleRegNum::"+vehicleInfo.getRegNo()+"vehicleInfo::"+vehicleInfo.getMake()+"::"+vehicleInfo.getColour());					
				
			}
			
			
			}
			 
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	  
  }


}
catch(IOException e)
{
e.printStackTrace();	
}	

return 	vehicleCache;
}


/**
 * Reading Data from the Excel files.
 * 
 * 
 */

public List<VehicleDomain> vehicleInformationFromExcelFile() {
List<VehicleDomain> vehicleCache =new ArrayList<VehicleDomain>();
try
{
Files.list(Paths.get("./input")).forEach(System.out::println);
List<File> Files1=Stream.of(new File("./input").listFiles()).filter(path -> path.toString().endsWith(".xlsx")).collect(Collectors.toList());

  
 // File info Object List  
 List<FileDomain> FileDomainList= new ArrayList<FileDomain>(); 
   
// populate the file info into FileObjectCache. 
  Iterator itr=Files1.iterator();
  while(itr.hasNext())
  {
	  FileDomain FileInfo= new FileDomain();   
	 File FileNameType= (File)itr.next();
	 FileInfo.setFileName(FileNameType.getName());
	 FileInfo.setFileSize(FileNameType.length());
	 FileInfo.setFilePath(FileNameType.getPath());
	 FileDomainList.add(FileInfo);
	  
  }
  
  Iterator FileDomainitr=FileDomainList.iterator();
   
  FileDomain FileInfo1;
  List <String> fileLines=new ArrayList<String>();
 

  // read the content of each file 
  
  while (FileDomainitr.hasNext())
  {
	  FileInfo1= (FileDomain)FileDomainitr.next();
	 System.out.println("FileName::- "+FileInfo1.getFileName()+"::FileSize::"+FileInfo1.getFileSize());  
	 String fileName = FileInfo1.getFilePath();
	 System.out.println("FileName::"+fileName);
	 
	 Workbook book = null;
	try {
		book = new XSSFWorkbook(new File(fileName));
	} catch (InvalidFormatException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
     Sheet sheet = book.getSheet("File1");
     for (int i = 1; i <= sheet.getLastRowNum(); i++) {
         Row row = sheet.getRow(i);
         String RegNumber = row.getCell(0).getStringCellValue();
         String Make = row.getCell(1).getStringCellValue();
         String Colour =row.getCell(2).getStringCellValue();
	      VehicleDomain vehicleInfo= new VehicleDomain();
	      vehicleInfo.setRegNo(RegNumber);
			vehicleInfo.setMake(Make);
			vehicleInfo.setColour(Colour);
			vehicleCache.add(vehicleInfo);
			System.out.println("vehicleRegNum::"+vehicleInfo.getRegNo()+"vehicleInfo::"+vehicleInfo.getMake()+"::"+vehicleInfo.getColour());								
     }
     book.close();
	 }


}
catch(IOException e)
{
e.printStackTrace();	
}	

return 	vehicleCache;
}

/**
 * Combining data from csv and excel files.
 * 
 * 
 */

public List<VehicleDomain> vehicleInformationFromAllFile() {
	List<VehicleDomain> vehicleCacheAll =new ArrayList<VehicleDomain>();
	List<VehicleDomain> vehicleCachecsv =new ArrayList<VehicleDomain>();
	FileReader fileinDirectory= new FileReader();	
	
	vehicleCacheAll=fileinDirectory.vehicleInformationFromExcelFile();
	
 System.out.println("vehicleCacheAll::"+vehicleCacheAll.size());	
	 vehicleCachecsv= fileinDirectory.vehicleInformationFromCsvFile();
	Iterator vehicleIter= vehicleCachecsv.iterator();
	
	while (vehicleIter.hasNext())
	{
		VehicleDomain vehilceCsv=(VehicleDomain)vehicleIter.next();
		vehicleCacheAll.add(vehilceCsv);
		
		
	}
	 
	System.out.println("vehicleCacheAll::"+vehicleCacheAll.size()); 
	
	return vehicleCacheAll;

}

}
