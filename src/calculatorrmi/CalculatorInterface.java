/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author coldwarrior
 */
public interface CalculatorInterface extends Remote {
    public double magicAdd(double x, double y)throws RemoteException;
    public double magicSubtract(double x, double y)throws RemoteException;
    public int magicFindMin(int x, int y, int z)throws RemoteException;
    public int magicFindMax(int x, int y, int z)throws RemoteException;
    public int getTotalOperations()throws RemoteException;
  
}
