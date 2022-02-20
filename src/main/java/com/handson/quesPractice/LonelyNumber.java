package com.handson.quesPractice;

import java.util.*;

public class LonelyNumber {
    public static void main(String[] args) {
        //Using Reduce
        List<Integer> integerList= Arrays.asList(1,2,7,1,8,2,3,5,4,8,5,7);//only one number is lonely at a time
        System.out.println("Lonely : "+getUniqueLonelyNumber(integerList));

        //Using Map for multiple
        List<Integer> integerListMultiple= Arrays.asList(1,2,7,1,2,3,5,4,8,5);//multiple number can be lonely at a time
        System.out.println("Lonely map (multiple): " + getLonelyMapWithOccurrence(integerListMultiple));

    }

    private static Map<Integer, Integer> getLonelyMapWithOccurrence(List<Integer> integerListMultiple) {
        Map<Integer, Integer> intOccurrenceMap = new HashMap<>();
        integerListMultiple.forEach(integer -> {
                    if (intOccurrenceMap.containsKey(integer)) intOccurrenceMap.put(integer, intOccurrenceMap.get(integer) + 1);
                    else intOccurrenceMap.put(integer, 1);
                }
        );
        return intOccurrenceMap;
    }

    private static int getUniqueLonelyNumber(List<Integer> integerList) {
        Optional<Integer> uniqueLonelyNumberOptional= integerList.stream().reduce((a, b)->a^b);
        return uniqueLonelyNumberOptional.orElseThrow();
    }
}
