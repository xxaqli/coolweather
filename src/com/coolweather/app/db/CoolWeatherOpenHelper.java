package com.coolweather.app.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;

public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
	
	//province�������
	public static final String CREATE_PROVINCE="create table Province("
			+ "id integer primary key autoincrement, "
			+ "province_name text, "
			+ "province_code text)";
	
	//city�������
	public static final String CREATE_CITY="create table City("
			+ "id integer primary key autoincrement ,"
			+ "city_name text ,"
			+ "city_code text ,"
			+ "province_id integer)";		//��ʾ����province�����
	
	//county�������
	public static final String CREATE_COUNTY="create table County("
			+ "id integer primary key autoincrement ,"
			+ "county_name text ,"
			+ "county_code text ,"
			+ "city_id integer)";
	
	private Context mContext;
	
	public CoolWeatherOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		mContext=context;
	}
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_PROVINCE);
		db.execSQL(CREATE_CITY);
		db.execSQL(CREATE_COUNTY);
		Toast.makeText(mContext, "Create succeeded", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
