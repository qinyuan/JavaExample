package json.register;

/**
 * Created by qinyuan on 14-7-23.
 */
public class Sub implements Parent {

    private String name;

    public Sub() {
    }

    public Sub(String name) {
       this.name = name;
    }

    @Override
    final public String getName() {
        return name;
    }

    final public void setName(String name) {
        this.name = name;
    }
}
