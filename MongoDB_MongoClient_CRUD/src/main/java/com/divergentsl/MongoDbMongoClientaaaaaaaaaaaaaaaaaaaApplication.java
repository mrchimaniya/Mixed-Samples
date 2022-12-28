package com.divergentsl;

import java.util.Iterator;

import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

@SpringBootApplication
public class MongoDbMongoClientaaaaaaaaaaaaaaaaaaaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbMongoClientaaaaaaaaaaaaaaaaaaaApplication.class, args);
		System.out.println("****************************************************************************");
		
		
		        // Creating a Mongo client 
				MongoClient mongoClient = new MongoClient( "localhost" , 27017 ); 
				System.out.println("Created Mongo Connection successfully");
				
				MongoDatabase db = mongoClient.getDatabase("youtube");
				System.out.println("Get database is successful");
				
				//creating collection or get collection if exists.
				MongoCollection<Document>  collection= db.getCollection("channels");
				System.out.println("collection created ");
				
				//Inserting sample records by creating documents.
				
				
//				  Document doc =new Document("name","SimplifyingTech");
//				  doc.append("id",101);
//				  doc.append("Subscribers",100);
//				  doc.append("Genre", "Programming");
//				  collection.insertOne(doc);
//				  System.out.println("Insert 1 is completed");
//				  
//				  Document doc2 =new Document("name","CarryMinati");
//				  doc2.append("id",102);
//				  doc2.append("Subscribers",24000000);
//				  doc2.append("Genre", "Comedy");
//				  collection.insertOne(doc2);
//				  System.out.println("Insert 2 is completed");
				 
				 
				 
				
				//Listing All Mongo Documents in Collection
//				FindIterable<Document> iterDoc = collection.find();
//				int i = 1;
//				// Getting the iterator
//				System.out.println("Listing All Mongo Documents");
//				Iterator it = iterDoc.iterator();
//				while (it.hasNext()) {
//				    System.out.println(it.next());
//				    i++;
//				}
				

				
				//specific document retrieving in a collection
//				BasicDBObject searchQuery = new BasicDBObject();
//				searchQuery.put("name", "CarryMinati");
//				System.out.println("Retrieving specific Mongo Document");
//				FindIterable<Document> iterDoc = collection.find(searchQuery);
//				MongoCursor<Document> iterator = iterDoc.iterator();
//				while (iterator.hasNext()) {
//				    System.out.println(iterator.next());
//				}
				
				
				
				//update records
//			   FindIterable<Document> iterDoc = collection.find();
//			   collection.updateOne(Filters.eq("name", "SimplifyingTech"), Updates.set("Genre", "Coding_Updated"));
//			   System.out.println("Document updated successfully...");
//			   int j = 1; 
//			   // Getting the iterator
//			   Iterator<Document> itrNew = iterDoc.iterator();
//			   System.out.println("Document after update...");
//			   while (itrNew.hasNext())
//			   {
//			    System.out.println(itrNew.next()); 
//			    j++;
//			   }
				 
				
//			  FindIterable<Document> iterDoc = collection.find();
//			  collection.deleteOne(Filters.eq("name", "SimplifyingTech"));
//			  System.out.println("Document deleted successfully...");
//			  int k = 1; // Getting the iterator
//			  Iterator<Document> it3 = iterDoc.iterator();
//			  while (it3.hasNext())
//			  {
//				  System.out.println(it3.next());
//			      k++;
//			  }
				 
				
			  // Dropping a Collection 
//			  collection.drop(); 
//			  System.out.println("Collection dropped successfully");		
	}

}
