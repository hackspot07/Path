package com.Path;

import java.util.*;

public class PathFinder{
	private Map<String, List<String>> db = new HashMap<String, List<String>>();

	public PathFinder(Map<String, List<String>> db){
		this.db = db;
	}

	private static Set<String> visitedPath = new HashSet<String>();
    private static ArrayList<String> root = new ArrayList<String>();

   
	public boolean path(String source,String destination)throws Exception{
		boolean result;
 		if(!isPresentCities(source)){
			throw new Exception("No city Named "+source);
		}
		if(!isPresentCities(destination)){
			throw new Exception("No city Named "+destination);
		}
		root.add(source);
		source = madeKey(source);
		result = hasPath(source,destination) ? true : hasPath(destination,source);
		return result;
	}

	public boolean isPresentCities(String src){
		for(String s : db.keySet()){
			if(db.get(s).contains(src) || db.containsKey(src))
				return true;
		}
		return false;
	}

	public boolean hasPath(String source,String destination){
		visitedPath.add(source); 
		List<String> list = db.get(source);
		if(list!=null){
			if(list.contains(destination)){
				root.add(destination);
				printPath(root);
				return true;
			}
			for(String src : db.get(source)){
				if(!visitedPath.contains(src))
                	root.add(src);
				if(hasPath(src,destination))
					return true;
			}	
		}; 
		return false;
	}

	public String getKey(String value){
		for(String key: db.keySet()){
			if(db.get(key).contains(value)){
				return key;
			}
		}
		return null;
	}

	public String madeKey(String source){
		return (db.containsKey(source)) ? source : getKey(source);
	}

	private  static void printPath(ArrayList<String> root){
		String r = "";
		for(String item : root){
			r = r.concat("->"+item);
		}
		System.out.println(r);
	}
};

