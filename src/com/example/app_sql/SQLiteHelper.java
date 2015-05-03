package com.example.app_sql;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract.Data;

import java.sql.Date;
import java.text.SimpleDateFormat;

 
public class SQLiteHelper extends SQLiteOpenHelper {

       private final static  String DATABASE_NAME="library";
	   private final static int DATABASE_VERSION = 1;
	   private String TABLE_NAME="x";
//	   创建本地数据库
	   private static SQLiteHelper instance;
	   private SQLiteHelper(Context c){
		   super(c,DATABASE_NAME,null,DATABASE_VERSION);
	   }
//	       单例模式
	   public static SQLiteHelper getInstance(Context context) {  
	        if (instance == null) {  
	            instance = new SQLiteHelper(context);  
	        }   
	        return instance;  
	    }  
//	  数据库表名生成
       public void  getTableName(String n){
		   String name="";
//		  以当前输入作为数据库表名
		   name=n+"Database";
		   TABLE_NAME=name;
	   }
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		 String sql=" CREATE TABLE "+ TABLE_NAME +
			        " (_id INTEGER PRIMARY KEY,"+
				    " GoodName VARCHAR (100) NOT NULL,"+
			        " GoodPrice FLOAT(6,2) NOT NULL,"+
				    " GoodLow FLOAT(6,2),"+
			        " DataTime VARCHAR(8)," +
			        " Note VARCHAR(100))";
		 db.execSQL(sql);
	}
	@Override
//	第二次（数据库版本更改时调用此方法）
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		 String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
         db.execSQL(sql);
         onCreate(db);
	}
//	query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit)方法各参数的含义： 
//	table：表名。相当于select语句from关键字后面的部分。如果是多表联合查询，可以用逗号将两个表名分开。 
//	columns：要查询出来的列名。相当于select语句select关键字后面的部分。 
//	selection：查询条件子句，相当于select语句where关键字后面的部分，在条件子句允许使用占位符“?” 
//	selectionArgs：对应于selection语句中占位符的值，值在数组中的位置与占位符在语句中的位置必须一致，否则就会有异常。 
//	groupBy：相当于select语句group by关键字后面的部分 
//	having：相当于select语句having关键字后面的部分 
//	orderBy：相当于select语句order by关键字后面的部分，如：personid desc, age asc; 
//	limit：指定偏移量和获取的记录数，相当于select语句limit关键字后面的部分。 
	public Cursor select(){
		SQLiteDatabase db=this.getReadableDatabase();
		Cursor cursor=db.query(TABLE_NAME, null, null, null, null, null, null, null);
		return cursor;
	}
	 //插入一条记录
    public long insert(String GoodName,float GoodPrice ,float GoodLow,String time,String note) {
           SQLiteDatabase db = this.getWritableDatabase();
           ContentValues cv = new ContentValues();
           cv.put("GoodName", GoodName);
           cv.put("GoodPrice", GoodPrice);
           cv.put("GoodLow", GoodLow);
           cv.put("DataTime", time);
           cv.put("Note", note);
           long row = db.insert(TABLE_NAME, null, cv);
           return row;
    }
//    删除一条记录
    public void delete(int id){
    	SQLiteDatabase db =this.getReadableDatabase();
    	String where ="_id =?";
    	String[] whereValue ={Integer.toString(id)};
    	db.delete(TABLE_NAME,where,whereValue);
    }
//    更新记录
    public void updata(int id,String GoodName,float GoodPrice ,float GoodLow,String time,String note){
    	SQLiteDatabase db=this.getReadableDatabase();
    	String where="_id=?";
    	String[] whereValue={Integer.toString(id)};
    	ContentValues cv = new ContentValues();
    	cv.put("GoodName", GoodName);
        cv.put("GoodPrice", GoodPrice);
        cv.put("GoodLow", GoodLow);
        cv.put("DataTime", time);
        cv.put("Note", note);
        db.update(TABLE_NAME, cv, where, whereValue);
    }
//     中文模糊查询
//     中文转化为utf—8
    public Cursor query(String args[]){
    	SQLiteDatabase db=this.getReadableDatabase();
    	Cursor cursor =db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE GoodName LIKE ?", args);
    	return cursor;
   
    }
//     日期查询
    public  Cursor queryDate(String args[]){
    	SQLiteDatabase  db=this.getReadableDatabase();
    	Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE DataTime LIKE ?", args);
    	return cursor;
    }

    	
    
}


