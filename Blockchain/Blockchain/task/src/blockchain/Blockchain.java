package blockchain;

import java.util.LinkedList;

public class Blockchain {

    private LinkedList<Block> blockchain;
    private int numberOfZeros;

    public Blockchain(int numberOfZeros) {
        this.blockchain = new LinkedList<>();
        this.numberOfZeros = numberOfZeros;
    }

    public void generateNextBlock() {
        Block block = new Block(getLatestBlock().getHash(), numberOfZeros);
        blockchain.add(block);
    }
    private Block getLatestBlock() {
        if(blockchain.isEmpty()) {
            Block block = new Block("0", numberOfZeros);
            blockchain.add(block);
        }
        return blockchain.getLast();
    }

    public LinkedList<Block> getBlockchain() {
        return blockchain;
    }

    public boolean validateChain() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
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
