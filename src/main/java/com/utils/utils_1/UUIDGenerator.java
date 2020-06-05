package com.utils.utils_1;

import java.util.UUID;

public class UUIDGenerator {  
    public UUIDGenerator() {  
    }  
  
    public static String getUUID(boolean noHyphen, int repeat) {  
    	StringBuilder id =new StringBuilder();
    	for (int i = 0; i <repeat ; i++)
        {

          UUID uuid = UUID.randomUUID();
           String segment= uuid.toString().toUpperCase();
           if (noHyphen){
        	   segment =segment.replaceAll("-", "");
           }
          id.append(segment) ;
        }
    	return id.toString();
    }  
   
  
    public static void main(String[] args) {  
        for (int i = 0; i <10; i++) {  
            System.out.println(getUUID(false,1));  
        }  
    }  
}  
