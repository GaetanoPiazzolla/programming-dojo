package fb.array;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int area =0;
        int start = 0;
        int end = height.length -1;
        while(end > start ){

            int tmpArea = (end-start) * Math.min(height[end],height[start]);
            if(tmpArea>area) {area=tmpArea;}

            if(height[end] < height[start]) {
                end--;
            }
            else {
                start++;
            }

        }

        return area;

    }
}
