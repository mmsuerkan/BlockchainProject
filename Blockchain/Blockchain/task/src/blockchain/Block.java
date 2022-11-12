package blockchain;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Block {
    private Integer id;
    private long timestamp;
    private String previousHash;
    private String hash;

    private static final AtomicInteger counter = new AtomicInteger(0);

    public Block(String previousHash) {
        this.id = counter.incrementAndGet();
        this.timestamp = new Date().getTime();
        this.previousHash = previousHash;
        this.hash = calculateHash();
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
                "Hash of the previous block: " + "\n" + previousHash + "\n" +
                "Hash of the block: " + "\n" + hash + "\n";
    }

    public String calculateHash() {
        String block = id + timestamp + previousHash + hash;
        return StringUtil.applySha256(block);
    }
}
