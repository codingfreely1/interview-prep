package util;

import java.util.List;

/**
 * Created by yael on 10/01/17.
 */
public class Utils {

    public static <T> String listWithCommaSeparator(List<T> list){
        StringBuilder sb = new StringBuilder();

        list.forEach(i -> sb.append(i.toString()).append(","));
        sb.replace(sb.length() -1, sb.length(), ""); //removing last comma
        return sb.toString();
    }
}
