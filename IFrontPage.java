/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaproject;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class IFrontPage extends JFrame {

    public IFrontPage() {
        // Set up the frame
        setTitle("PUPBC Smart Attendance Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null); // Center the window on screen

        // Main content panel with white background
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Center panel for logo and title
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // PUP Logo
        ImageIcon originalIcon = new ImageIcon("images/PUPLogo.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(380, 380, Image.SCALE_SMOOTH);
        JLabel logo = new JLabel(new ImageIcon(scaledImage));
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalGlue()); // Push content to vertical center
        centerPanel.add(logo);

        // Title label (unchanged from your original code)
        JLabel title = new JLabel(
            "<html><div style='text-align: center; color: #800000; font-weight: bold;'>" +
            "WELCOME TO PUP<br>BIÑAN CITE CAMPUS<br>SMART ATTENDANCE TRACKER" +
            "</div></html>"
        );
        title.setFont(new Font("Arial", Font.BOLD, 21));

        // Create a dedicated panel for perfect centering
        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setOpaque(false);
        titlePanel.add(title);

        centerPanel.add(Box.createVerticalGlue());  // Push content up
        centerPanel.add(titlePanel);
        centerPanel.add(Box.createVerticalGlue());  // Push content down
        centerPanel.add(Box.createVerticalStrut(20)); // Space before buttons

        // Button Panel (at bottom)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false); // Transparent background
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0)); // Add some bottom padding

        JButton startButton = new JButton("START");
        startButton.addActionListener((ActionEvent e) -> {
            new DestinationSelector().setVisible(true);
        });

        // Center buttons horizontally
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Set button sizes
        Dimension buttonSize = new Dimension(90, 30); // Slightly larger button
        startButton.setPreferredSize(buttonSize);
        startButton.setMaximumSize(buttonSize);

        buttonPanel.add(Box.createVerticalGlue()); // Push buttons down
        buttonPanel.add(startButton);
        buttonPanel.add(Box.createVerticalStrut(10));

        // Add components to main panel
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IFrontPage frame = new IFrontPage();
            frame.setVisible(true);
        });
    }
}