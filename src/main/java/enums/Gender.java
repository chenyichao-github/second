package enums;

public enum Gender implements GenderDesc {
    MALE("男") {
        @Override
        public void info() {
            System.out.println("这个枚举值代表男性");
        }
    }, FEMALE("女") {
        @Override
        public void info() {
            System.out.println("这个枚举值代表女性");
        }
    };
    private final String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
