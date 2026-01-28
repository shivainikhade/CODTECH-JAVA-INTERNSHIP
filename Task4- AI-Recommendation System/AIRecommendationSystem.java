import java.util.*;

public class AIRecommendationSystem {

    public static void main(String[] args) {

        // Sample user preference data
        Map<String, Set<String>> userPreferences = new HashMap<>();

        userPreferences.put("User1", new HashSet<>(Arrays.asList("Java", "Python", "SQL")));
        userPreferences.put("User2", new HashSet<>(Arrays.asList("Java", "C++", "SQL")));
        userPreferences.put("User3", new HashSet<>(Arrays.asList("Python", "JavaScript")));
        userPreferences.put("User4", new HashSet<>(Arrays.asList("Java", "Python")));

        String targetUser = "User4";

        Set<String> recommendations = getRecommendations(targetUser, userPreferences);

        System.out.println("Recommendations for " + targetUser + ":");
        for (String item : recommendations) {
            System.out.println("- " + item);
        }
    }

    // Recommendation logic
    private static Set<String> getRecommendations(
            String targetUser,
            Map<String, Set<String>> userPreferences) {

        Set<String> targetItems = userPreferences.get(targetUser);
        Set<String> recommendedItems = new HashSet<>();

        for (String user : userPreferences.keySet()) {
            if (!user.equals(targetUser)) {

                Set<String> commonItems = new HashSet<>(targetItems);
                commonItems.retainAll(userPreferences.get(user));

                // If users share common interests
                if (!commonItems.isEmpty()) {
                    for (String item : userPreferences.get(user)) {
                        if (!targetItems.contains(item)) {
                            recommendedItems.add(item);
                        }
                    }
                }
            }
        }
        return recommendedItems;
    }
}
