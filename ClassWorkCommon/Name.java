package ClassWorkCommon;

public enum Name {
    // Алексеева, Беглов, Иванищев, Костромской, Сидоров, Щербинский
    olga("высока", 21),
    sveta("рыжая", 19),
    juliya("клёвая", 31);

    private String diff = "";
    private int age;
    Name(String dif, int birthday){
        diff = dif;
        age = birthday;
    }

    public String getDiff(){return diff;}
    public int getAge(){return age;}
}
