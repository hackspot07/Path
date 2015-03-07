import java.util.*;
import java.io.*;

class Path{
	public static void main(String[] args)throws Exception{
		boolean getStatus;
		PathFinder pf;
		Map<Integer,String> seperatedArgs = new HashMap<Integer,String>();
		try{ 
			ArgumentSeperator argsSeperator = new ArgumentSeperator(args);
			seperatedArgs = argsSeperator.getArgs();
			if(seperatedArgs.containsKey(0) && seperatedArgs.containsKey(1))
				pf = new PathFinder(PathReader.getPathByReadFile(seperatedArgs.get(1)));
			if(seperatedArgs.containsKey(0) && !seperatedArgs.containsKey(1))
				throw new Exception("You give flag for file Please Give FileName");
			else
				 pf = new PathFinder(Database.createDbDatabase());
			getStatus = pf.path(seperatedArgs.get(2),seperatedArgs.get(3));
			System.out.println(getStatus);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}