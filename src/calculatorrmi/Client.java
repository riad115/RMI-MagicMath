package calculatorrmi;

import java.rmi.Naming;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author coldwarrior
 */
public class Client implements Runnable{
    private CalculatorInterface calcIface;
    private String clientName;

    protected Client(CalculatorInterface cInterface, String clName){
        this.calcIface = cInterface;
        this.clientName = clName;
    }

    public void run(){
        System.out.println(clientName+" is connected to server");
        for(int i=0;i<10;++i){
            //Scanner sc = new Scanner(System.in);
            Random random = new Random();
            int max_ch=4;
            int min_ch=1;
            int choice = random.nextInt(max_ch - min_ch+1)+min_ch;
            
            switch (choice)
            {
                case 1:
                {
                    //System.out.println("Result magicAdd");
                    double x=random.nextDouble();
                    double y=random.nextDouble();
                    System.out.println("Result magicAdd=> x: "+x+" y: "+y);
                    try {
                        System.out.println(calcIface.magicAdd(x, y));
                    } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                }
                case 2:
                {
                    //System.out.println("Result magicSubtract");
                    double x=random.nextDouble();
                    double y=random.nextDouble();
                    System.out.println("Result magicSubtract=> x: "+x+" y: "+y);
                    try {
                        System.out.println(calcIface.magicSubtract(x, y));
                    } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                }
                case 3:
                {
                    int x= random.nextInt();
                    int y= random.nextInt();
                    int z = random.nextInt();
                    System.out.println("Result magicFindMin=> x: "+x+" y: "+y+" z: "+z);
                    try {
                        System.out.println(calcIface.magicFindMin(x, y, z));
                    } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                }
                case 4:
                {
                    //System.out.println("Result magicFindMax");
                    int x= random.nextInt();
                    int y= random.nextInt();
                    int z = random.nextInt();
                    System.out.println("Result magicFindMax=> x: "+x+" y: "+y+" z: "+z);
                    try {
                        System.out.println(calcIface.magicFindMax(x, y, z));
                    } catch (RemoteException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                }
                default:
                    System.out.println("Error: Invalid operator!");
                    break;
                
            }
            //sc.close();
        }
        
        try {
            System.out.println(clientName+ ": Total Operations Performed by Server "+calcIface.getTotalOperations());
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(clientName+" is finished");
    }

    public static void main(String[] args)throws NotBoundException,MalformedURLException,RemoteException{
        
        
        try {
            CalculatorInterface c = (CalculatorInterface)Naming.lookup("rmi://localhost:1099/Calculator");
            new Thread(new Client(c, "Client1")).start();
            new Thread(new Client(c, "Client2")).start();
        } catch (Exception e) {
        }
        
    }
}
