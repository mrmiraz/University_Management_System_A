package com.miraz.universitybackend.services;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import org.bson.Document;
import org.springframework.stereotype.Component;

@Component
public class ChangeStreamListener {

    public void startChangeStream() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString("mongodb+srv://miraz:miraz@cluster0.p7znshz.mongodb.net/university"))
                .build();

        try (MongoClient client = MongoClients.create(settings)) {
            MongoDatabase database = client.getDatabase("university");
            MongoCollection<Document> collection = database.getCollection("admin");

            try (MongoCursor<ChangeStreamDocument<Document>> cursor = collection.watch().iterator()) {
                while (cursor.hasNext()) {
                    ChangeStreamDocument<Document> document = cursor.next();
                    Document modifiedDocument = document.getFullDocument();
                    System.out.print(modifiedDocument);
                    // Process the change event and store the modified data
                    // Perform your logic to store the modified data in your desired storage system
                    // ...
                }
            }
        }
    }
}
