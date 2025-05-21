import java.util.*;

enum ActionEnum {
    feature1Button,
    feature2Button,
    feature3Button,
}

interface AnalyticsStore {
    void storeActions(Queue<ActionEnum> q);
}

class DefaultAnalyticsStore implements AnalyticsStore {
    List<ActionEnum> store = new ArrayList<>();

    public void storeActions(Queue<ActionEnum> q) {
        for (ActionEnum action : q) {
            store.add(action);
            System.out.print(action + " ");
        }
        System.out.println();
    }
}

class Analytics {
    private final AnalyticsStore analyticsStore;
    private final int K;
    private final Queue<ActionEnum> actionQueue;
    private final Map<ActionEnum, Integer> actionFrequency;
    private int totalLoggedActions;

    public Analytics(AnalyticsStore analyticsStore, int K) {
        this.analyticsStore = analyticsStore;
        this.K = K;
        this.actionQueue = new LinkedList<>();
        this.actionFrequency = new HashMap<>();
        this.totalLoggedActions = 0;
    }

    public void registerAction(ActionEnum action) {
        actionQueue.add(action);
        actionFrequency.put(action, actionFrequency.getOrDefault(action, 0) + 1);
        totalLoggedActions++;

        if (actionQueue.size() == K) {
            analyticsStore.storeActions(new LinkedList<>(actionQueue));
            actionQueue.clear();
        }
    }

    public int getNumberOfActionRegisteredButNotSentToAnalyticsStore() {
        return actionQueue.size();
    }

    public int getTotalNumberOfLoggedActions() {
        return totalLoggedActions;
    }

    public List<ActionEnum> getMostFrequentlyUsedActions() {
        int maxFreq = 0;
        for (int freq : actionFrequency.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }

        List<ActionEnum> result = new ArrayList<>();
        for (Map.Entry<ActionEnum, Integer> entry : actionFrequency.entrySet()) {
            if (entry.getValue() == maxFreq) {
                result.add(entry.getKey());
            }
        }

//        result.sort(Comparator.comparing(Enum::name));
        Collections.sort(result);
        return result;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalRequests = 8;
        int k = 3;

        String[] commands = {
                "registerAction feature1Button",
                "registerAction feature1Button",
                "getTotalNumberOfLoggedActions",
                "registerAction feature2Button",
                "registerAction feature3Button",
                "getNumberOfActionRegisteredButNotSentToAnalyticsStore",
                "registerAction feature2Button",
                "getMostFrequentlyUsedActions",
                "getTotalNumberOfLoggedActions",
                "registerAction feature3Button",
                "getMostFrequentlyUsedActions"
        };

        AnalyticsStore store = new DefaultAnalyticsStore();
        Analytics analytics = new Analytics(store, k);

        for (String input : commands) {
            String[] parts = input.split(" ");

            switch (parts[0]) {
                case "registerAction":
                    ActionEnum action = ActionEnum.valueOf(parts[1]);
                    analytics.registerAction(action);
                    break;
                case "getTotalNumberOfLoggedActions":
                    System.out.println(analytics.getTotalNumberOfLoggedActions());
                    break;
                case "getNumberOfActionRegisteredButNotSentToAnalyticsStore":
                    System.out.println(analytics.getNumberOfActionRegisteredButNotSentToAnalyticsStore());
                    break;
                case "getMostFrequentlyUsedActions":
                    List<ActionEnum> mostUsed = analytics.getMostFrequentlyUsedActions();
                    for (ActionEnum act : mostUsed) {
                        System.out.print(act.name() + " ");
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
