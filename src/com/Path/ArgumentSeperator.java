package com.Path;

import java.util.HashMap;
import java.util.Map;

public class ArgumentSeperator{
    public static  Map<Integer,String> getArgs(String[] args){
        Map<Integer,String> seperatedArgs= new HashMap<Integer,String>();
        int i = 5;
        for(String arg: args){
            if(arg.equals("-f"))
                seperatedArgs.put(0,arg);
            if(arg.indexOf(".txt")>=0 && !seperatedArgs.containsKey(1))
                seperatedArgs.put(1,arg);
            if(arg.equals("-c"))
                seperatedArgs.put(2,arg);
            if(arg.indexOf(".txt")>=0 && seperatedArgs.containsKey(1))
                seperatedArgs.put(3,arg);
            if(arg.equals("-a"))
                seperatedArgs.put(4,arg);
            if(!arg.equals("-f") && !(arg.indexOf(".txt")>=0) && !arg.equals("-c") && !arg.equals("-a") && i<=6){
                seperatedArgs.put(i,arg);
                i = i+1;
            }
        }
        return seperatedArgs;
	}
}