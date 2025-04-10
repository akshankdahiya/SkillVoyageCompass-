import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SkillManager manager = new SkillManager();

        // Test search functionality
        System.out.println("Testing search for existing skill:");
        manager.searchSkill("Python");
        System.out.println("\nTesting search for non-existing skill:");
        manager.searchSkill("NodeJS");
        System.out.println("\nTesting search by prefix 'P':");
        manager.searchByPrefix("P");

        // Test adding a new skill
        System.out.println("\nAdding a new skill (NodeJS):");
        manager.addSkill("NodeJS", 60, 980000.0, 88);
        manager.searchSkill("NodeJS");

        // Display all skills and exportable format
        System.out.println("\nUpdated SkillVoyage Compass Data:");
        for (Map.Entry<String, SkillManager.Skill> entry : manager.getAllSkills().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nExportable JSON Format:");
        System.out.println(manager.getDataForExport());
    }
}