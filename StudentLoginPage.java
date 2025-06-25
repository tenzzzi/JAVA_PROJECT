/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class StudentLoginPage extends JFrame {
    private JTextField schoolNumField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;

    public StudentLoginPage() {
        setTitle("Student Login");
        setSize(400, 500); // Increased height to accommodate checkbox
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Main panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        // Title label
        JLabel titleLabel = new JLabel("STUDENT LOGIN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(128, 0, 0)); // Maroon color
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // School Number field
        formPanel.add(createLabel("School Number:"));
        schoolNumField = new JTextField();
        schoolNumField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        formPanel.add(schoolNumField);
        formPanel.add(Box.createVerticalStrut(15));
        
        // Password field
        formPanel.add(createLabel("Password:"));
        passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        formPanel.add(passwordField);
        formPanel.add(Box.createVerticalStrut(10));
        
        // Show Password checkbox
        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setFont(new Font("Arial", Font.PLAIN, 12));
        showPasswordCheckBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        showPasswordCheckBox.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                passwordField.setEchoChar((char)0); // Show password
            } else {
                passwordField.setEchoChar('•'); // Hide password
            }
        });
        formPanel.add(showPasswordCheckBox);
        
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(createButtonPanel(), BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        return label;
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Login and Cancel buttons (horizontal)
        JPanel loginCancelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        
        JButton loginButton = new JButton("Log In");
        loginButton.addActionListener(this::handleLogin);
        
        loginCancelPanel.add(cancelButton);
        loginCancelPanel.add(loginButton);
        
        // Back button (centered below)
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> {
            new DestinationSelector().setVisible(true);
            dispose();
        });
        
        // Add components with proper spacing
        panel.add(loginCancelPanel);
        panel.add(Box.createVerticalStrut(15)); // Space between button groups
        panel.add(backButton);
        
        return panel;
    }
    
    private void handleLogin(ActionEvent e) {
        String schoolNumber = schoolNumField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        
        if (validateLogin(schoolNumber, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            dispose();
            // Add your post-login navigation here
        } else {
            JOptionPane.showMessageDialog(this,
                    "Invalid school number or password", 
                    "Login Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validateLogin(String schoolNumber, String password) {
        // Add your actual validation logic here
        return !schoolNumber.isEmpty() && password.length() >= 6;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentLoginPage().setVisible(true));
    }
}
