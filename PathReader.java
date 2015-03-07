import java.util.*;
import java.io.*;

public class PathReader{
	private String file;

	public PathReader(String filename){
		this.file = filename;
	}

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
			}
		}catch(Exception e){
			throw new Exception("Database File not found");
		}
		return db;
	}
}
