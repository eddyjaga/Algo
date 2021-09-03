//https://leetcode.com/problems/erect-the-fence/
class Solution {
    
    
    
    public int[][] outerTrees(int[][] trees) {
        
        int[][] result = null;
        // if the trees less then 4 coordinates it will the fence perimeter 
        if(trees.length < 4) return trees;
        
        HashSet<int[]> list = new HashSet<> ();
        
        int leftTree = 0;
        
        // find the tree on the far left
        for (int i=0; i< trees.length; i++){
            if(trees[i][0]<trees[leftTree][0]){
                leftTree = i;
            }
        }
        
        // start point
        int a = leftTree;
        
        do{
            
            list.add(trees[a]);
            
            int b = (a+1) % trees.length;
            
            //find b which is the most counterclock point from a
            for(int i = 0; i < trees.length; i++){
                if(checkOrient(trees[a], trees[i], trees[b]) == 1){
                    b = i;
                }
            }
            
            System.out.println("a is " + Arrays.toString(trees[a]));
            System.out.println("b is " + Arrays.toString(trees[b]));
            
            //add any trees directly between a and b
            
            for(int i = 0; i < trees.length; i++){
                if(i != a && i != b && checkOrient(trees[a], trees[i], trees[b]) == 0 && checkBetween(trees[a], trees[b], trees[i])){
                    list.add(trees[i]);
                }
            }
            a = b;
            
        }while(a != leftTree);
        
        System.out.println(list.size());
        
        
        return list.toArray(new int[list.size()][]);
        
    }
    
    /**
    * The checkBetween method check c coordinate is between a and b
    * @param a(x,y) b(x,y) c(x,y) points
    * @return true or false
    */
    public boolean checkBetween(int[] a, int[] b, int[] c){
        return c[0] >= Math.min(a[0], b[0]) && c[0] <= Math.max(a[0], b[0]) && c[1] >= Math.min(a[1], b[1]) && c[1] <= Math.max(a[1], b[1]);
    }
    
    
    /**
    * The checkOrient method check clickwise, counter-clickwise and collinear
    * @param a(x,y) b(x,y) c(x,y) points
    * @return -1 clickwise, 1 counter-clickwise, 0 collinear
    */
    public int checkOrient(int[] a, int[] b, int[] c){
        
        float area = (b[1] - a[1]) * (c[0] - b[0]) - (b[0] - a[0]) * (c[1] - b[1]); 
        
        if(area < 0) return -1; // clockwise
        if(area > 0) return 1; //counter-clockwise
        return 0; // collinear
        
    }
}