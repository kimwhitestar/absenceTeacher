package Day2_0318_selfHomework;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashcodeTest {
  private static SaleryMan<BigInteger, Short, String, Object, Set> p1 = null;
  private static SaleryMan<BigInteger, Short, String, Object, Set> p2 = null;
  private static SaleryMan<BigInteger, Short, String, Object, Set> clonedP1 = null;
  private static SaleryMan<BigInteger, Short, String, Object, Set> clonedP2 = null;
  
  static {
    p1 = new SaleryMan<>();
    p2 = new SaleryMan<>();

    //Object
    //short
    //시스템 키보드 값
    //배열값(clone, System.copy, Arrays.copy)
    //Set객체
    Object obj1 = new BigInteger("100000000000000000");//1000조이상
    Object obj3 = new BigInteger("300000000000000000");
    short s1 = 30;
    int s2 = 21;
    String key1 = "121";//System.in.read()//Ctrl:17, y:121, f=102
    String key2 = "17";
    long[] arr1 = { 1, 2, 3, 4, 6 };
    short[] arr2 = { 1, 2, 3, 4, 5 };
    Set set1 = new HashSet();
    set1.add("K");
    set1.add("Y");
    set1.add("W");
    Set set2 = new HashSet();
    set2.add("E");
    set2.add("MU");
    set2.add("Sik");

    p1.setNetpay((BigInteger)obj1);
    p2.setNetpay((BigInteger)obj3);
    p1.setAge((Short)s1);
    p2.setAge(Short.valueOf(String.valueOf(s2)));//(Short)23=> 23이 int라서 ERROR
    p1.setSysValue(key1);
    p2.setSysValue(key2);
    p1.setHabit(arr1);
    p2.setHabit(arr2);
    p1.setCustom(set1);
    p2.setCustom(set2);
//    System.out.println("p1.netPay의 해시코드 = " + p1.hashCode());
//    System.out.println("p2.netPay의 해시코드 = " + p2.hashCode());
    
    try {
      //deep clone 테스트(Arrays.copyOf()사용)
      //Arrays.copyOf()는 항목정렬, 항목검색, 항목비교 제공
      //1.thin clone 후
      clonedP1 = p1.clone();
      //2.deep clone필요한 멤버필드 객체들은 type별로 지원되는 copy()메소드나, new 객체 생성으로 내용 복사
      clonedP1.setNetpay(new BigInteger(p1.getNetpay().toString()));
      clonedP1.setSysValue(new String(p1.getSysValue()));
      clonedP1.setHabit(Arrays.copyOf((long[])p1.getHabit(), ((long[])p1.getHabit()).length));
      clonedP1.setCustom(Set.copyOf(p1.getCustom()));
      
//      //deep clone 테스트(System.arraycopy()사용)
//      //System.arraycopy()는 단순copy로 항목정렬, 항목검색, 항목비교 제공없음
//      //1.thin clone 후
//      clonedP2 = p2.clone();
//      //2.deep clone필요한 멤버필드 객체들은 type별로 지원되는 copy()메소드나, new 객체 생성으로 내용 복사
//      clonedP2.setNetpay(new BigInteger(p2.getNetpay().toString()));
//      clonedP2.setSysValue(new String(p2.getSysValue()));
//      try {
//        //###########################################################
//        //선생님! 복사한 객체 clonedP2는 debug하면 복사가 되어 있는데, 에러나요ㅜㅜ
//        //###########################################################
//        System.arraycopy((short[])p2.getHabit(), 0, clonedP2, 0, ((short[])p2.getHabit()).length);
//      } catch(IndexOutOfBoundsException e) {
//        e.printStackTrace();
//      } catch(ArrayStoreException e) {
//        e.printStackTrace();
//      } catch(NullPointerException e) {
//        e.printStackTrace();
//      }
//      clonedP2.setCustom(Set.copyOf(p2.getCustom()));
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    int inputKey=0;
    boolean run = true;
    try {
      System.out.println("키보드 키 2개 입력(종료:B)");
      while(run) {
        //Enter:13, 라인피드:10 같이 입력되는 것 체크
        if( inputKey != 13 && inputKey != 10 ) {
          System.out.print("키보드 키 입력:");
        }
        inputKey = System.in.read();//Ctrl:17, y:121, f=102
        if( inputKey == 66 ) //키코드 입력 : 66(B)이면 break;
          //System.exit(0);//TEST OK
          break;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("---------------------------------");
    System.out.println("배열 habit의 처음상태");
    System.out.println("---------------------------------");
    System.out.println("p1.hashCode() = " + p1.hashCode());
    System.out.println("clonedP1.hashCode() = " + clonedP1.hashCode());
    System.out.println("---------------------------------");
    System.out.println("VariablesUtil.deepEqualsArray(p1, clonedP1)의 Array && Objects의 deepEquals = "
        + VariablesUtil.deepEqualsArray());
//    System.out.println("VariablesUtil.compare(p2, clonedP2) = " 
//        + VariablesUtil.compare(p2, clonedP2));
    System.out.println("---------------------------------");
    System.out.println("배열 habit의 Objects[].cast, Objects.RquireNonNull, Objects.deepEquals 실행 후");
    System.out.println("---------------------------------");
    System.out.println("p1.hashCode() = " + p1.hashCode());
    System.out.println("clonedP1.hashCode() = " + clonedP1.hashCode());
    System.out.println("---------------------------------");
  }
  //Inner Class
  class VariablesUtil {
    static <T1, T2, T3, T4, T5>boolean compare(SaleryMan<T1, T2, T3, T4, T5> p1, SaleryMan<T1, T2, T3, T4, T5> p2) {
      System.out.println("p1.getNetpay()="+p1.getNetpay());
      System.out.println("p2.getNetpay()="+p2.getNetpay());

      if(p1.netpay.equals(p2.netpay)) 
        System.out.println("p1.netpay.equals(p2.netpay) = 같음");
      else
        System.out.println("p1.netpay.equals(p2.netpay) = 다름");
        
      //if(p1.getAge() > p2.getAge()) {}//T제너릭 사용시 연산자 > < 사용 안됨
      if( p1.getNetpay().equals(p2.getNetpay())
        && p1.getAge().equals(p2.getAge()) 
        && p1.getSysValue().equals(p2.getSysValue()) 
        && p1.getHabit().equals(p2.getHabit())
        && p1.getCustom().equals(p2.getCustom()) )
        return true;
      else 
        return false;
    }
    //Arrays.deepEquals(), Objects.deepEquals() , Objects.requireNonNull()
    //선생님! 제너릭 너무 어려워요! ㅜㅜ 제가 한게 틀리나요? ㅜㅜ
//    public <T1, T2, T3, T4, T5>boolean deepEqualsArray(SaleryMan<T1, T2, T3, T4, T5> p1, SaleryMan<T1, T2, T3, T4, T5> clonedP1) {
    static boolean deepEqualsArray() {
      Object[] arr1 = null;
      Object[] arr2 = null;
      try {
        arr1 = (Object[])Objects.requireNonNull((Object[])p1.getHabit());
        arr2 = (Object[])Objects.requireNonNull((Object[])clonedP1.getHabit());
      } catch(ClassCastException e) {
        e.printStackTrace();
      } catch(NullPointerException e) {
        e.printStackTrace();
      }
//      System.out.println("arr[0] = " + (long[].class.cast(arr1))[0]);
//      System.out.println("cloned arr[0] = " + (long[].class.cast(arr2))[0]);
      boolean result1 = Arrays.deepEquals(arr1, arr2);
      System.out.println("Arrays.deepEquals() ===> 타입이 다른 p1.habit[]과 clonedP1.habit[]의 '배열의 값들' 비교) = " + result1);
      
      //Array.deepEquals(arr[], arr[])과 같음
      System.out.println("p1.getHabit()[0] = " + ((long[])p1.getHabit())[0]);
      System.out.println("clonedP1.getHabit()[0] = " + ((long[])clonedP1.getHabit())[0]);
      boolean result2 = Objects.deepEquals(p1.getHabit(), clonedP1.getHabit());
      System.out.println("Objects.deepEquals() ===> 타입이 다른 p1.habit[]과 clonedP1.habit[]의 '배열의 값들' 비교) = " + result2);

      return result1 && result2;
    }
    //미결정된type에서는 deep clone 안됨
    //generic type class는 객체type이 결정되지 않아서 배열.length를 찾을 수 없다
  }
  //Inner Class (class SaleryMan<T1, T2, T3, T4, T5> {}이라는 generic class를 inner class로 사용했더니 Error
}