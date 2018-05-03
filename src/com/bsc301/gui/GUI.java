/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsc301.gui;

import com.bsc301.analytical.SentenceSplitter;
import com.bsc301.socialmedia.FacebookLoader;
import com.bsc301.socialmedia.TwitterLoader;
import com.bsc301.util.References;
import com.restfb.types.Post;
import edu.stanford.nlp.simple.Sentence;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import twitter4j.ResponseList;
import twitter4j.Status;

/**
 *
 * @author Mat
 */
public class GUI extends JFrame
{
    
    
    // Labels
    private JLabel lblAuthCodeTitle = new JLabel(References.STRING_FACEBOOK_AUTH_TOKEN_TITLE);
    private JLabel lblTwitterUsernameTitle = new JLabel(References.STRING_TWITTER_USERNAME_TITLE);
    private JLabel lblPotentialPhobiaTitle = new JLabel(References.STRING_POTENTIAL_PHOBIA_LIST_TITLE);
    private JLabel lblHelpSuggestionsTitle = new JLabel(References.STRING_HELP_TITLE);
    
    // Text fields
    private JTextField txtFacebookAuthToken = new JTextField();
    private JTextField txtTwitterUsername = new JTextField();
    
    // Buttons
    private JButton btnFacebookAuthToken = new JButton(References.STRING_BUTTON_SUBMIT_TEXT);
    private JButton btnTwitterUsername = new JButton(References.STRING_BUTTON_SUBMIT_TEXT);
    private JButton btnAnalyse = new JButton(References.STRING_BUTTON_ANALYSE_TEXT);
    
    // List
    private JList lstPotentialPhobias = new JList();
    
    // JTextArea
    private JTextArea txtHelpSuggestions = new JTextArea();
    
