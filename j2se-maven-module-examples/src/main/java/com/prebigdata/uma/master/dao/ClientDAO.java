package com.prebigdata.uma.master.dao;

import com.prebigdata.uma.master.domain.ClientDTO;
import com.prebigdata.uma.master.domain.ClientSearcherDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    
    public List<ClientDTO> searchClients(Connection connectionReference,
                                         ClientSearcherDTO searchCriteria) throws SQLException {
        StringBuilder sqlQuery;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        List<ClientDTO> clientFoundList;
        ClientDTO singleClient;
        Integer parameterCount;
        
        try {
            sqlQuery = new StringBuilder();
            clientFoundList = new ArrayList();
            parameterCount = 0;

            sqlQuery.append("SELECT ");
            sqlQuery.append("clientes.dni,");
            sqlQuery.append("clientes.nombre,");
            sqlQuery.append("clientes.apellido,");
            sqlQuery.append("clientes.ciudad");
            
            sqlQuery.append(" FROM ");
            sqlQuery.append("clientes");

            sqlQuery.append(" WHERE ");
            sqlQuery.append("(1=1)");
          
            
            if (searchCriteria.idSearchCriteria != null) {
                sqlQuery.append(" AND (");
                sqlQuery.append("clientes.dni = ?");
                sqlQuery.append(")");
            }
            
            if (searchCriteria.nameSearchCriteria != null) {
                sqlQuery.append(" AND (");
                sqlQuery.append("clientes.nombre = ?");
                sqlQuery.append(")");
            }

            preparedStatement = connectionReference.prepareStatement(sqlQuery.toString());
            
            if (searchCriteria.idSearchCriteria != null) {
                parameterCount++;
                preparedStatement.setString(parameterCount, searchCriteria.idSearchCriteria);
            }
            
            if (searchCriteria.nameSearchCriteria != null) {
                parameterCount++;
                preparedStatement.setString(parameterCount, searchCriteria.nameSearchCriteria);
            }
            
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                singleClient = new ClientDTO();
                
                singleClient.id = resultSet.getString("dni");
                singleClient.name = resultSet.getString("nombre");
                singleClient.surname = resultSet.getString("apellido");
                singleClient.city = resultSet.getString("ciudad");
                
                clientFoundList.add(singleClient);
            }
            
            if (clientFoundList.isEmpty()) {
                clientFoundList = null;
            }
            
            return clientFoundList;
        } catch(SQLException exception) {
            throw exception;
        }
    }
}
