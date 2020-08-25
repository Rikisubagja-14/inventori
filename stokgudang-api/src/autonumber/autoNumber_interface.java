/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autonumber;

import entity.NumberField;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Riki subagja
 */
public interface autoNumber_interface extends Remote {
    String getAutoNumberInt(NumberField field)throws RemoteException;
}
