/*
 * static block 
 * -멤버필드 초기화
 */
package Day1_0316_selfHomework;

import java.math.BigInteger;

public class StaticBlockTest {
  //래퍼클래스((Object)Charactor, (Object)((Number)Integer) ..)
  private static Character memberFiled1;
  private static Integer memberFiled8;
  //기본클래스
  private static short memberFiled2;
  private static char memberFiled3;
  private static String memberFiled4;
  private static byte memberFiledZ;
  //(Object)Number클래스(BigInteger, Integer ..) 상속
  private static BigInteger memberFiled5;
  private BigInteger memberFiled9;
  
  //static block에서 멤버필드 초기화
  //static block은 멤버필드 밑에 선언필요, static bolok내 순서대로 실행됨
  //static block 밑에 static method() 선언, 실행됨
  static {
    //memberFiled9 = new BigInteger("9");//non-static멤버변수 사용안됨
    //this.memberFiled5;//this()키워드 사용안됨
    
    //static method()실행
    System.out.println(staticMethod());
    
    //static block에서 멤버필드 초기화
    //byte 
    memberFiledZ = '8';
    memberFiledZ = 'O';
    //memberFiledZ = '한';//Error
    memberFiledZ = 99;//
    
    //short
    memberFiled2 = '8';
    memberFiled2 = 'O';
    //memberFiled2 = '한';//Error
    memberFiled2 = 9999;
    
    //Charactor
    memberFiled1 = '8';
    memberFiled1 = 'O';
    memberFiled1 = '한';
    memberFiled1 = 9999;
    
    //char
    memberFiled3 = '8';
    memberFiled3 = 'O';
    memberFiled3 = '한';
    memberFiled3 = 9999;
    
    //Integer
    memberFiled8 = 999999999;//9억,전화(0)+9자리
    System.out.println("memberFiled8=" + (Object)((Number)memberFiled8));
    System.out.println(String.format("%,d", memberFiled8));
    System.out.println(String.format("%03d-%3d-%4d", (Integer)10, (Integer)1234, (Integer)9999));
    System.out.println(String.format("%03d-%3d-%4d\n", Integer.valueOf(10), Integer.valueOf(1234), Integer.valueOf(9999)));

    //BigInteger
    memberFiled5 = new BigInteger("10000000000000000");//연산자비교어려움,1000조 이상,핸드폰(0)+10자리
    System.out.println("memberFiled5=" + (Object)((Number)memberFiled5));
    System.out.println(String.format("%,d", memberFiled5));
    memberFiled5 = new BigInteger("1012340001");//연산자비교어려움,1000조 이상,핸드폰(0)+10자리
    String str = memberFiled5.toString();
    StringBuffer strBuff = new StringBuffer("");
    strBuff.append("0" + str.substring(0, 2)).append("-")
    .append(str.substring(2, 6)).append("-")
    .append(str.substring(6, 10));
    System.out.println(strBuff);
  }
  //static method
  public static String staticMethod() {
    return "staticMethod()";
  }
  
  public static void main(String[] args) {
  }
}
