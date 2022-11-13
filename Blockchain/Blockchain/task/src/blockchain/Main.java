package blockchain;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.print("Enter how many zeros the hash must start with: ");
        final var zeros = new Scanner(System.in).nextInt();
        System.out.println();
        if(new File("./Database.txt").exists()){
            final var blockchain = SerializationUtil.deserialize("./Database.txt");
        }
        final var blockchain = Blockchain.getInstance(zeros);
        blockchain.generateBlocks(5);
        System.out.println(blockchain);
    }
}
