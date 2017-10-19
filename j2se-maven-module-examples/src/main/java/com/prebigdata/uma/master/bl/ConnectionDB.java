package com.prebigdata.uma.master.bl;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;


public class ConnectionDB {
    private static MongoClient client = null;
    private static Morphia morphia = null;
    private static Datastore datastore = null;
           
    public static Datastore getDatastore() {
        
        if (datastore == null) {
            
            try {
                
                client = new MongoClient(ConnectionDB.getMongoClientUri());
                morphia = new Morphia();
                datastore = morphia.createDatastore(client, ConnectionDB.getMongoClientUri().getDatabase());
                
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
            
        }
        
        return datastore;
    }
    
    private static MongoClientURI getMongoClientUri() {
        MongoClientURI mongoClientURI = null;
        String databaseHost = "<HOST>";
        String databasePort = "<PORT>";
        
        try {
               
             mongoClientURI = new MongoClientURI("mongodb://"+ databaseHost + ":" + databasePort + "/admin?maxPoolSize=100&minPoolSize=5&maxIdleTimeMS=10000");

        } catch(Exception ex) {
            System.out.println(ex);
        }
        
        return mongoClientURI;
    }
}
