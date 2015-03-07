import java.util.*;
import java.io.*;

public class ArgumentSeperator{
	private Map<Integer,String> args;
	public ArgumentSeperator(String[] args){
		this.args = new HashMap<Integer,String>();
		int i = 2;
		for(String arg: args){
			if(!arg.equals("-f") && !(arg.indexOf(".txt")>=0)){
				this.args.put(i,arg);
				i = i+1;
			}
			if(arg.equals("-f"))
				this.args.put(0,arg);
			if(arg.indexOf(".txt")>=0)
				this.args.put(1,arg);
		}
	}
	public Map<Integer,String> getArgs(){
		return args;
	}
}