package Day1_0316_selfHomework;

//import java.math.BigInteger;

public class GenericTypeImpl<K, V> implements GenericType<K, V> {
  public K list;//List
  public V object;//Object
  
  public GenericTypeImpl() {
    //newInstance()동적객체생성하려면, 반드시 클래스내에 기본생성자 필요
    //기본생성자없이 아래의 매개타입생성자만 선언하면,system에서도 default생성자 안만듬.
  }
  public GenericTypeImpl(K list, V object) {//멀티타입 매개변수 갖는 생성자
    this.initParam(list, object);
  }
  
  @Override
  public void initParam(K list, V object) {//테스트값 초기화
    this.setObject(object);
//    targetRuntimeField = 999999999;//9억
//    list.add(targetRuntimeField);
//    targetRuntimeField = 9999;
//    list.add(targetRuntimeField);
//    targetRuntimeField = new BigInteger("100000000000000000");//1000조이상
//    list.add(targetRuntimeField);
//    targetRuntimeField = new String("문자");
//    list.add(targetRuntimeField);
//    targetRuntimeField = 'Z';
//    list.add(targetRuntimeField);
    this.setList(list);
  }
  @Override
  public K getList() {
    return this.list;
  }
  @Override
  public void setList(K list) {
    this.list = list;
  }
  @Override
  public V getObject() {
    return this.object;
  }
  @Override
  public void setObject(V object) {
    this.object = object;
  }
}
