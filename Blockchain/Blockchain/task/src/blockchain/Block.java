package blockchain;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Block {
    private Integer id;
    private long timestamp;
    private String previousHash;
    private String hash;

    private int magicNumber;

    private static final AtomicInteger counter = new AtomicInteger(0);

    public Block(String previousHash,int numberOfZeros) {
        this.id = counter.incrementAndGet();
        this.magicNumber = generateMagicNumber();
        this.timestamp = new Date().getTime();
        this.previousHash = previousHash;
        this.hash = calculateHash(numberOfZeros);
    }

    private int generateMagicNumber() {
        return new Random().nextInt();
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Block:" + "\n" +
                "Id: " + id + "\n" +
                "Timestamp: " + timestamp + "\n" +
                "Magic number: " + magicNumber + "\n" +
                "Hash of the previous block: " + "\n" + previousHash + "\n" +
                "Hash of the block: " + "\n" + hash + "\n" +
                "Block was generating for " + (new Date().getTime() - timestamp) / 1000 + " seconds" + "\n";
    }

    public String calculateHash(int numberOfZeros) {
        StringBuilder zeros = new StringBuilder();

        for (int i = 0; i < numberOfZeros; i++) {
            zeros.append("0");
        }
        String block = id + timestamp + previousHash;
        return zeros.toString() + StringUtil.applySha256(block).substring(numberOfZeros);
    }
}
