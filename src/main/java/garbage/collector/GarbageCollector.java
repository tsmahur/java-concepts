package garbage.collector;

public class GarbageCollector {
    public static void main(String[] args) {
        Temp t=new Temp();
        t=null;
        Temp t1=new Temp();
        Temp t2=new Temp();
        t1=t2;
        new Temp();
        System.gc();
    }
}

class Temp{
    String str;
    @Override
    protected void finalize(){
        System.out.println("inside finalize() obj is garbage collected");
    }
}

