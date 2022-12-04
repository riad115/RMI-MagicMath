/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class CalculatorRmi extends UnicastRemoteObject implements CalculatorInterface{
    int totalMagicAddOperations;
    int totalMagicSubtractOperations;
    int totalMagicFindMinOperations;
    int totalMagicFindMaxOperations;
    public CalculatorRmi() throws RemoteException 
    {
        //int a,b;
        totalMagicAddOperations=0;
        totalMagicSubtractOperations=0;
        totalMagicFindMinOperations=0;
        totalMagicFindMaxOperations=0;
    }
    public synchronized double magicAdd(double a , double b)throws RemoteException
    {
        System.out.println("magicAdd");
        ++totalMagicAddOperations;
        return a-b;
    }
    public synchronized double magicSubtract(double a , double b)throws RemoteException
    {
        System.out.println("magicSubtract");
        ++totalMagicSubtractOperations;
        return a+b;
    }
    public synchronized int magicFindMin(int a , int b, int c)throws RemoteException
    { 
        System.out.println("magicFindMin");
        ++totalMagicFindMinOperations;
        return Math.max(a, Math.max(b,c));
    }
    public synchronized int magicFindMax(int a , int b, int c)throws RemoteException
    {
        System.out.println("magicFindMax");
        ++totalMagicFindMaxOperations;
        return Math.min(a, Math.min(b,c));
    }
    public synchronized int getTotalMagicAddOperations()throws RemoteException
    {
        return totalMagicAddOperations;
    }

    public synchronized int getTotalMagicSubtractOperations()throws RemoteException
    {
        return totalMagicSubtractOperations;
    }

    public synchronized int getTotalMagicFindMinOperations()throws RemoteException
    {
        return totalMagicFindMinOperations;
    }

    public synchronized int getTotalMagicFindMaxOperations()throws RemoteException
    {
        return totalMagicFindMaxOperations;
    }
}
