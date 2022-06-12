package com.trigram;

import java.util.HashMap;
import java.util.Map;

public class GenerateTrigrams {
    public static void main(String args[]){

        String input = "I wish I may I wish I might I try to crack program";
        Map<String,TrigramValidator> trigramsMap = new HashMap<String,TrigramValidator>();

        String[] words = input.split(" ");

        int last = words.length - 3;

        for (int i = 0; i <= last; i++) {
            String[] subset = new String[3];
            subset[0] = words[i];
            subset[1] = words[i+1];
            subset[2] = words[i+2];

            TrigramValidator trigram = new TrigramValidator(subset);

            String key = trigram.getKey();

            if (trigramsMap.containsKey(key)) {
                trigramsMap.get(key).addNext(trigram.getNext());
            } else {
                trigramsMap.put(key, trigram);
            }
        }

        trigramsMap.entrySet().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue().values()));
    }


    //This method return only to test via  test cases.
   public Map<String, TrigramValidator> generateTrigrams(String input){
      // String input = "I wish I may I wish I might I try to crack program";
       Map<String,TrigramValidator> trigramsMap = new HashMap<String,TrigramValidator>();

       String[] words = input.split(" ");

       int last = words.length - 3;

       for (int i = 0; i <= last; i++) {
           String[] subset = new String[3];
           subset[0] = words[i];
           subset[1] = words[i+1];
           subset[2] = words[i+2];

           TrigramValidator trigram = new TrigramValidator(subset);

           String key = trigram.getKey();

           if (trigramsMap.containsKey(key)) {
               trigramsMap.get(key).addNext(trigram.getNext());
           } else {
               trigramsMap.put(key, trigram);
           }
       }
        return trigramsMap;
    }
}
