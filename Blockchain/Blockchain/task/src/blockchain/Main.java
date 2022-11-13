package blockchain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter how many zeros the hash must start with: ");
        int numberOfZeros = keyboard.nextInt();
        System.out.println();
        Blockchain blockchain = new Blockchain(numberOfZeros);
        blockchain.generate(5);
        if(blockchain.validateChain()) {
            blockchain.printBlockChain();
        } else {
            System.out.println("The blockchain is not valid");
        }

    }
}
