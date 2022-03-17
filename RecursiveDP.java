import java.math.BigInteger;

public class RecursiveDP {

    private static BigInteger fibMemoize(int fill, BigInteger[] memoize){
        BigInteger fibo;
        if(memoize[fill]== BigInteger.valueOf(0)){
            return memoize[fill];
        }
        if(fill==1 || fill==2){
            fibo = BigInteger.valueOf(1);
        }else{
            fibo = fibMemoize(fill-1, memoize).add(fibMemoize(fill-2, memoize));
        }
        memoize[fill]= (BigInteger) fibo;
        return fibo;
    }

    private static BigInteger fib_dynamic(int n){
        BigInteger[] fibDP = new BigInteger[n+1];
        fibDP[1] = BigInteger.ONE;
        fibDP[2] = BigInteger.ONE;
        if(n==1 || n==2){
            return BigInteger.ONE;
        }
        for(int i = 3;i<n+1;i++){
            fibDP[i] = fibDP[i-1].add(fibDP[i-2]);
        }
        return fibDP[n];
    }

    private static int fib_recur(int n){
        int fibo = 0;
        if(n==1 || n==2){
            fibo=1;
        }else{
            fibo = fib_recur(n-1)+fib_recur(n-2);
        }
        return fibo;
    }
    public static void main(String[] args) {
        //fibonacci n=5 1,1,2,3,5,8,13,21
        int first=1;
        int second=1;
        int n=5;
        int fibo=0;
        int last=0;
        int current=0;
        if (n==1 || n==2){
            fibo=1;
        }else{
            for(int i=1;i<=n;i++){
                if(i==1 || i==2){
                    fibo=1;
                    last=first;
                    current = second;
                }else{
                    //last=current;
                    fibo = last + current;
                    last=current;
                    current=fibo;
                }
            }
        }
        System.out.println("raw code = " +fibo);

        //calling recursive fibonacci
        int s = fib_recur(280);
        System.out.println("recursive is = " + s);

        //calling dynamic with memoize
        int fill=280;
        BigInteger[] dpmemo = new BigInteger[fill+1];
        BigInteger resultMemo = fibMemoize(fill, dpmemo);
        System.out.println("memoize is = "+resultMemo);

        //calling dynamic bottom up
        BigInteger a = fib_dynamic(280);
        System.out.println("dynamic bottom-up is =  " + a);
    }
}

