package pl.misc.hackerank.tree;

public class HuffNode{
	
	public  int frequency; // the frequency of this tree
    public  Character data;
    public  HuffNode left, right;
	
	public HuffNode(){
		
	}
	public HuffNode(Character charData, int frequency) {
		this.data = charData;
		this.frequency = frequency;
	}
	
	public String toString(){
		return String.valueOf(data);
	}

}
