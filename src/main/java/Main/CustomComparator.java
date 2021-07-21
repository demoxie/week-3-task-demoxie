package Main;

import Enums.LibraryUsers;

import java.util.EnumMap;
import java.util.PriorityQueue;
import java.util.Comparator;
class CustomComparator implements Comparator<LibraryUsers>{


    @Override
    public int compare(LibraryUsers o1, LibraryUsers o2) {
        int value = o1.getValue().compareTo(o2.getValue());
        return Integer.compare(value, 0);
    }
}
