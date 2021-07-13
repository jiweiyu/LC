package leetcode;


//level - 7
public class MaximumNumberOfDartsInsideOfACircularDartboard_1453 {

    public int numPoints(int[][] points, int r) {
        int n = points.length;
        int res = 1;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                double[] a = new double[]{points[i][0], points[i][1]};
                double[] b = new double[]{points[j][0], points[j][1]};
                double[][] centers = findCenters(a, b, r);
                for(double[] center : centers){
                    if(!Double.isNaN(center[0]) && !Double.isNaN(center[1])){
                        int cur = 2;
                        for(int k=0; k<n; k++) if(k!=i && k!=j){
                            if(dist(center, new double[]{points[k][0], points[k][1]})<=r){
                                cur++;
                            }
                        }
                        res = Math.max(res, cur);
                    }
                }
            }
        }
        return res;
    }

    public double[][] findCenters(double[] a, double[] b, double r)
    {
        double[] mid = new double[]{(a[0]+b[0])/2, (a[1]+b[1])/2};
        double[][] res = new double[2][2];
        double opsLen = Math.sqrt(r*r - Math.pow(dist(a, mid), 2));
        double angle = Math.atan2(b[1]-a[1], b[0]-a[0]);
        res[0][0] = mid[0] + opsLen*Math.sin(angle);
        res[0][1] = mid[1] - opsLen*Math.cos(angle);
        res[1][0] = mid[0] - opsLen*Math.sin(angle);
        res[1][1] = mid[1] + opsLen*Math.cos(angle);
        return res;
    }

    public double dist(double[] a, double[] b){
        return Math.sqrt(Math.pow(a[0]-b[0],2) + Math.pow(a[1]-b[1],2));
    }
}
