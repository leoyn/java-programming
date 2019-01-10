package chapter12.Task2;

import chapter12.List;
import chapter12.Element;

public class ReorderedList extends List {
    public ReorderedList reorder() {

        List negativeNumbers = new List();
        List positiveNumbers = new List();

        Element element = head;

        while(element != null) {
            Element newElement = new Element(element.value);

            if(element.value < 0) negativeNumbers.push(newElement);
            else positiveNumbers.push(newElement);

            element = element.next;
        }
        
        // get end of negativeNumbers list
        if(negativeNumbers.head != null) {
            Element tail = negativeNumbers.head;

            while(tail.next != null) {
                tail = tail.next;
            }

            tail.next = positiveNumbers.head;

            head = negativeNumbers.head;
        }

        return this;
    }
}