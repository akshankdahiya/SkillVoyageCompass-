import java.util.HashMap;
import java.util.Map;

public class SkillManager {
    private Map<String, Skill> skills;

    // Inner class to represent a Skill
    public static class Skill {
        private int totalEmployed;    // In thousands
        private double predictedSalary; // In INR
        private int demandScore;       // Out of 100

        public Skill(int totalEmployed, double predictedSalary, int demandScore) {
            this.totalEmployed = totalEmployed;
            this.predictedSalary = predictedSalary;
            this.demandScore = demandScore;
        }

        // Getters
        public int getTotalEmployed() { return totalEmployed; }
        public double getPredictedSalary() { return predictedSalary; }
        public int getDemandScore() { return demandScore; }

        @Override
        public String toString() {
            return "Employed: " + totalEmployed + "K, Salary: ₹" + predictedSalary + ", Demand: " + demandScore;
        }
    }

    // Constructor
    public SkillManager() {
        this.skills = new HashMap<>();
        initializeSkills(); // Preload with sample data
    }

    // Initialize with sample data matching the project
    private void initializeSkills() {
        addSkill("Python", 130, 1018500.0, 95);
        addSkill("Java", 95, 1050000.0, 90);
        addSkill("SQL", 75, 945000.0, 80);
        addSkill("PowerBI", 55, 882000.0, 75);
        addSkill("React", 65, 1008000.0, 85);
    }

    // Add or update a skill
    public void addSkill(String skillName, int totalEmployed, double predictedSalary, int demandScore) {
        if (skillName == null || skillName.trim().isEmpty()) {
            throw new IllegalArgumentException("Skill name cannot be null or empty");
        }
        skills.put(skillName, new Skill(totalEmployed, predictedSalary, demandScore));
    }

    // Get skill by name
    public Skill getSkill(String skillName) {
        return skills.get(skillName);
    }

    // Get all skills
    public Map<String, Skill> getAllSkills() {
        return new HashMap<>(skills); // Return a copy to prevent external modification
    }

    // Search for a specific skill
    public void searchSkill(String skill) {
        Skill details = skills.get(skill);
        if (details != null) {
            System.out.println("Searching for " + skill + ":");
            System.out.println("Skill: " + skill + " - " + details);
        } else {
            System.out.println("Searching for " + skill + ":");
            System.out.println("Skill not found: " + skill);
        }
    }

    // Search skills by prefix
    public void searchByPrefix(String prefix) {
        boolean found = false;
        for (String key : skills.keySet()) {
            if (key.toLowerCase().startsWith(prefix.toLowerCase())) {
                if (!found) {
                    System.out.println("Searching for prefix '" + prefix + "':");
                    found = true;
                }
                System.out.println("Skill: " + key + " - " + skills.get(key));
            }
        }
        if (!found) {
            System.out.println("Searching for prefix '" + prefix + "':");
            System.out.println("No skills found with prefix: " + prefix);
        }
    }

    // Method to prepare data for JSON export (simulated, manual export noted)
    public String getDataForExport() {
        StringBuilder sb = new StringBuilder("{\n");
        int count = 0;
        for (Map.Entry<String, Skill> entry : skills.entrySet()) {
            sb.append("  \"").append(entry.getKey()).append("\": {\n")
              .append("    \"totalEmployed\": ").append(entry.getValue().getTotalEmployed()).append(",\n")
              .append("    \"predictedSalary\": ").append(entry.getValue().getPredictedSalary()).append(",\n")
              .append("    \"demandScore\": ").append(entry.getValue().getDemandScore()).append("\n")
              .append("  }");
            if (count < skills.size() - 1) sb.append(",");
            sb.append("\n");
            count++;
        }
        sb.append("}");
        return sb.toString();
    }

    // Main method for testing
    public static void main(String[] args) {
        SkillManager manager = new SkillManager();
        manager.searchSkill("Python");
        manager.searchSkill("NodeJS");
        manager.searchByPrefix("P");
        manager.addSkill("NodeJS", 60, 980000.0, 88);
        manager.searchSkill("NodeJS");
        System.out.println("\nExportable JSON Format:");
        System.out.println(manager.getDataForExport());
    }
}