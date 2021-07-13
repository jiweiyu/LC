package leetcode;

public class FloodFill_733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0 || image[0].length==0 || image[sr][sc] == newColor) return image;
        fill(image,sr,sc,image[sr][sc],newColor);
        return image;
    }


    private void fill(int[][] image, int r, int c, int oldColor, int newColor){
        if(r<0||r>=image.length||c<0||c>=image[0].length||image[r][c]!=oldColor) return;
        image[r][c] = newColor;
        System.out.println(r);
        fill(image,r+1,c,oldColor,newColor);
        fill(image,r-1,c,oldColor,newColor);
        fill(image,r,c+1,oldColor,newColor);
        fill(image,r,c-1,oldColor,newColor);
    }
}
