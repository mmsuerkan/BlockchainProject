package blockchain;

import java.util.LinkedList;

public class Blockchain {

    private LinkedList<Block> blockchain;

    public Blockchain() {
        this.blockchain = new LinkedList<>();
    }

    public void generateNextBlock() {
        Block block = new Block(getLatestBlock().getHash());
        blockchain.add(block);
    }
    private Block getLatestBlock() {
        if(blockchain.size() == 0) {
            Block block = new Block("0");
            blockchain.add(block);
        }
        return blockchain.getLast();
    }

    public boolean validateChain() {
        for (int i = 1; i < blockchain.size(); i++) {
            if (!blockchain.get(i).getPreviousHash().equals(blockchain.get(i - 1).getHash())) {
                return false;
            }
        }
        return true;
    }
    public void generate(int numberOfBlock) {


        for (int i = 1; i < numberOfBlock; i++) {
            generateNextBlock();
        }
    }
    public void printBlockChain() {
        for (Block block : blockchain) {
            System.out.println(block);
        }
    }
}
