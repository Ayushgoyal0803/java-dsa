import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingIntervals {
    public static void main(String[] args) {
        List<List<Integer>> meet = new ArrayList<>();

        List<Integer> l1 = Arrays.asList(7, 10);
        List<Integer> l2 = Arrays.asList(2, 4);
        List<Integer> l3 = Arrays.asList(5, 8);

        meet.add(l1);
        meet.add(l2);
        meet.add(l3);

        System.out.println(isOverlap(meet));
    }

    public static boolean isOverlap(List<List<Integer>> meet) {
        meet.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));

        int i = 1;

        while (i < meet.size()) {
            if (meet.get(i - 1).get(1) > meet.get(i).get(0)) {
                return false;
            }
            i++;
        }

        return true;
    }


}
