/* 복습 */
package Day1_0316_selfHomework;

import java.math.BigInteger;

public class SingletonTest {
  public static void main(String[] args) {
    //Member<타입명시>로 generic
    Member<BigInteger> member = Member.getInstance();//new Member<>()로 생성한 것을
    member.setValue1("Value1");//Object
    member.setValue2(12345.123);
    member.setValue3(new BigInteger("123456789123456789"));
    member.setValue4("Value4");//String
    member.setValue5(new BigInteger("999999999999999999"));//T
    System.out.println((String)member.getValue1());//generic
    System.out.println(member.getValue2());
    System.out.println(member.getValue3());
    System.out.println(member.getValue4());
    System.out.println((BigInteger)member.getValue5());//generic
  }
}

//접근지시자private,protected,public 사용안됨
class Member<T> {
  //인스턴스 생성 금지
  private static final Member member = new Member<>();
  private Object value1;
  private double value2;
  private BigInteger value3;
  private String value4;
  private T value5;
  //생성자 접근 금지
  private Member() {
    //default생성자와는 다르며, 
    //direct Constructor선언시 default Constructor도 존재하지않음.
    //member = new Member();
  }
  //Singletone지침대로, getInstance()메소드를 통해 
  //member객체생성없이 member객체획득 제공
  public static Member getInstance() {
    return member;
  }
  public void setValue1(Object value1) {
    this.value1 = value1;
  }
  public void setValue2(double value2) {
    this.value2 = value2;
  }
  public void setValue3(BigInteger value3) {
    this.value3 = value3;
  }
  public void setValue4(String value4) {
    this.value4 = value4;
  }
  public void setValue5(T value5) {
    this.value5 = value5;
  }
  public Object getValue1() { return value1; }
  public double getValue2() { return value2; }
  public BigInteger getValue3() { return value3; }
  public String getValue4() { return value4; }
  public T getValue5() { return value5; }
}