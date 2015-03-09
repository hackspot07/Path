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
		boolean getStatus;
		PathFinder pf;
		Map<Integer,String> seperatedArgs = new HashMap<Integer,String>();
        Map<String,List<String>> countryMap = new HashMap<String,List<String>>();
        ArrayList<String> root = new ArrayList<String>();
		try{
			ArgumentSeperator argsSeperator = new ArgumentSeperator(args);
			seperatedArgs = argsSeperator.getArgs();
			if(seperatedArgs.containsKey(0) && seperatedArgs.containsKey(1) && seperatedArgs.containsKey(2) && seperatedArgs.containsKey(3)){
                pf = new PathFinder(PathReader.getPathByReadFile(seperatedArgs.get(1)));
                countryMap = CountryReader.getPathWithCountry(seperatedArgs.get(3));
                root = pf.getRoot();
                CountryReader.printWithCountry(root,countryMap);
            }

            if(seperatedArgs.containsKey(0) && seperatedArgs.containsKey(1)) {
                pf = new PathFinder(PathReader.getPathByReadFile(seperatedArgs.get(1)));
                root = pf.getRoot();
                pf.printPath(root);
            }

            if(!seperatedArgs.containsKey(0) && seperatedArgs.containsKey(2)) {
                pf = new PathFinder(Database.createDbDatabase());
                root = pf.getRoot();
                pf.printPath(root);
            }
			else {
                throw new Exception("You give flag for file Please Give FileName");
            }
            getStatus = pf.path(seperatedArgs.get(4),seperatedArgs.get(5));
            System.out.println(getStatus);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}