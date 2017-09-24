import java.io.PipedOutputStream;
import java.io.PrintStream;

public class SystemOut {
    public static final COUT cout = new COUT();

    synchronized public static void print(Object x) {
        cout.println(x);
    }


    static public void clear() {
        for (int i = 0; i < 50; i++, cout.print(""))
            ;
    }


}


class COUT extends PrintStream {

    public COUT() {
        super(System.out);
        System.setOut(new PrintStream(new PipedOutputStream()));
        //    System.setErr(new PrintStream(new PipedOutputStream()));
    }

}
