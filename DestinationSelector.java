/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DestinationSelector extends JFrame {
    private static final Color BACKGROUND_COLOR = new Color(250, 250, 210); // Light khaki
    private static final Dimension BUTTON_SIZE = new Dimension(250, 60);
    private static final int BUTTON_SPACING = 20;

    public DestinationSelector() {
        initializeFrame();
        setupUI();
    }

    private void initializeFrame() {
        setTitle("Destination Selector");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setupUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // Title panel with centered label
        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setBackground(BACKGROUND_COLOR);
        titlePanel.add(createInstructionLabel());
        
        // Button panel with centered buttons
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(BACKGROUND_COLOR);
        buttonPanel.add(createButtonColumn());
        
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        
        add(mainPanel);
    }

    private JLabel createInstructionLabel() {
        JLabel label = new JLabel("<html><center>Hi, Please tap your<br>destination.</center></html>");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        return label;
    }

    private JPanel createButtonColumn() {
        JPanel columnPanel = new JPanel();
        columnPanel.setLayout(new BoxLayout(columnPanel, BoxLayout.Y_AXIS));
        columnPanel.setOpaque(false);

        String[] buttonLabels = {"STUDENT", "FACULTY"};
        Color[] buttonColors = {
            new Color(128, 0, 0),    // Maroon
            new Color(218, 165, 32), // Golden
        };

        for (int i = 0; i < buttonLabels.length; i++) {
            columnPanel.add(createDestinationButton(buttonLabels[i], buttonColors[i]));
            if (i < buttonLabels.length - 1) {
                columnPanel.add(Box.createRigidArea(new Dimension(0, BUTTON_SPACING)));
            }
        }

        return columnPanel;
    }

    private JButton createDestinationButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 25));
        button.setForeground(Color.WHITE);
        button.setBackground(bgColor);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(BUTTON_SIZE);
        button.setMaximumSize(BUTTON_SIZE);
        button.addActionListener(this::handleButtonClick);
        return button;
    }

    private void handleButtonClick(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String destination = source.getText();

        switch (destination) {
            case "STUDENT":
                new StudentPage().setVisible(true);
                break;
            case "FACULTY":
                new FacultyPage().setVisible(true);
                break;
        }
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DestinationSelector().setVisible(true));
    }
}