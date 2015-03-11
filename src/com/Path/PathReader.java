package com.Path;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathReader{
    private static Map<String,Integer> costTable = new HashMap<String,Integer>();
	public static Map<String,List<String>> getPathByReadFile(String file) throws Exception{
        Map<String,List<String>> db = new HashMap<String,List<String>>();
		try{
			BufferedReader fr = new BufferedReader(new FileReader(file));
			String line ="";
			while((line=fr.readLine())!=null){
				String path[] = line.split(",");
				List<String> list = new ArrayList<String>();
				if(db.get(path[0])!=null){
					list = db.get(path[0]);
					list.add(path[1]);
				}else{
					list.add(path[1]);
				}	
				db.put(path[0],list);
                String key= "->"+path[0].concat("->"+path[1]);
                costTable.put(key,Integer.parseInt(path[2]));
			}
		}catch(Exception e){
			throw new Exception("Database File not found");
		}
		return db;
	}
    public static Map<String,Integer> getCostTable(){
        return costTable;
    }
}
