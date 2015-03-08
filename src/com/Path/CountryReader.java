package com.Path;
import com.Path.PathReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryReader{
    public static Map<String,List<String>> getPathWithCountry(String file,String countryFile)throws Exception{
        Map<String,List<String>> countryMap = new HashMap<String,List<String>>();
        Map<String,List<String>> cityMap = PathReader.getPathByReadFile(file);
        try{
            BufferedReader fr = new BufferedReader(new FileReader(file));
            String line ="";
            while((line=fr.readLine())!=null){
                String path[] = line.split(",");
                List<String> list = new ArrayList<String>();
                //write code here to make map
                countryMap.put(path[1],list);
            }
        }catch(Exception e){
            throw new Exception("Database country File not found");
        }
        return countryMap;
    }
}