package enums;

public enum Operation {
    PLUS {
        @Override
        public double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        public double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override
        public double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public double eval(double x, double y) {
            return x / y;
        }
    };

    public static void main(String[] args) {
        System.out.println(Operation.PLUS.eval(3, 4));
        System.out.println(Operation.MINUS.eval(5, 4));
        System.out.println(Operation.TIMES.eval(5, 4));
        System.out.println(Operation.DIVIDE.eval(5, 4));
    }

    public abstract double eval(double x, double y);
}
