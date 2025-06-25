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

public class StudentSignupPage extends JFrame {
    private JTextField nameField;
    private JTextField schoolNumField;
    private JTextField phoneField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JComboBox<String> courseComboBox;
    private JComboBox<String> yearlevelComboBox;
    private JCheckBox showPasswordCheckBox;

    public StudentSignupPage() {
        setTitle("Student Sign Up");
        setSize(500, 720); // Increased height for checkbox
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        // Title
        JLabel titleLabel = new JLabel("STUDENT SIGN UP", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(128, 0, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Form with left-aligned labels
        mainPanel.add(createFormPanel(), BorderLayout.CENTER);
        
        // Buttons
        mainPanel.add(createButtonPanel(), BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // Name
        formPanel.add(createLeftAlignedLabel("Name:"));
        nameField = new JTextField();
        addField(formPanel, nameField, "LastName, FirstName MiddleInitial");
        
        // School Number
        formPanel.add(createLeftAlignedLabel("School Number:"));
        schoolNumField = new JTextField();
        addField(formPanel, schoolNumField);
        
        // Course
        formPanel.add(createLeftAlignedLabel("Course:"));
        String[] courses = {"Select Course", "BSIT", "DIT", "BSCPE", "DCPET", "BSIE", "PSYCH"};
        courseComboBox = new JComboBox<>(courses);
        addComboBox(formPanel, courseComboBox);
        
        // Year Level
        formPanel.add(createLeftAlignedLabel("Year Level:"));
        String[] yearlevel = {"Select Year Level", "1-1", "1-2", "2-1", "2-2", "3-1", "3-2", "4-1", "4-2", "Ladderized"};
        yearlevelComboBox = new JComboBox<>(yearlevel);
        addComboBox(formPanel, yearlevelComboBox);
        
        // Phone
        formPanel.add(createLeftAlignedLabel("Phone Number:"));
        phoneField = new JTextField();
        addField(formPanel, phoneField, "09XXXXXXXXXX");
        
        // Email
        formPanel.add(createLeftAlignedLabel("Email:"));
        emailField = new JTextField();
        addField(formPanel, emailField, "example@iskolarngbayan.pup.edu.ph");
        
        // Password
        formPanel.add(createLeftAlignedLabel("Password:"));
        passwordField = new JPasswordField();
        addField(formPanel, passwordField);
        
        // Confirm Password
        formPanel.add(createLeftAlignedLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField();
        addField(formPanel, confirmPasswordField);
        
        // Show Password checkbox
        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setFont(new Font("Arial", Font.PLAIN, 12));
        showPasswordCheckBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        showPasswordCheckBox.addItemListener((ItemEvent e) -> {
            char echoChar = (e.getStateChange() == ItemEvent.SELECTED) ? (char)0 : '•';
            passwordField.setEchoChar(echoChar);
            confirmPasswordField.setEchoChar(echoChar);
        });
        formPanel.add(Box.createVerticalStrut(5)); // Small space before checkbox
        formPanel.add(showPasswordCheckBox);
        
        return formPanel;
    }
    
    // [Rest of the methods remain exactly the same as in your original code]
    // ... (createLeftAlignedLabel, addField, addComboBox, createButtonPanel, 
    // handleSignUp, validateForm, showError, processSignUp, main)
    
    private JLabel createLeftAlignedLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        return label;
    }
    
    private void addField(JPanel panel, JTextField field) {
        addField(panel, field, null);
    }
    
    private void addField(JPanel panel, JTextField field, String tooltip) {
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        field.setAlignmentX(Component.LEFT_ALIGNMENT);
        if (tooltip != null) {
            field.setToolTipText(tooltip);
        }
        panel.add(field);
        panel.add(Box.createVerticalStrut(15));
    }
    
    private void addComboBox(JPanel panel, JComboBox<String> comboBox) {
        comboBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(comboBox);
        panel.add(Box.createVerticalStrut(15));
    }
    
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.addActionListener(this::handleSignUp);
        
        buttonRow.add(cancelButton);
        buttonRow.add(signUpButton);
        
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> {
            new DestinationSelector().setVisible(true);
            dispose();
        });
        
        panel.add(buttonRow);
        panel.add(Box.createVerticalStrut(15));
        panel.add(backButton);
        
        return panel;
    }
    
    private void handleSignUp(ActionEvent e) {
        if (validateForm()) {
            if (processSignUp()) {
                JOptionPane.showMessageDialog(this,
                    "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }
    
    private boolean validateForm() {
        if (nameField.getText().isEmpty() || !nameField.getText().contains(",")) {
            showError("Please enter your full name in the format: LastName, FirstName MiddleInitial", "Invalid Name");
            return false;
        }
        
        if (schoolNumField.getText().isEmpty()) {
            showError("Please enter your school number", "School Number Required");
            return false;
        }
        
        if (courseComboBox.getSelectedIndex() == 0) {
            showError("Please select your course", "Course Required");
            return false;
        }
        
        if (yearlevelComboBox.getSelectedIndex() == 0) {
            showError("Please select your year level", "Year Level Required");
            return false;
        }
        
        if (!phoneField.getText().matches("09\\d{9}")) {
            showError("Please enter a valid 11-digit phone number starting with 09", "Invalid Phone");
            return false;
        }
        
        if (!emailField.getText().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            showError("Please enter a valid email address", "Invalid Email");
            return false;
        }
        
        if (passwordField.getPassword().length < 8) {
            showError("Password must be at least 8 characters long", "Weak Password");
            return false;
        }
        
        if (!java.util.Arrays.equals(passwordField.getPassword(), confirmPasswordField.getPassword())) {
            showError("Passwords do not match", "Password Mismatch");
            return false;
        }
        
        return true;
    }
    
    private void showError(String message, String title) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.WARNING_MESSAGE);
    }
    
    private boolean processSignUp() {
        String name = nameField.getText();
        String schoolNum = schoolNumField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String course = (String) courseComboBox.getSelectedItem();
        String yearLevel = (String) yearlevelComboBox.getSelectedItem();
        char[] password = passwordField.getPassword();
        
        System.out.println("Registering student: " + name + " (" + schoolNum + ") - " + course + " " + yearLevel);
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentSignupPage().setVisible(true));
    }
}