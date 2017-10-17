package com.prebigdata.uma.master.main;

import com.prebigdata.uma.master.bl.ClientBL;
import com.prebigdata.uma.master.domain.ClientDTO;
import com.prebigdata.uma.master.domain.ClientSearcherDTO;
import java.util.List;


public class Main {
    
    public static void main(String[] args) {
        
    }
    
    public static void printClientFoundListFromDb() throws Exception {
        ClientSearcherDTO clientSearcher;
        ClientBL clientBusinessLogic;
        List<ClientDTO> clientFoundList;
        
        clientSearcher = new ClientSearcherDTO();
        clientBusinessLogic = new ClientBL();
        
        clientSearcher.idSearchCriteria = "3";
        clientFoundList = clientBusinessLogic.searchClients(clientSearcher);
        
        if (clientFoundList != null) {
            clientFoundList.stream().forEach((singleClient) -> {
                System.out.println("Single Client");
                System.out.println("=============");
                System.out.println("Id: " + singleClient.id);
                System.out.println("Name: " + singleClient.name);
                System.out.println("Surname: " + singleClient.surname);
                System.out.println("City: " + singleClient.city);
            });
        }
    }
}
