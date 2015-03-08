package com.Path;

import java.util.HashMap;
import java.util.Map;

public class ArgumentSeperator{
	private Map<Integer,String> args;
	public ArgumentSeperator(String[] args){
		this.args = new HashMap<Integer,String>();
		int i = 4;
		for(String arg: args){
			if(arg.equals("-f"))
				this.args.put(0,arg);
			if(arg.indexOf(".txt")>=0 && !this.args.containsKey(1)) 
           		this.args.put(1,arg);
			if(arg.equals("-c"))
				this.args.put(2,arg);
			if(arg.indexOf(".txt")>=0 && this.args.containsKey(1))
				this.args.put(3,arg);
			if(!arg.equals("-f") && !(arg.indexOf(".txt")>=0) && !arg.equals("-c")){
				this.args.put(i,arg);
				i = i+1;
			}
		}
	}
	public Map<Integer,String> getArgs(){
        return args;
	}
}