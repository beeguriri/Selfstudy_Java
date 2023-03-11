package Java_Study;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class _11_CollectionsMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        System.out.println(list);

        addAll(list, 1,2,3,4,5);
        System.out.println("addAll : " + list);

        rotate(list, -1);    //왼쪽으로 1칸 배열 밈
        System.out.println("rotate -1 : "+list);

        rotate(list, 2);    //오른쪽2칸 배열 밈
        System.out.println("rotate 2 : "+list);

        swap(list, 0,2);    //index의 value 교환
        System.out.println("swap : " + list);

        sort(list, reverseOrder()); //역순정렬
        System.out.println("reverseOrder : " + list);

        int idx = binarySearch(list,3);
        System.out.println("3의 index : " + idx);

        System.out.println("max : " + max(list));
        System.out.println("min : " + min(list));

        List newList1 = nCopies(list.size(), 3);

        //공통요소가 없으면 true, 있으면 false
        System.out.println(disjoint(list, newList1));   //false

    }
}
