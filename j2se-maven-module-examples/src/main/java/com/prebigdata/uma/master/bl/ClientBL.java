package com.prebigdata.uma.master.bl;

import com.prebigdata.uma.master.dao.ClientDAO;
import com.prebigdata.uma.master.domain.ClientDTO;
import com.prebigdata.uma.master.domain.searcher.ClientSearcherDTO;
import java.util.List;

public class ClientBL {
    
    public List<ClientDTO> searchClients(ClientSearcherDTO clientSearcher) throws Exception {
        ClientDAO clientDAO;
        
        try {
            clientDAO = new ClientDAO();
            
            return clientDAO.searchClients(clientSearcher, ConnectionDB.getDatastore());
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    public void insertClient(ClientDTO singleClient) throws Exception {
        ClientDAO clientDAO;
        
        try {
            clientDAO = new ClientDAO();
            
            clientDAO.insertClient(singleClient, ConnectionDB.getDatastore());
        } catch(Exception exception) {
            throw exception;
        }
    }
}
