import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;

public class Run
{
    private static String selectedDirectoryPath; // Variable to store the selected directory path
    private static String repoName; // Variable to store the GitHub repository name
    private static String repoDescription; // Variable to store the GitHub repository description
    private static String repoVisibility; // Variable to store the repository visibility ("public" or "private")
    public static void main(String[] args)
    {
        // Create the JFrame
        JFrame frame = new JFrame("GitHub Desktop V2");

        // Initialize a JPanel to hold all the components
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        // Label and text field for GitHub repository name
        JLabel repoNameLabel = new JLabel("Enter GitHub Repo Name:");
        panel.add(repoNameLabel);
        JTextField nameField = new JTextField(20); // 20 columns wide
        panel.add(nameField);

        // Label and text field for GitHub repository description
        JLabel repoDescLabel = new JLabel("Enter GitHub Repo Description:");
        panel.add(repoDescLabel);
        JTextField descField = new JTextField(20); // 20 columns wide
        panel.add(descField);

        // Radio buttons for repository visibility
        JLabel visibilityLabel = new JLabel("Set Repository Visibility:");
        panel.add(visibilityLabel);
        JRadioButton publicButton = new JRadioButton("Public");
        JRadioButton privateButton = new JRadioButton("Private");
        publicButton.setSelected(true); // Default to public
        panel.add(publicButton);
        panel.add(privateButton);

        // Group the radio buttons
        ButtonGroup visibilityGroup = new ButtonGroup();
        visibilityGroup.add(publicButton);
        visibilityGroup.add(privateButton);

        // Button for submitting the repository information
        JButton submitButton = new JButton("Submit Repo Info");
        panel.add(submitButton);
        JLabel displayRepoInfoLabel = new JLabel("Repository info will appear here.");
        panel.add(displayRepoInfoLabel);

        // Button for opening the directory chooser
        JButton dirButton = new JButton("Open Directory Explorer");
        panel.add(dirButton);
        JLabel dirLabel = new JLabel("Selected directory will appear here.");
        panel.add(dirLabel);

        // Action listener for the repository info submit button
        submitButton.addActionListener(e -> {
            repoName = nameField.getText();
            repoDescription = descField.getText();
            repoVisibility = publicButton.isSelected() ? "Public" : "Private";
            System.out.println("Entered GitHub repository name: " + repoName);
            System.out.println("Entered GitHub repository description: " + repoDescription);
            System.out.println("Repository visibility: " + repoVisibility);
            displayRepoInfoLabel.setText("<html>Repository: " + repoName + "<br/>Description: " + repoDescription + "<br/>Visibility: " + repoVisibility + "</html>");
        });

        // Action listener for the directory chooser button
        dirButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = fileChooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedDirectoryPath = fileChooser.getSelectedFile().getAbsolutePath();
                System.out.println("Selected directory: " + selectedDirectoryPath);
                dirLabel.setText("Directory: " + selectedDirectoryPath);
            }
        });

        // Set the default close operation and size of the JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLocationRelativeTo(null); // Center the frame on the screen

        // Make the frame visible
        frame.setVisible(true);
    }
}