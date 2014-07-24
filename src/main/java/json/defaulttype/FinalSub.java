package json.defaulttype;

/**
 * Created by qinyuan on 14-7-23.
 */
final class FinalSub implements Parent {

    private String name;

    public FinalSub() {
    }

    public FinalSub(String name) {
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
