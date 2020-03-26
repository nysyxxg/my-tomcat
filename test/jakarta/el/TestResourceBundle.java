package jakarta.el;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Tomcat中的ResourceBundle国际化解析
 * 测试： https://blog.csdn.net/qq_38975553/article/details/102935608
 */
public class TestResourceBundle {
    public static void main(String args[]) {
        ResourceBundle bundle = ResourceBundle.getBundle("my", new Locale("zh", "CN"));
        String cancel = bundle.getString("cancelKey");
        System.out.println(cancel);

        bundle = ResourceBundle.getBundle("my", Locale.US);
        cancel = bundle.getString("cancelKey");
        System.out.println(cancel);

        bundle = ResourceBundle.getBundle("my", Locale.getDefault());
        cancel = bundle.getString("cancelKey");
        System.out.println(cancel);

        bundle = ResourceBundle.getBundle("my", Locale.GERMAN);
        cancel = bundle.getString("cancelKey");
        System.out.println(cancel);
        bundle = ResourceBundle.getBundle("my");
        for (String key : bundle.keySet()) {
            System.out.println(bundle.getString(key));
        }
    }

}
