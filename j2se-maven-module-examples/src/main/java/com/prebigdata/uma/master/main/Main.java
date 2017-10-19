package com.prebigdata.uma.master.main;

import com.prebigdata.uma.master.bl.ClientBL;
import com.prebigdata.uma.master.domain.ClientDTO;
import com.prebigdata.uma.master.domain.searcher.ClientSearcherDTO;
import java.util.List;


public class Main {
    
    public static void main(String[] args) throws Exception {
        
    }
    
    public static void insertClient() throws Exception {
        ClientDTO singleClient = new ClientDTO();
        ClientBL clientBL = new ClientBL();
        
        singleClient.name = "Tomy";
        singleClient.surname = "Ortega";
        singleClient.city = "Malaga";
        
        clientBL.insertClient(singleClient);
    }
    
    public static void searchClients () throws Exception {
        ClientBL clientBL = new ClientBL();
        ClientSearcherDTO clientSearcher = new ClientSearcherDTO();
        List<ClientDTO> clientListFound = null;
        
        clientSearcher.nameSearchCriteria = "Tomy";
                
        clientListFound = clientBL.searchClients(clientSearcher);
        
        if (clientListFound != null) {
            clientListFound.stream().forEach((currentClient) -> {
                System.out.println("Client");
                System.out.println("======");
                System.out.println("ID: " + currentClient.id);
                System.out.println("NAME: " + currentClient.name);
                System.out.println("SURNAME: " + currentClient.surname);
                System.out.println("CITY: " + currentClient.city);
            });
        } else {
            System.out.println("No Records Found!");
        }
    }
}
