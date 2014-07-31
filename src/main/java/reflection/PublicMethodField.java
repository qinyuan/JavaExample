package reflection;

import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;

/**
 * Created by qinyuan on 14-7-25.
 */
public class PublicMethodField {

    public static void main(String[] args) throws Exception {
        Test test = new Test("hhhh");
        PropertyDescriptor[] ps = PropertyUtils.getPropertyDescriptors(test);
        for (PropertyDescriptor p : ps) {
            System.out.println(p.getName());
            System.out.println(PropertyUtils.getProperty(test, p.getName()).getClass());
            System.out.println();
        }
        /*
        BeanInfo beanInfo = Introspector.getBeanInfo(Test.class);
        PropertyDescriptor[] prs = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < prs.length; i++) {
            PropertyDescriptor p = prs[i];
            Method method = p.getReadMethod();
            System.out.println(p.getName() + "=" + p.getPropertyType() + "=" +
                    method.invoke(test));
        }
        */
    }

    public static class Test {
        public String field1;
        private String field2;

        public Test() {
            this("default");
        }

        public Test(String field2) {
            this.field2 = field2;
        }

        public String getField2() {
            return field2;
        }

        public String getField3() {
            return null;
        }
    }
}
