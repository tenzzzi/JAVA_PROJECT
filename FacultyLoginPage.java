/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

public class FacultyLoginPage extends JFrame {
    private JTextField nameField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;

    public FacultyLoginPage() {
        initializeFrame();
        setupUI();
    }

    private void initializeFrame() {
        setTitle("Faculty Login");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void setupUI() {
        // Main panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        // Add components to main panel
        mainPanel.add(createTitleLabel(), BorderLayout.NORTH);
        mainPanel.add(createFormPanel(), BorderLayout.CENTER);
        mainPanel.add(createButtonPanel(), BorderLayout.SOUTH);
        
        add(mainPanel);
    }

    private JLabel createTitleLabel() {
        JLabel titleLabel = new JLabel("FACULTY LOGIN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(128, 0, 0)); // Maroon color
        return titleLabel;
    }

    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // Name field
        formPanel.add(createLabel("Name:"));
        nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        formPanel.add(nameField);
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
        showPasswordCheckBox.addItemListener(this::togglePasswordVisibility);
        formPanel.add(showPasswordCheckBox);
        
        return formPanel;
    }

    private void togglePasswordVisibility(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            passwordField.setEchoChar((char) 0); // Show password
        } else {
            passwordField.setEchoChar('•'); // Hide password
        }
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
        
        // Login and Cancel buttons
        JPanel loginCancelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        loginCancelPanel.add(createCancelButton());
        loginCancelPanel.add(createLoginButton());
        
        // Back button
        JButton backButton = createBackButton();
        
        panel.add(loginCancelPanel);
        panel.add(Box.createVerticalStrut(15));
        panel.add(backButton);
        
        return panel;
    }

    private JButton createCancelButton() {
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        return cancelButton;
    }

    private JButton createLoginButton() {
        JButton loginButton = new JButton("Log In");
        loginButton.addActionListener(this::handleLogin);
        return loginButton;
    }

    private JButton createBackButton() {
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> {
            new DestinationSelector().setVisible(true);
            dispose();
        });
        return backButton;
    }

    private void handleLogin(ActionEvent e) {
        String name = nameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        
        if (validateLogin(name, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            dispose();
            // Add post-login navigation here
        } else {
            JOptionPane.showMessageDialog(this,
                    "Invalid credentials",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateLogin(String name, String password) {
        // Add actual validation logic here
        return !name.isEmpty() && password.length() >= 6;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FacultyLoginPage().setVisible(true));
    }
}