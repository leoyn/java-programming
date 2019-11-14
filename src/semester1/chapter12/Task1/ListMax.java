package semester1.chapter12.Task1;

import semester1.chapter12.List;
import semester1.chapter12.Element;

public class ListMax extends List {
    public int getMaximum() {

        int max = Integer.MIN_VALUE;
        Element element = head;

        while(element != null) {
            if(max < element.value) max = element.value;
            element = element.next;
        }

        return max;
    }
}