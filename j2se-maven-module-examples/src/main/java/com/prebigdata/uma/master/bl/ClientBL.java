package com.prebigdata.uma.master.bl;

import com.prebigdata.uma.master.dao.ClientDAO;
import com.prebigdata.uma.master.domain.ClientDTO;
import com.prebigdata.uma.master.domain.ClientSearcherDTO;
import java.sql.Connection;
import java.util.List;

public class ClientBL {
    
    public List<ClientDTO> searchClients(ClientSearcherDTO searchCriteria) throws Exception {
        ClientDAO clientDAO;
        Connection connectionReference = null;
        
        try {
            clientDAO = new ClientDAO();
            connectionReference = ConnectionDB.getConnection();
            
            return clientDAO.searchClients(connectionReference, searchCriteria);
            
        } catch(Exception exception) {
            throw exception;
        } finally {
            ConnectionDB.closeConnection(connectionReference);
        }
    }
}
