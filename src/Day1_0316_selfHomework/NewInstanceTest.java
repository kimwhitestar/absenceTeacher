/* 동적객체생성 테스트 */
package Day1_0316_selfHomework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class NewInstanceTest {
  private static GenericTypeImpl<List, String> genericTypeImpl = null;
  private static GenericTypeImpl<List, String> genericTypeImplReflect = null;
  static {
    String targetRuntimeFieldZ = new String("targetRuntimeFieldZ테스트");
    int value1 = 999999999;//9억
    short value2 = 9999;
    BigInteger value3 = new BigInteger("100000000000000000");//1000조이상
    String value4 = new String("문자");
    char value5 = 'Z';

    List list = new ArrayList();
    list.add(value1);
    list.add(value2);
    list.add(value3);
    list.add(value4);
    list.add(value5);
    
    try {
      /** newInstans() 참조 웹사이트 : https://jwdeveloper.tistory.com/44 */
      Class<?> obtainClass = Class.forName("Day1_0316_selfHomework.GenericTypeImpl");//java 7부터는 new 객체생성시 <>사용가능
      //@SuppressWarnings("deprecation")//newInstance() java9부터 삭제됨
      Constructor<?> constructor = obtainClass.getConstructor();
      genericTypeImpl = (GenericTypeImpl<List, String>)constructor
          .newInstance();//newInstance()는 up casting 필요
      Constructor<?> constructorReflect = obtainClass.getConstructor(list.getClass(), targetRuntimeFieldZ.getClass());
      genericTypeImplReflect = (GenericTypeImpl<List, String>)constructorReflect
          .newInstance(list, targetRuntimeFieldZ);//newInstance()는 up casting 필요
    } catch(ClassNotFoundException e) {
      e.getMessage();
    } catch(IllegalAccessException e) {
      e.getMessage();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    if(null != genericTypeImpl) { 
      System.out.println("newInstance()로 객체 획득"); 
      genericTypeImpl.setObject("글자");
      System.out.println("str " + genericTypeImpl.getObject());
    }
    if(null != genericTypeImplReflect) {
      System.out.println("newInstance()로 reflection객체 획득"); 
      String str = genericTypeImplReflect.getObject();
      System.out.println("str " + str);
      List list = genericTypeImplReflect.getList();
      for(Object obj : list) {
        System.out.println("list " + obj);
      }
    }
  }
}