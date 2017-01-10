package util;

import java.util.List;
import java.util.Stack;

/**
 * Created by yael on 10/01/17.
 */
public class Utils {

    public static <T> String listWithCommaSeparator(List<T> list){
        return listWithSeparator(list, ",");
    }

    public static <T> String listWithSeparator(List<T> list, String separator){
        StringBuilder sb = new StringBuilder();

        list.forEach(i -> sb.append(i.toString()).append(separator));
        if(!separator.isEmpty()){
            sb.replace(sb.length() -1, sb.length(), ""); //removing last separator
        }
        return sb.toString();
    }
}
