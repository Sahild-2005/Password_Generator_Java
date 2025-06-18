// render the GUI components (frontend)
// this class will inherit from the Jframe class

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
        // render fram and add a title
        super("Password Generator");

        //set the size of GUI
        setSize(540, 570);

        // prevent GUI from being able to resized
        setResizable(false);

        // we will set the layout to be null to have control over the position and size of our components in our app
        setLayout(null);

        // exit the program when GUI is closed

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //center the GUI
        setLocationRelativeTo(null);

        //init password generator

        passwordGenerator = new PasswordGenerator();

        // render GUI components
        addGuiComponents();

    }
    private void addGuiComponents(){
        // create title text
        JLabel titleLabel = new JLabel("Password Generator");

        //increase the font size
        titleLabel.setFont(new Font("Dialog", Font.BOLD,32));

        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //set x,y coordinates and weight and height values

        titleLabel.setBounds(0,10,540,39);

        //add to GUI
        add(titleLabel);

        // create result text area
        JTextArea passwordOutput = new JTextArea();
        // prevent editing the text area
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog",Font.BOLD,32));

        // add scrollablity in case output becomes too big
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25,97,479,70);

        // Create the black border around output text

        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        add(passwordOutputPane);

          // create password length label box
        JLabel passwordLengthLabel = new JLabel("Password Length");
        passwordLengthLabel.setFont(new Font("Dailog",Font.BOLD,32));
        passwordLengthLabel.setBounds(25,215,272,39);
        add(passwordLengthLabel);

        // create password length input

        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dailog",Font.PLAIN,32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310,215,192,39);
        add(passwordLengthInputArea);

        // Create buttons such as UpperCase, LowerCase, Numbers ,Symbols.
        //uppercase
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dailog",Font.PLAIN,26));
        uppercaseToggle.setBounds(25,302,225,56);
        add(uppercaseToggle);

        // lowercase
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dailog",Font.PLAIN,26));
        lowercaseToggle.setBounds(282,302,225,56);
        add(lowercaseToggle);

        //numbers
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dailog",Font.PLAIN,26));
        numbersToggle.setBounds(25,373,225,56);
        add(numbersToggle);

        //symbols toggle
        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dailog",Font.PLAIN,26));
        symbolsToggle.setBounds(282,373,225,56);

        add(symbolsToggle);

     //create generate button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dailog",Font.PLAIN,32));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // validation : generate a password only when length >0 and one of the toggled buttons is pressed
            if(passwordLengthInputArea.getText().length() <=0) return;
            boolean anyToggleSelected = lowercaseToggle.isSelected() || uppercaseToggle.isSelected() ||
                    numbersToggle.isSelected() || symbolsToggle.isSelected();

            //generate password
                //coverts thw text to an integer value
                int passwordLength = Integer.parseInt(passwordLengthInputArea.getText());

                if(anyToggleSelected){
                    String generatedPassword = passwordGenerator.generatePassword(passwordLength,
                            uppercaseToggle.isSelected(),
                            lowercaseToggle.isSelected(),
                            numbersToggle.isSelected(),
                            symbolsToggle.isSelected());

                    //display password back to the user
                    passwordOutput.setText(generatedPassword);
                }

            }
        });
        add(generateButton);
    }
}
