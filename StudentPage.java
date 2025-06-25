/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;


import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class StudentPage extends JFrame {

    public StudentPage() {
        setTitle("Student Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);

        // Main panel with GridBagLayout for perfect centering
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(250, 250, 210)); // Light khaki background
        add(mainPanel);

        // Configure constraints for layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 50, 10, 50); // Consistent margins

        // Title label
        JLabel title = new JLabel("<html><center>LET'S<br>START!</center></html>");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(new Color(128, 0, 0)); // Maroon color
        gbc.insets = new Insets(0, 0, 40, 0); // Extra bottom margin for title
        mainPanel.add(title, gbc);

        // Create buttons with uniform size
        Dimension buttonSize = new Dimension(100, 30); // Standard button size

        // Login Button
        JButton loginButton = createStyledButton("LOG IN", buttonSize);
        loginButton.addActionListener(e -> {
            new StudentLoginPage().setVisible(true);
            dispose();
        });

        // Sign Up Button
        JButton signupButton = createStyledButton("SIGN UP", buttonSize);
        signupButton.addActionListener(e -> {
            new StudentSignupPage().setVisible(true);
            dispose();
        });

        // Button panel with vertical layout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false);
        buttonPanel.add(loginButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 15))); // Consistent spacing
        buttonPanel.add(signupButton);

        gbc.insets = new Insets(0, 50, 0, 50); // Reset margins for buttons
        mainPanel.add(buttonPanel, gbc);
    }

    // Helper method to create consistently styled buttons
    private JButton createStyledButton(String text, Dimension size) {
        JButton button = new JButton(text);
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        button.setMinimumSize(size);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(192, 192, 192));
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentPage().setVisible(true));
    }
}