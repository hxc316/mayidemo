package design.enum1;

public enum  Enum12 {

    ADD("+"){
        @Override
        public int exe(int a,int b) {
            return a+b;
        }
    },

    SUB("-"){
        @Override
        public int exe(int a, int b) {
            return a - b;
        }
    };

    private String value;

    private Enum12(String value){
        this.value = value;
    }

    public abstract int exe(int a,int b);
}
