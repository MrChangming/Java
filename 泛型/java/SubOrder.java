package java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MrChangMing
 * @Description
 * @data 2022/8/28
 */
public class SubOrder extends Order<Integer> {//SubOrder:不是泛型类


    public static <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;

    }


}
