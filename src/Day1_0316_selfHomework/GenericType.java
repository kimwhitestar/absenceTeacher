package Day1_0316_selfHomework;

public interface GenericType<K, V> {
//  public static final K list;//interface의 static filed에서는 generictype<T>를 사용안함
//  public static final V object;
  
  //테스트값 초기화
  public void initParam(K list, V object);
  public K getList();
  public void setList(K list);
  public V getObject();
  public void setObject(V object);
}
