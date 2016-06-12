package net.viralpatel.struts2;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MongoDBJDBC {

   public static void main( String args[] ) {dbcall();}
   public static    List<String>  name(){

	   double ret[][]=new double[8][4];

       List<String> map=new ArrayList<String>();
      
		
	      try{
			
	         // To connect to mongodb server
	         MongoClient mongoClient = new MongoClient( "52.221.231.185" , 27017 );
				
	         // Now connect to your databases
	         DB db = mongoClient.getDB( "barclaycard" );
	         System.out.println("Connect to database successfully");
	         boolean auth = db.authenticate("", new char[2]);
	         System.out.println("Authentication: "+auth);
	         
	         DBCollection coll = db.getCollection("socialscore");
				
	         DBCursor cursor = coll.find();
	         int i = 0;
	         
				
	         while (cursor.hasNext()) { 
	           // System.out.println("Inserted Document: "+i); 
	            DBObject dbo=cursor.next();
	            double is=Double.parseDouble(dbo.get("score")+"");
	            System.out.println(is+"=="+dbo);
	            map.add(dbo.get("name")+"");
	            ret[i][0]=is;
	            i++;
	         }
				
	      }catch(Exception e){
	    	  e.printStackTrace();
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }
	   return map;
   
   }
   
   public static double[][] dbcall(){
	   double ret[][]=new double[4][4];
		
	      try{
			
	         // To connect to mongodb server
	         MongoClient mongoClient = new MongoClient( "52.221.231.185" , 27017 );
				
	         // Now connect to your databases
	         DB db = mongoClient.getDB( "barclaycard" );
	         System.out.println("Connect to database successfully");
	         boolean auth = db.authenticate("", new char[2]);
	         System.out.println("Authentication: "+auth);
	         
	         DBCollection coll = db.getCollection("finscore");
	         DBCollection net = db.getCollection("socialscore");
	         System.out.println("Collection mycol selected successfully");
				
	         DBCursor cursor = coll.find();
	         int i = 0;
	         
	         Map<String,String> map=new HashMap<String, String>();
	        
				
	         while (cursor.hasNext()) { 
	           // System.out.println("Inserted Document: "+i); 
	            DBObject dbo=cursor.next();
	            double is=Double.parseDouble(dbo.get("score")+"");
	            System.out.println(is+"=="+dbo);
	            map.put(dbo.get("name")+"", dbo.get("name")+"");
	            ret[i][0]=is;
	            i++;
	         }
	         cursor = net.find();int index=0;
	         while (cursor.hasNext()) {
	             DBObject dbo=cursor.next();
	             double is=Double.parseDouble(dbo.get("score")+"")*1000;
	             System.out.println(is+"=="+dbo);
	             if(map.get(dbo.get("name")+"")!=null){
	             ret[index++][1]=is;
	             }
	             i++;
	          }
				
	      }catch(Exception e){
	    	  e.printStackTrace();
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      }
	   return ret;
   }
}