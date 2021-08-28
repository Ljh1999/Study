import org.junit.jupiter.api.Test;

@SuppressWarnings({"all"})
public class demo {
    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 100; i++) {
//           System.out.print(i + "%" + "\r");
//            Thread.sleep(1000);
//        }
//        A a1 = new A();
//        a1.name="bbb";
//        a1.job = "c#";
//        System.out.println(a1.name);
//        System.out.println(a1.job);
//        A a2 = new A();
//        a2.job="c++";
//        System.out.println(a2.name);
//        System.out.println(a2.job);
//        a1.tee("c++");

//        System.out.println("=============算术右移 >> ===========");
//        int i=10;
//        System.out.println("移位前：i= "+i+" = "+Integer.toBinaryString(i)+"(B)");
//        i=i>>1;
//        System.out.println("移位后：i= "+i+" = "+Integer.toBinaryString(i)+"(B)");
//         int nums[] = {1,2,3,4,5,6,7};
//         int k = 3;
//         rotate(nums,k);
    }
    @Test
    public static void rotate(int nums[], int k) {
        int length = nums.length;
        int temp[] = new int[length];
        //把原数组值放到一个临时数组中，
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }
    //整数反转
//    public static int reverse(int x) {
//        String substring=null;
//        String zz=null;
//        if(x<0) {
//            String s = String.valueOf(x);
//            substring = s.substring(1);
//            char[] c = substring.toCharArray();
//            char[] res = new char[c.length];
//            for (int i = 0, j = c.length - 1; j >= 0; i++, j--) {
//                res[i] = c[j];
//            }
//            String result = String.valueOf(res);
//            StringBuilder stringBuilder = new StringBuilder(result);
//            StringBuilder insert = stringBuilder.insert(0, '-');
//            zz = new String(insert);
//            int z = Integer.parseInt(zz);
//            return z;
//        }else {
//            String s = String.valueOf(x);
//            char[] c = s.toCharArray();
//            char[] res = new char[c.length];
//            for (int i = 0, j = c.length - 1; j >= 0; i++, j--) {
//                res[i] = c[j];
//            }
//            String result = String.valueOf(res);
//            int z = Integer.parseInt(result);
//            return z;
//        }
//    }
}
class A{
    private int name ;
    public static int job = 0;


    public static void tee(String job){
        System.out.println(job);
        System.out.println();
    }
}