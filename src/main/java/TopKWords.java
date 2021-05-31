import java.util.*;
import java.util.stream.Collectors;

public class TopKWords {

    public static List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<words.length;i++)
        {
            if(map.containsKey(words[i])){

                int number = map.get(words[i]);

                map.put(words[i],++number);
            }
            else{
                map.put(words[i],0);
            }
        }

        List<String> a = map.entrySet().stream().sorted((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return o1.getValue().compareTo(o2.getValue());
        }).map(Map.Entry::getKey).collect(Collectors.toList());

        return  a.subList(0,k);

    }

    public static void main(String[] args) {

        TopKWords.topKFrequent(new String[]{"CIAO", "ABC","BDE", "PENNE", "CIAO","ZZZ", "ZZZ"},2);

    }

}
