package pl.misc.hackerRank.tree;

public class HuffmanDecoding {
	
/*
Sample Input
         {ϕ,5}
      0 /     \ 1
     {ϕ,2}   {A,3}
    0/   \1
{B,1}  {C,1}  
		
S="1001011"
Sample Output
ABACA
	 
	 * */
	public static void main(String... args){
		HuffNode root = new HuffNode(null, 5);
		root.left = new HuffNode(null, 2);
		root.right = new HuffNode('A', 3);
		root.left.left = new HuffNode('B', 1);
		root.left.right = new HuffNode('C', 1);
		decode("1001011",root);
	}
	
	public static void decode(String S ,HuffNode root)
    {
		int i = 0, j = 0;
        HuffNode temp = root;
        char[] dataCollected = new char[S.length()];
        while(i < S.length()){
        	char presentChar = S.charAt(i++);
        	if(presentChar == '0'){
        		temp = temp.left;
        	}
        	else if(presentChar == '1'){
        		temp = temp.right;
        	}
        	if(temp.right == null && temp.left == null){
        		dataCollected[j++] = temp.data;
        		temp = root;
        	}
        }
        
        for(i = 0 ;i<j;i++){
        	System.out.print(dataCollected[i]+" ");
        }
    }
}