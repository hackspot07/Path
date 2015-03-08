import com.Path.ArgumentSeperator;
import com.Path.Database;
import com.Path.PathFinder;
import com.Path.PathReader;
import com.Path.CountryReader;

import java.util.HashMap;
import java.util.Map;

class Path{
	public static void main(String[] args)throws Exception{
		boolean getStatus;
		PathFinder pf;
		Map<Integer,String> seperatedArgs = new HashMap<Integer,String>();
		try{ 
			ArgumentSeperator argsSeperator = new ArgumentSeperator(args);
			seperatedArgs = argsSeperator.getArgs();
			if(seperatedArgs.containsKey(0) && seperatedArgs.containsKey(1) && seperatedArgs.containsKey(2) && seperatedArgs.containsKey(3))
               pf = new PathFinder(CountryReader.getPathWithCountry(seperatedArgs.get(1), seperatedArgs.get(2)));
            
            if(seperatedArgs.containsKey(0) && seperatedArgs.containsKey(1))
			    pf = new PathFinder(PathReader.getPathByReadFile(seperatedArgs.get(1)));

            if(!seperatedArgs.containsKey(0) && seperatedArgs.containsKey(2))
                pf = new PathFinder(Database.createDbDatabase());
			else
                throw new Exception("You give flag for file Please Give FileName");
			getStatus = pf.path(seperatedArgs.get(4),seperatedArgs.get(5));
			System.out.println(getStatus);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}