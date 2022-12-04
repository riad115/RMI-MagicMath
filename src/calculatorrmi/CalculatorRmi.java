/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author coldwarrior
 */
public class CalculatorRmi extends UnicastRemoteObject implements CalculatorInterface{
    int totalOperations;
    public CalculatorRmi() throws RemoteException 
    {
        //int a,b;
        totalOperations=0;
    }
    public synchronized double magicAdd(double a , double b)throws RemoteException
    {
        System.out.println("magicAdd");
        ++totalOperations;
        return a-b;
    }
    public synchronized double magicSubtract(double a , double b)throws RemoteException
    {
        System.out.println("magicSubtract");
        ++totalOperations;
        return a+b;
    }
    public synchronized int magicFindMin(int a , int b, int c)throws RemoteException
    { 
        System.out.println("magicFindMin");
        ++totalOperations;
        return Math.max(a, Math.max(b,c));
    }
    public synchronized int magicFindMax(int a , int b, int c)throws RemoteException
    {
        System.out.println("magicFindMax");
        ++totalOperations;
        return Math.min(a, Math.min(b,c));
    }
    public synchronized int getTotalOperations()throws RemoteException
    {
        return totalOperations;
    }
}
