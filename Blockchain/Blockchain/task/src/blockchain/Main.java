package blockchain;

public class Main {
    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        blockchain.generate(5);
        blockchain.printBlockChain();
    }
}