    // Panels
    private JPanel pnlPotentialPhobiaPanel = new JPanel(new BorderLayout());
    private JPanel pnlHelpPanel = new JPanel(new BorderLayout());
    private JSplitPane pnlSplitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnlPotentialPhobiaPanel, pnlHelpPanel);
    
    // Scroll Panes
    private JScrollPane sclMessageBox = new JScrollPane(txtHelpSuggestions, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    // Layout Manager
    private SpringLayout lomSpring = new SpringLayout();
    
    public GUI()
    {
        super(References.WINDOW_TITLE);
        
        this.setSize(References.WINDOW_SIZE_X, References.WINDOW_SIZE_Y);
        this.setLocation
        (
                (Toolkit.getDefaultToolkit().getScreenSize().width - References.WINDOW_SIZE_X) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - References.WINDOW_SIZE_Y) / 2
        );
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(lomSpring);
        
        Container pane = this.getContentPane();
        
        add(lblAuthCodeTitle);
        add(lblTwitterUsernameTitle);
        add(txtFacebookAuthToken);
        add(txtTwitterUsername);
        add(btnFacebookAuthToken);
        add(btnTwitterUsername);
        add(btnAnalyse);
        add(pnlSplitPanel);
        
        pnlPotentialPhobiaPanel.add(lstPotentialPhobias, BorderLayout.CENTER);
        pnlPotentialPhobiaPanel.add(lblPotentialPhobiaTitle, BorderLayout.NORTH);
        
        pnlHelpPanel.add(sclMessageBox, BorderLayout.CENTER);
        pnlHelpPanel.add(lblHelpSuggestionsTitle, BorderLayout.NORTH);
        
        // Facebook title
        lomSpring.putConstraint(SpringLayout.WEST, lblAuthCodeTitle, 5, SpringLayout.WEST, pane);
        lomSpring.putConstraint(SpringLayout.NORTH, lblAuthCodeTitle, 5, SpringLayout.NORTH, pane);
        lomSpring.putConstraint(SpringLayout.EAST, lblAuthCodeTitle, 5, SpringLayout.EAST, pane);
        
        // Facebook auth token button
        lomSpring.putConstraint(SpringLayout.NORTH, btnFacebookAuthToken, 5, SpringLayout.SOUTH, lblAuthCodeTitle);
        lomSpring.putConstraint(SpringLayout.EAST, btnFacebookAuthToken, -5, SpringLayout.EAST, pane);
        lomSpring.putConstraint(SpringLayout.WEST, btnFacebookAuthToken, -95, SpringLayout.EAST, pane);
        
        // Facebook text
        lomSpring.putConstraint(SpringLayout.WEST, txtFacebookAuthToken, 5, SpringLayout.WEST, pane);
        lomSpring.putConstraint(SpringLayout.NORTH, txtFacebookAuthToken, 5, SpringLayout.SOUTH, lblAuthCodeTitle);
        lomSpring.putConstraint(SpringLayout.EAST, txtFacebookAuthToken, -5, SpringLayout.WEST, btnFacebookAuthToken);
        lomSpring.putConstraint(SpringLayout.SOUTH, txtFacebookAuthToken, 0, SpringLayout.SOUTH, btnFacebookAuthToken);
        
        // Twitter title
        lomSpring.putConstraint(SpringLayout.WEST, lblTwitterUsernameTitle, 5, SpringLayout.WEST, pane);
        lomSpring.putConstraint(SpringLayout.NORTH, lblTwitterUsernameTitle, 5, SpringLayout.SOUTH, txtFacebookAuthToken);
        lomSpring.putConstraint(SpringLayout.EAST, lblTwitterUsernameTitle, 5, SpringLayout.EAST, pane);
        
        // Twitter username button
        lomSpring.putConstraint(SpringLayout.NORTH, btnTwitterUsername, 5, SpringLayout.SOUTH, lblTwitterUsernameTitle);
        lomSpring.putConstraint(SpringLayout.EAST, btnTwitterUsername, -5, SpringLayout.EAST, pane);
        lomSpring.putConstraint(SpringLayout.WEST, btnTwitterUsername, -95, SpringLayout.EAST, pane);
        
        // Twitter text
        lomSpring.putConstraint(SpringLayout.WEST, txtTwitterUsername, 5, SpringLayout.WEST, pane);
        lomSpring.putConstraint(SpringLayout.NORTH, txtTwitterUsername, 5, SpringLayout.SOUTH, lblTwitterUsernameTitle);
        lomSpring.putConstraint(SpringLayout.EAST, txtTwitterUsername, -5, SpringLayout.WEST, btnTwitterUsername);
        lomSpring.putConstraint(SpringLayout.SOUTH, txtTwitterUsername, 0, SpringLayout.SOUTH, btnTwitterUsername);
        
        // Analyse
        lomSpring.putConstraint(SpringLayout.NORTH, btnAnalyse, 5, SpringLayout.SOUTH, txtTwitterUsername);
        lomSpring.putConstraint(SpringLayout.EAST, btnAnalyse, -5, SpringLayout.EAST, pane);
        lomSpring.putConstraint(SpringLayout.WEST, btnAnalyse, 5, SpringLayout.WEST, pane);
        
        // Split Panel
        lomSpring.putConstraint(SpringLayout.WEST, pnlSplitPanel, 5, SpringLayout.WEST, pane);
        lomSpring.putConstraint(SpringLayout.NORTH, pnlSplitPanel, 5, SpringLayout.SOUTH, btnAnalyse);
        lomSpring.putConstraint(SpringLayout.EAST, pnlSplitPanel, -5, SpringLayout.EAST, pane);
        lomSpring.putConstraint(SpringLayout.SOUTH, pnlSplitPanel, -5, SpringLayout.SOUTH, pane);
        
        
        // Event listeners
        DefaultButtonActionListener alButtons = new DefaultButtonActionListener();
        btnFacebookAuthToken.addActionListener(alButtons);
        btnTwitterUsername.addActionListener(alButtons);
        
        setAnalyseEnabled();
    }
    
    public void flipVisibility()
    {
        this.setVisible(!this.isVisible());
    }
    
    public void setAnalyseEnabled()
    {
        if(!(btnFacebookAuthToken.isEnabled() && btnTwitterUsername.isEnabled()))
        {
            btnAnalyse.setEnabled(true);
        }
        else
        {
            btnAnalyse.setEnabled(false);
        }
    }
    
    
    public class DefaultButtonActionListener implements ActionListener
    {
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == btnFacebookAuthToken)
            {
                btnFacebookAuthToken.setText(References.STRING_BUTTON_LOADING_TEXT);
                btnFacebookAuthToken.setEnabled(false);
                Thread t = new Thread(new FacebookThread());
                t.start();
            }
            if(e.getSource() == btnTwitterUsername)
            {
                btnTwitterUsername.setText(References.STRING_BUTTON_LOADING_TEXT);
                btnTwitterUsername.setEnabled(false);
                Thread t = new Thread(new TwitterThread());
                t.start();
            }
        }
        
        public class FacebookThread implements Runnable
        {

            @Override
            public void run()
            {
                String authToken = txtFacebookAuthToken.getText();
                List<Post> posts = FacebookLoader.GetInstance().GetFacebookJsonString(authToken);
                List<String> sentences = SentenceSplitter.GetInstance().GenerateSentencesFromPosts(posts);
                
                for(int i = 1; i < sentences.size(); i++)
                {
                    String post = sentences.get(i - 1);
                    txtHelpSuggestions.append("-------------------------------------------------------------------------------------------\n");
                    txtHelpSuggestions.append("Sentence No: " + i + '\n');
                    txtHelpSuggestions.append(post + '\n');
                    txtHelpSuggestions.append("-------------------------------------------------------------------------------------------\n\n");
                }
                btnFacebookAuthToken.setText(References.STRING_BUTTON_READY_TEXT);
                setAnalyseEnabled();
            }
            
        }
        
        public class TwitterThread implements Runnable
        {
            @Override
            public void run()
            {
                String username = txtTwitterUsername.getText();
                List<Status> statuses = TwitterLoader.GetInstance().GetStatuses(username);
                if(statuses == null)
                {
                    txtHelpSuggestions.append("Twitter failure");
                }
                else
                {
                    for (Status s : statuses) {
                        List<Sentence> sentences = SentenceSplitter.GetInstance().GenerateSentencesFromPost(s);
                        txtHelpSuggestions.append("Post: \n");
                        for(int i = 1; i <= sentences.size(); i++)
                        {
                            Sentence status = sentences.get(i - 1);
                            txtHelpSuggestions.append("    -------------------------------------------------------------------------------------------\n");
                            txtHelpSuggestions.append("    Sentence No: " + i + '\n');
                            txtHelpSuggestions.append("    " + status.text() + '\n');
                            txtHelpSuggestions.append("    -------------------------------------------------------------------------------------------\n\n");
                        }
                    }
                    
                    
                    
                    
                }
                btnTwitterUsername.setText(References.STRING_BUTTON_READY_TEXT);
                setAnalyseEnabled();
            }
        }
        
    }
    
    
}
