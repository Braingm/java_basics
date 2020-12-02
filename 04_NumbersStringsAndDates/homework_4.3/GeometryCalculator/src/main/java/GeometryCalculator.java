public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        return Math.PI * Math.pow(Math.abs(radius), 2.0);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return (4.0/3.0) * Math.PI * Math.pow(Math.abs(radius), 3.0);
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if (a + b > c && a + c > b && c + b > a)
            return true;
        else
            return false;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (!isTrianglePossible(a,b,c))
            return -1.0;
        double p = (Math.abs(a) + Math.abs(b) + Math.abs(c)) / 2;
        return Math.sqrt(p * (p - Math.abs(a)) * (p - Math.abs(b)) * (p - Math.abs(c)));
    }
}
