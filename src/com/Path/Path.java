import com.Path.ArgumentSeperator;
import com.Path.Database;
import com.Path.PathFinder;
import com.Path.PathReader;
import com.Path.CountryReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Path {
	public static void main(String[] args)throws Exception{
        try{
            boolean getStatus,isallPath;
            PathFinder pf;
            Map<Integer,String> seperatedArgs = new HashMap<Integer,String>();
            Map<String,List<String>> countryMap = new HashMap<String,List<String>>();
            Map<Integer,ArrayList<String>> root = new HashMap<Integer,ArrayList<String>>();
            ArgumentSeperator argsSeperator = new ArgumentSeperator(args);
            seperatedArgs = argsSeperator.getArgs();
            isallPath = (seperatedArgs.containsKey(4)) ? true : false;
			if(seperatedArgs.containsKey(0) && seperatedArgs.containsKey(1) && seperatedArgs.containsKey(2) && seperatedArgs.containsKey(3)){
                pf = new PathFinder(PathReader.getPathByReadFile(seperatedArgs.get(1)));
                countryMap = CountryReader.getPathWithCountry(seperatedArgs.get(3));
                getStatus = pf.path(seperatedArgs.get(5),seperatedArgs.get(6));
                root = pf.getRoot();
                Map<String,Integer> costTable = PathReader.getCostTable();
                CountryReader.printWithCountry(root,countryMap,isallPath,costTable);
                System.out.println(getStatus);
                return ;
            }

            if(seperatedArgs.containsKey(0) && seperatedArgs.containsKey(1)) {
                pf = new PathFinder(PathReader.getPathByReadFile(seperatedArgs.get(1)));
                getStatus = pf.path(seperatedArgs.get(5),seperatedArgs.get(6));
                root = pf.getRoot();
                Map<String,Integer> costTable = PathReader.getCostTable();
                pf.printPath(root,isallPath,costTable);
                System.out.println(getStatus);
                return ;
            }
			else {
                throw new Exception("Database file not found Please Give FileName");
            }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}