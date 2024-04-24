import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Run
{
    private static String selectedDirectoryPath; // Variable to store the selected directory path
    private static String repoName; // Variable to store the GitHub repository name
    private static String repoDescription; // Variable to store the GitHub repository description
    private static String repoVisibility; // Variable to store the repository visibility ("public" or "private")
    private static String accessKey; // Variable to store the access key
    public static void main(String[] args)
    {
            // Create the JFrame
            JFrame frame = new JFrame("GitHub Desktop V2");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null); // Center the frame on the screen

            // Main panel with BoxLayout
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setBackground(new Color(230, 240, 255)); // Light blue background
            frame.getContentPane().add(panel);

            // Directory chooser panel
            JPanel dirPanel = new JPanel();
            dirPanel.setBackground(new Color(210, 225, 245)); // Slightly different blue
            JButton dirButton = new JButton("Open Directory Explorer");
            customizeButton(dirButton);
            JLabel dirLabel = new JLabel("Selected directory will appear here.");
            dirPanel.add(dirButton);
            dirPanel.add(dirLabel);
            panel.add(dirPanel);

            // Name entry panel
            JPanel namePanel = new JPanel();
            namePanel.setBackground(new Color(210, 225, 245));
            JLabel repoNameLabel = new JLabel("Enter GitHub Repo Name:");
            JTextField nameField = new JTextField(20); // 20 columns wide
            namePanel.add(repoNameLabel);
            namePanel.add(nameField);
            panel.add(namePanel);

            // Description entry panel
            JPanel descPanel = new JPanel();
            descPanel.setBackground(new Color(210, 225, 245));
            JLabel repoDescLabel = new JLabel("Enter GitHub Repo Description:");
            JTextField descField = new JTextField(20); // 20 columns wide
            descPanel.add(repoDescLabel);
            descPanel.add(descField);
            panel.add(descPanel);

            // Visibility selection panel
            JPanel visibilityPanel = new JPanel();
            visibilityPanel.setBackground(new Color(230, 240, 255)); // Main background color
            JLabel visibilityLabel = new JLabel("Set Repository Visibility:");
            JRadioButton publicButton = new JRadioButton("Public", true);
            JRadioButton privateButton = new JRadioButton("Private");
            customizeRadioButton(publicButton);
            customizeRadioButton(privateButton);
            ButtonGroup visibilityGroup = new ButtonGroup();
            visibilityGroup.add(publicButton);
            visibilityGroup.add(privateButton);
            visibilityPanel.add(visibilityLabel);
            visibilityPanel.add(publicButton);
            visibilityPanel.add(privateButton);
            panel.add(visibilityPanel);

            // Access key entry panel
            JPanel keyPanel = new JPanel();
            keyPanel.setBackground(new Color(210, 225, 245));
            JLabel keyLabel = new JLabel("Enter Access Key:");
            JTextField keyField = new JTextField(20); // 20 columns wide
            keyPanel.add(keyLabel);
            keyPanel.add(keyField);
            panel.add(keyPanel);

            // Submit button panel
            JPanel submitPanel = new JPanel();
            submitPanel.setBackground(new Color(210, 225, 245));
            JButton submitButton = new JButton("Submit Repo Info");
            customizeButton(submitButton);
            JLabel displayRepoInfoLabel = new JLabel("Repository info will appear here.");
            submitPanel.add(submitButton);
            submitPanel.add(displayRepoInfoLabel);
            panel.add(submitPanel);

            // Set up action listeners
            dirButton.addActionListener(e -> {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedDirectoryPath = fileChooser.getSelectedFile().getAbsolutePath();
                    dirLabel.setText("Directory: " + selectedDirectoryPath);
                }
            });

            submitButton.addActionListener(e -> {
                repoName = nameField.getText();
                repoDescription = descField.getText();
                repoVisibility = publicButton.isSelected() ? "Public" : "Private";
                accessKey = keyField.getText();
                displayRepoInfoLabel.setText("<html>Repository: " + repoName + "<br/>Description: " + repoDescription + "<br/>Visibility: " + repoVisibility + "<br/>Access Key: " + accessKey + "</html>");
            });

            // Make the frame visible
            frame.setVisible(true);
    }

    private static void customizeButton(JButton button) {
        button.setBackground(new Color(180, 205, 255));
        button.setForeground(Color.DARK_GRAY);
        button.setBorder(new EmptyBorder(5, 15, 5, 15));
        button.setFont(new Font("Arial", Font.BOLD, 12));
    }

    private static void customizeRadioButton(JRadioButton button) {
        button.setBackground(new Color(230, 240, 255));
        // button.setForeground(Color.DARK_GRAY);
        button.setFont(new Font("Arial", Font.PLAIN, 12));
    }
}