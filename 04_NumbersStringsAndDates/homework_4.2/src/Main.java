public class Main {
    public static void main(String[] args) {
        String formatSting = "Значения %s \nМинимальное %d\nМаксимальное %d\n";
        System.out.printf((formatSting) + "%n","Byte",Byte.MIN_VALUE,Byte.MAX_VALUE);
        System.out.printf((formatSting)+  "%n","Short",Short.MIN_VALUE,Short.MAX_VALUE);
        System.out.printf((formatSting)+  "%n","Integer",Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.printf((formatSting)+  "%n","Long",Long.MIN_VALUE,Long.MAX_VALUE);
        formatSting = "Значения %s \nМинимальное %f\nМаксимальное %f\n";
        System.out.printf((formatSting)+  "%n","Float",Float.MIN_VALUE,Float.MAX_VALUE);
        System.out.printf((formatSting)+  "%n","Double",Double.MIN_VALUE,Double.MAX_VALUE);
    }
}
