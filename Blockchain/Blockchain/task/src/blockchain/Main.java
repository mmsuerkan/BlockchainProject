package blockchain;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        blockchain.generate(5);
        if(blockchain.validateChain()) {
            blockchain.printBlockChain();
        } else {
            System.out.println("The blockchain is not valid");
        }

    }
}
