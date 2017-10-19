package com.prebigdata.uma.master.dao;

import com.prebigdata.uma.master.domain.ClientDTO;
import com.prebigdata.uma.master.domain.searcher.ClientSearcherDTO;
import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;


public class ClientDAO {
    
    public void insertClient(ClientDTO clientToInsert, Datastore connectionReference) {
        BasicDAO<ClientDTO, ObjectId> basicDAO;
        
        try {
            basicDAO = new BasicDAO(ClientDTO.class, connectionReference);
            basicDAO.save(clientToInsert);
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    public List<ClientDTO> searchClients(ClientSearcherDTO clientSearcher, 
                                         Datastore connectionReference) throws Exception {
        BasicDAO<ClientDTO, ObjectId> basicDAO;
        Query<ClientDTO> mongoDbQuery = null;
        List<ClientDTO> clientFoundList = null;
        
        try {
            basicDAO = new BasicDAO(ClientDTO.class, connectionReference);
            mongoDbQuery = basicDAO.createQuery();
            
            if (clientSearcher.nameSearchCriteria != null) {
                mongoDbQuery.criteria("name").equalIgnoreCase(clientSearcher.nameSearchCriteria);
            }
            
            if (clientSearcher.idSearchCriteria != null) {
                mongoDbQuery.criteria("_id").equal(clientSearcher.idSearchCriteria);
            }
            
            clientFoundList = basicDAO.find(mongoDbQuery).asList();
            
            if (clientFoundList.isEmpty()) {
                clientFoundList = null;
            }
            
            return clientFoundList;
        } catch(Exception exception) {
            throw exception;
        }
    }
}
