package com.example.app_sql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;






import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class Dataup {
	private boolean ifexit=true;
	private String filePath;
	private static final String EXTENSION_XLS = "xls";
    private static final String EXTENSION_XLSX = "xlsx";
    private String [][] shuzu;
    private int changdu;
    private int kuangdu;
	private File file;
	
	
	
	//获得sd卡的根目录

	public String getpath(){
		  String path="更新表.txt";
		  return path;
		  
	}
	
//	判断文件是否存在
//  文件检查
  public  void preReadCheck() throws FileNotFoundException {
      // 常规检查
	   
       file =new File("/storage/sdcard1" ,
    		   getpath());  
      if (!file.exists()) {
    	  ifexit=false;
    	  System.out.println("不存在");
          throw new FileNotFoundException("传入的文件不存在：" + filePath+"/更新表.txt");  
      }
      
 
  }
  public String [][] readshuzu(int n) throws IOException{
	  n=jisuqi();
	  String [][] shuju=new String[n][5];
	  BufferedReader in = new BufferedReader(new FileReader(file));  //
	  String line;  //一行数据
	  int row=0;
	  //逐行读取，并将每个数组放入到数组中
	  while((line = in.readLine()) != null){
	   String[] temp = line.split("\t"); 
	   for(int j=0;j<temp.length;j++){
	    shuju[row][j] =temp[j];
//	    System.out.println(shuju[row][j]);
	   }
	   row++;
	  }
	  in.close();
	  return shuju;
	
}
     public int jisuqi() throws IOException{
  	  int count = 0;
  	  
  	  InputStream input = new FileInputStream(file);
  	  BufferedReader b = new BufferedReader(new InputStreamReader(input));String value = b.readLine();
  	     if(value != null)
  		     while(value !=null){
  	                      count++;
  	                      value = b.readLine();
  	                     }
      	b.close();
  	    input.close();
//  	  System.out.println("完成");
  	    return count;
  }
  public boolean  getbool(){
	  return ifexit;
  }

	    public String[][]getshuzhu(){
	    	return shuzu;
	    }
	    
	    

}
