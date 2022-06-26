package temp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    boolean flag = false;
    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy3(19));
    }
    //超时，超栈
    public boolean isHappy1(int n) {
        List list = new ArrayList();

        calcultation(n,list,this.flag);
        return this.flag;
    }
    public void calcultation(int n,List list,boolean flag) {

        if(n==1) {
            flag = true;
        }
        if(list.contains(n)) flag = false;
        if (flag ==true) {
            return;
        }
        int sum = 0;
        while(n>=1) {
            sum+=Math.pow(n%10,2);
            n/=10;
        }
//        System.out.println(sum);
        list.add(sum);
        calcultation(sum,list,flag);
        flag = false;
    }


    //不知道哪里出问题了
    public boolean isHappy2(int n) {
        Set set = new HashSet();
        while(n!=1&&set.contains(n)) {
            set.add(n);
            n = ppap(n);
        }
        return n==1;
    }
    public int ppap(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        System.out.println("sum:"+sum);
        return sum;
    }
    public boolean isHappy3(int n) {
        int fast = n;
        int slow = n;
        slow = ppap(slow);
        fast = ppap(fast);
        fast = ppap(fast);

        while(fast!=slow) {
            slow = ppap(slow);
            fast = ppap(fast);
            fast = ppap(fast);
        }

        return slow==1;
    }

}
