package com.Path;

import java.util.*;

public class PathFinder{
	private Map<String, List<String>> db = new HashMap<String, List<String>>();

    private static Set<String> visitedPath = new HashSet<String>();
    private static ArrayList<String> root = new ArrayList<String>();
    private static Map<Integer,ArrayList<String>> allPaths  = new HashMap<Integer,ArrayList<String>>();
    private int count;

    public PathFinder(Map<String, List<String>> db){
		this.db = db;
	}

   
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
                allPaths.put(++count,(ArrayList<String>)root.clone());
                visitedPath.clear();
                root.remove(destination);
                return true;
			}
			for(String src : list){
				if(!visitedPath.contains(src))
                	root.add(src);
				if(hasPath(src,destination)) {

                }
                root.remove(src);
			}
            return true;
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

	public void printPath(Map<Integer, ArrayList<String>> root, boolean isallPath){
		String r = "";
        int count = 1;
		for(Integer list : root.keySet()){
            if(root.size()>=2)
                r = r.concat(list+" ");
            for(String item : root.get(list))
                r = r.concat("->" + item);
            r = r.concat("\r\n");
            if(!isallPath) break;
        }
		System.out.println(r);
	}
    public Map<Integer,ArrayList<String>> getRoot(){
        return allPaths;
    }
};

