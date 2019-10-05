import java.util.Scanner;
import java.util.Timer;

//默认1为角谷元素，其后角谷运算简化为判断角谷运算过程中出现角谷元素即停止运算
//
public class TestPassNew {
    public static final int l=10000;//测算数值
    public static int[] all =new int[3*l];//角谷元素第一个推导父数
    //    public static int[]
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Scanner cin = new Scanner(System.in);
        //example
        all[1]=2;
        for(int i=2;i<l;i++){
            int a=i;
            while(a!=0){
                all[a]=i;
                a=jiaogu(a);
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("耗时" + duration / 1000000);
        for(int i=2;i<l;i++){
            System.out.printf("%d\t",all[i]);
        }
        System.out.printf("在%d以内的角谷运算中没有出现过",l);
        for(int i=1;i<l;i++){
            if(all[i]==0){
                System.out.printf("%d\t",i);
            }
        }


    }
    //判断是否为角谷元素？不再向下执行：返回下一个值
    public static int jiaogu(int a){
        int rst;
        if(all[a]>0){
            rst=0;
        }else if(a%2==0){
            rst = a/2;
//            System.out.printf("%d/2=%d\n",a,rst);
        }else{
            rst = 3*a+1;
//            System.out.printf("%d*3+1=%d\n",a,rst);
        }
        return rst;
    }
}
