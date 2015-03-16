package com.Path;

import java.util.*;

import static java.util.Collections.reverse;

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
		result = hasPath(source,destination);
        if(!result){
            hasPath(destination,source);
            for(Integer key : allPaths.keySet()){
                reverse(allPaths.get(key));
                allPaths.get(key).add(destination);
            }
        }
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
				hasPath(src,destination);
                root.remove(src);
			}
            return true;
		};
		return false;
	}

	public void printPath(Map<Integer, ArrayList<String>> root, boolean isallPath, Map<String, Integer> costTable){
		String r = "",prev="";
        double totalCost= 0.0;
		for(Integer list : root.keySet()){
            if(root.size()>=2)
                r = r.concat(list+" ");
            for(String item : root.get(list)) {
                prev = prev.concat("->"+item);
                if(costTable.containsKey(prev)){
                    totalCost += (double)costTable.get(prev);
                    prev = "->"+item;
                }
                r = r.concat("->" + item);
            }
            r = r.concat("\r\n"+"Total Cost:"+totalCost);
            System.out.println(r);
            totalCost = 0.0;prev = "";r= "";
            if(!isallPath) break;
        }
	}
    public Map<Integer,ArrayList<String>> getRoot(){
        return allPaths;
    }
};

