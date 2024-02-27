/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package withdrawapplication;
import java.util.Scanner;


class Account {
    private double balance;
    private String ownername;
    private String password;

    public Account(){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name: ");
        ownername = input.nextLine();
        
        System.out.println("Enter a new password: ");
        password = input.nextLine();
        
        System.out.println("Enter balance: ");
        balance = input.nextDouble();
      
     }

    public void add(double amount){
        balance=balance + amount;
        System.out.println("New balance: " + balance);
    }

    public void withdraw() {
        Scanner input = new Scanner(System.in);
        
        int enter = 3;
         
        while(enter != 0){
            
            System.out.println("Enter password: ");
            String key = input.nextLine();
            
            if (key.equals(password)){
                
                System.out.println("Enter amount to withdraw money: ");
                double amount = input.nextDouble();
                
                if (amount<=balance){
                    balance = balance - amount;
                    break;
                } 
                
                else{
                    System.out.println("Insufficient balance.");
                    break;
                    
               }
            } 
            
            else{
                enter--;
                System.out.println("Try again. Attempts left: " + enter);
           }
        }
         
        
        
        if (enter == 0) {
            System.out.println("Account blocked");
        } 
        
        else{
            System.out.println("Amount withdrawn");
            System.out.println("New balance: " + balance);
        }
    }

    public double getBalance(){
        return balance;
    }

    public String getOwnerName(){
        return ownername;
    }

    public void setOwnerName(String name){
        ownername = name;
    }

}

public class Main {

 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account account = new Account();
        
        
        System.out.println("Owner Name: " + account.getOwnerName());
        System.out.println("Balance: $" + account.getBalance());
        

        System.out.println("Type 1 to withdraw type 2 to add.");
        int enter = input.nextInt();
        
        switch(enter){
            case 1:
                account.withdraw(); 
                break;
            case 2:
                System.out.println("Type the amount to add.");
                int amount = input.nextInt();
                account.add(amount);
                break;
            default:
                System.out.println("You have to type 1 or 2.");
        }
        }
    
}
