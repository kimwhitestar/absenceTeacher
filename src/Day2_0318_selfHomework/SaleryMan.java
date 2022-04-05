package Day2_0318_selfHomework;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

public class SaleryMan<T1, T2, T3, T4, T5> implements Cloneable {
  //Object
  //short
  //시스템 키보드 값
  //배열값(clone, System.copy, Arrays.copy)
  //Set객체
  T1 netpay;
  T2 age;
  T3 sysValue;
  T4 habit;
  T5 custom;
  public SaleryMan() {}
  public SaleryMan(T1 netpay, T2 age, T3 sysValue, T4 habit, T5 custom) {
    this.netpay = netpay;
    this.age = age;
    this.sysValue = sysValue;
    this.habit = habit;
    this.custom = custom;
  }
  //###############################################
  // 멤버변수.hashCode() : 해시코드값 가져옴
  //###############################################
//  @Override
//  public int hashCode() {
//    System.out.println("##### netpay.hashCode() = " + netpay.hashCode());
//    return this.netpay.hashCode();
//  }
  //###############################################
  // Objects.hash();
  //###############################################
  @Override
  public int hashCode() {
    return Objects.hash(habit);
  }
  public T1 getNetpay() {
    return netpay;
  }
  public void setNetpay(T1 netpay) {
    this.netpay = netpay;
  }
  public T2 getAge() {
    return age;
  }
  public void setAge(T2 age) {
    this.age = age;
  }
  public T3 getSysValue() {
    return sysValue;
  }
  public void setSysValue(T3 sysValue) {
    this.sysValue = sysValue;
  }
  public T4 getHabit() {
    return habit;
  }
  public void setHabit(T4 habit) {
    this.habit = habit;
  }
  public T5 getCustom() {
    return custom;
  }
  public void setCustom(T5 custom) {
    this.custom = custom;
  }
  
  //clone()으로 this clone 후,
  //별도로 deep clone 추가 필요
  //deep clone : Arrays.copyOf(salaryMan.getHabit(), salaryMan.getHabit().length);
  @Override
  protected SaleryMan<T1, T2, T3, T4, T5> clone() throws CloneNotSupportedException {
    //clone()실행하려면, generic class라도 down casting해서 thin clone객체획득함 
    SaleryMan<T1, T2, T3, T4, T5> salaryMan = 
        (SaleryMan<T1, T2, T3, T4, T5>)super.clone();//thin clone 후 down dasting
    return salaryMan;
  }
}