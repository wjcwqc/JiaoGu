import java.util.Scanner;
import java.util.Timer;

//默认1为角谷元素，其后角谷运算简化为判断角谷运算过程中出现角谷元素即停止运算
//
public class TestPassLiehuaban {
    public static final int l=1000;//测算数值
    public static final int max=100000;//角谷步骤最大值
//    public static int[] all =new int[3*max];//角谷元素第一个推导父数
    //    public static int[]
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Scanner cin = new Scanner(System.in);
        int[][] jg=new int[l][max];
        for(int i=1;i<l;i++){
            jg[i][0]=i;
        }
//        all[1]=2;
        //得到角谷父数列和角谷运算数列
        for(int i=2;i<l;i++){
            for (int m=0;;m++){
                jg[i][m + 1] = jiaogu(jg[i][m]);
//                if(all[jg[i][m]]==0) {
//                    all[jg[i][m]] = jg[i][0];
//                }
                if(jg[i][m]==0){
                    break;
                }
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("耗时" + duration / 1000000);
        System.out.printf("在%d以内的角谷运算中没有出现过",l);
//        for(int i=2;i<l;i++){
//            System.out.printf("%d\t",all[i]);
//        }

        //格式化输出角谷运算数列
        for(int i=1;i<l;i++){
            System.out.printf("%d\n",jg[i][0]);
            for(int m=1;m<max;m++){
                if(jg[i][m]==0)break;
                System.out.printf("%d\t",jg[i][m]);
            }
            System.out.println();
        }
//        for(int i=1;i<l;i++){
//            if(all[i]==0){
//                System.out.printf("%d\t",i);
//            }
//        }
    }
    //判断是否为角谷元素？不再向下执行：返回下一个值
    public static int jiaogu(int a){
        int rst=0;
        if(a%2==0){
            rst = a/2;
//            System.out.printf("%d/2=%d\n",a,rst);
        }else if(a!=1){
            rst = 3*a+1;
//            System.out.printf("%d*3+1=%d\n",a,rst);
        }
        return rst;
    }
}
