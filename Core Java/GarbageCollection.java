import java.util.*;

 class GarbageCollection
 {
  public static void main(String s[]) throws Exception{

  Runtime rs = Runtime.getRuntime();
  System.out.println("Free Memory in jvm (Java Virtual Machine) before Garbage collection = "+rs.freeMemory()+"bytes");
rs.gc();
  System.out.println("Free Memory in jvm (Java Virtual Machine) AfterGarbage collection = "+rs.freeMemory()+"bytes");

}


}