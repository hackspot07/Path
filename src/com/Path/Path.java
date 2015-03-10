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
            boolean getStatus;
            PathFinder pf;
            Map<Integer,String> seperatedArgs = new HashMap<Integer,String>();
            Map<String,List<String>> countryMap = new HashMap<String,List<String>>();
            Map<Integer,ArrayList<String>> root = new HashMap<Integer,ArrayList<String>>();
            ArgumentSeperator argsSeperator = new ArgumentSeperator(args);
            seperatedArgs = argsSeperator.getArgs();

			if(seperatedArgs.containsKey(0) && seperatedArgs.containsKey(1) && seperatedArgs.containsKey(2) && seperatedArgs.containsKey(3)){
                pf = new PathFinder(PathReader.getPathByReadFile(seperatedArgs.get(1)));
                countryMap = CountryReader.getPathWithCountry(seperatedArgs.get(3));
                root = pf.getRoot();
                getStatus = pf.path(seperatedArgs.get(4),seperatedArgs.get(5));
                CountryReader.printWithCountry(root,countryMap);
                System.out.println(getStatus);
                return ;
            }

            if(seperatedArgs.containsKey(0) && seperatedArgs.containsKey(1)) {
                pf = new PathFinder(PathReader.getPathByReadFile(seperatedArgs.get(1)));
                root = pf.getRoot();
                getStatus = pf.path(seperatedArgs.get(4),seperatedArgs.get(5));
                pf.printPath(root);
                System.out.println(getStatus);
                return ;
            }

            if(!seperatedArgs.containsKey(0) && !seperatedArgs.containsKey(2)) {
                pf = new PathFinder(Database.createDbDatabase());
                root = pf.getRoot();
                getStatus = pf.path(seperatedArgs.get(4),seperatedArgs.get(5));
                pf.printPath(root);
                System.out.println(getStatus);
                return ;
            }
			else {
                throw new Exception("You give flag for file Please Give FileName");
            }
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}