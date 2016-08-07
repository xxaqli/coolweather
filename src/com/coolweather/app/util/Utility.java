package com.coolweather.app.util;

import com.coolweather.app.db.CoolWeatherDB;
import com.coolweather.app.model.City;
import com.coolweather.app.model.County;
import com.coolweather.app.model.Province;

import android.text.TextUtils;

public class Utility {
	//对服务器返回的省市县数据进行解析和处理操作
	public synchronized static boolean handleProvincesResponse(CoolWeatherDB coolWeatherDB,String response){
		if(!TextUtils.isEmpty(response)){
			String[] allProvinces=response.split(",");
			if(allProvinces!=null && allProvinces.length>0){
				for(String p:allProvinces){
					String[] array=p.split("\\|");
					Province province =new Province();
					province.setProvinceName(array[1]);
					province.setProvinceCode(array[0]);
					
					//将解析出来的数据存储到数据库的Province表
					coolWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	
	//对服务器返回的市级数据进行处理
	public static boolean handleCitiesResponse(CoolWeatherDB coolWeatherDB,String response,int provinceId){
		if(!TextUtils.isEmpty(response)){
			String[] allCities=response.split(",");
			if(allCities!=null && allCities.length>0){
				for(String c:allCities){
					String[] array=c.split("\\|");
					City city=new City();
					city.setCityName(array[1]);
					city.setCityCode(array[0]);
					city.setProvinceId(provinceId);
					
					//将解析出来的数据存储到City表
					coolWeatherDB.saveCity(city);
				}
				return true;
			}
			
		}
		return false;
	}
	
	//解析和处理服务器返回的县级数据
	public static boolean handleCountyResponse(CoolWeatherDB coolWeatherDB,String response,int cityId){
		if(!TextUtils.isEmpty(response)){
			String[] allCounties=response.split(",");
			if(allCounties!=null && allCounties.length>0){
				for(String c:allCounties){
					String[] array=c.split("\\|");
					County county=new County();
					county.setCountyName(array[1]);
					county.setCountyCode(array[0]);
					county.setCityId(cityId);
					
					//将解析出来的数据存储到county表
					coolWeatherDB.saveCounty(county);
				}
				return true;
			}
		}
		return false;
			
	}
	
	
	
	

}
