package action;

import java.util.Date;

public class blockchain {
	
	public String hash;
	public String previousHash; 
	private String data; 
	private long timeStamp;
	private int nonce;
	
	//Block Constructor.  
	public blockchain(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		
		this.hash = calculateHash();
	}
	
	
	public String getHash() {
		return hash;
	}


	public void setHash(String hash) {
		this.hash = hash;
	}


	public String getPreviousHash() {
		return previousHash;
	}


	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public long getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}


	public int getNonce() {
		return nonce;
	}


	public void setNonce(int nonce) {
		this.nonce = nonce;
	}


	//Calculate new hash based on blocks contents
	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				Integer.toString(nonce) + 
				data 
				);
		return calculatedhash;
	}
	

	public void mineBlock(int difficulty) {
		String target = StringUtil.getDificultyString(difficulty); 
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
	
}