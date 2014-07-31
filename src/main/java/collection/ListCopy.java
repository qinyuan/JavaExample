package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinyuan on 14-7-27.
 */
public class ListCopy {
    private List<Integer> list;

    public ListCopy(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getList() {
        return list;
    }

    public List<Integer> getCopyList() {
        return new ArrayList<Integer>(list);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        ListCopy copy = new ListCopy(list);

        list.add(3);
        System.out.println(list);
        System.out.println(copy.getList());

        copy.getList().add(4);
        System.out.println(copy.getList());

        copy.getCopyList().add(5);
        System.out.println(copy.getList());
    }
}
