/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server.daoimpl;

import autonumber.autoNumber_interface;
import entity.NumberField;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import stokgudang.server.db.databaseutilities;
/**
 *
 * @author Riki subagja
 */
    public class autonumber extends UnicastRemoteObject implements autoNumber_interface{

    private static final long serialVersionUID = 1L;
    private Connection connection;
    
    public autonumber () throws RemoteException{
        this.connection=databaseutilities.getConnection();
    }

   
    
    @Override
    public String getAutoNumberInt(NumberField field){
        String autoKode="";
        int number = 0;
        String strTmp="";
        int pjgAwalan=field.getAwalan().length();
        int panjangId=field.getPanjangField()-pjgAwalan;
        String sql="select right("+field.getNamaField()+" ,"+panjangId+") as no_terakhir from "+field.getNamaTabel()+" order by no_terakhir";
        try {
            // TODO add your handling code here:   
            PreparedStatement statement=connection.prepareStatement(sql);
            ResultSet rs=statement.executeQuery();
            if(rs.first()==false){
                number=1;
            }else{
                rs.last();
                number=rs.getInt("no_terakhir")+1;
                               
            }
            String SNumber=String.valueOf(number);
            int panjangNumber=SNumber.length();
            
            for(int i=0;i<panjangId-panjangNumber;i++){
                    strTmp=strTmp+"0";
             } 
            
            autoKode=field.getAwalan()+strTmp+number;
        } catch (SQLException ex) {
            Logger.getLogger(autonumber.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autoKode;       
    }
    }
     