package firstaidcompanionapp.ui.screens;

import firstaidcompanionapp.services.DatabaseService;
import firstaidcompanionapp.ui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SymptomScreen extends JPanel {

    private final MainFrame mainFrame;
    private final DatabaseService databaseService;

    private JTextField symptomField;
    private JTextArea infoArea;
    private JLabel imageLabel;

    private final Map<String, String> imagePaths = new HashMap<>();

    public SymptomScreen(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.databaseService = new DatabaseService();
        initializeImages();
        initializeUI();
    }

    private void initializeImages() {
        // ✅ Image paths from project root
        imagePaths.put("burn", "images/burn.jpeg");
        imagePaths.put("cut", "images/cut.jpeg");
        imagePaths.put("fever", "images/fever.jpeg");
        imagePaths.put("snake bite", "images/snakebite.jpeg");
        imagePaths.put("fracture", "images/fracture.jpeg");
        imagePaths.put("choking", "images/choking.jpeg");
        imagePaths.put("nosebleed", "images/nosebleed.jpeg");
        imagePaths.put("default", "images/default.jpeg");
    }

    private void initializeUI() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBackground(Color.WHITE);

        JLabel label = new JLabel("Enter a symptom:");
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));

        symptomField = new JTextField(20);
        JButton checkButton = createButton("Check", new Color(0, 102, 204));
        JButton clearButton = createButton("Clear", new Color(128, 128, 128));
        JButton backButton = createButton("Back", new Color(204, 0, 0));

        topPanel.add(label);
        topPanel.add(symptomField);
        topPanel.add(checkButton);
        topPanel.add(clearButton);
        topPanel.add(backButton);
        add(topPanel, BorderLayout.NORTH);

        imageLabel = new JLabel("Image not found", SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(600, 300));
        add(imageLabel, BorderLayout.CENTER);

        infoArea = new JTextArea(6, 60);
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(infoArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("🩺 First Aid Instructions"));
        add(scrollPane, BorderLayout.SOUTH);

        // ✅ Button Actions
        checkButton.addActionListener(e -> showAdvice(symptomField.getText().trim().toLowerCase()));
        clearButton.addActionListener(e -> clearFields());
        backButton.addActionListener(e -> mainFrame.showScreen("SYMPTOM_MENU"));
    }

    private JButton createButton(String text, Color color) {
        JButton btn = new JButton(text);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return btn;
    }

    private void clearFields() {
        symptomField.setText("");
        infoArea.setText("");
        imageLabel.setIcon(null);
        imageLabel.setText("Image not found");
    }

    private void showAdvice(String symptom) {
        if (symptom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a symptom name!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // ✅ Get text instruction from SQLite
        String instruction = databaseService.getInstruction(symptom);
        infoArea.setText(instruction);

        // ✅ Get image from project folder
        String imagePath = imagePaths.getOrDefault(symptom, "images/default.jpeg");
        File file = new File(imagePath);
        if (file.exists()) {
            ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(400, 250, Image.SCALE_SMOOTH));
            imageLabel.setIcon(icon);
            imageLabel.setText("");
        } else {
            imageLabel.setIcon(null);
            imageLabel.setText("Image not found");
        }
    }
}
