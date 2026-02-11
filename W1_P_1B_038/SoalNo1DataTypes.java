import java.util.Scanner;

class SoalNo1DataTypes{
    public static void main(String [] args) {
        int i;
        Scanner scan = new Scanner(System.in);
        int testcase = scan.nextInt();
        scan.nextLine();
        long[] inputnumber = new long[testcase];
        String[] stringnumber = new String[testcase];
        for (i=0; i<testcase; i++) {
            stringnumber[i] = scan.nextLine();
        }  
        for (i=0; i<testcase; i++){
            try{
                inputnumber[i] = Long.parseLong(stringnumber[i]);
                System.out.println(inputnumber[i] + " can be fitted in:");
                if(inputnumber[i]<=Byte.MAX_VALUE && inputnumber[i]>=Byte.MIN_VALUE){
                    System.out.println(" * byte");        
                }
                if(inputnumber[i]<=Short.MAX_VALUE && inputnumber[i]>=Short.MIN_VALUE){
                    System.out.println(" * short");
                }
                if(inputnumber[i]<=Integer.MAX_VALUE && inputnumber[i]>=Integer.MIN_VALUE ){
                    System.out.println(" * int");
                }
                if(inputnumber[i]<= Long.MAX_VALUE && inputnumber[i] >= Long.MIN_VALUE){
                    System.out.println(" * long");
                }
            }  catch (Exception e){
               System.out.println(stringnumber[i] + " can't be fitted anywhere");
            }
        }
        scan.close();
    }
}
