import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Frame extends JFrame implements ActionListener {

    final int WIDTH = 500;
    final int HEIGHT = 500;

    public boolean login = false;
    public boolean register = false;

    private final JTextField ipAddressField;
    private final JTextField portTextField;
    private final JTextField usernameFieldLogin;
    private final JTextField usernameFieldRegister;
    private final JTextField passwordFieldLogin;
    private final JTextField passwordFieldRegister;
    private final JLabel connectionStatusLabel;

    private final JButton loginButton;
    private final JButton loginButtonConfirm;
    private final JButton registerButton;
    private final JButton registerButtonConfirm;
    private final JButton connectButton;
    private final JButton backButtonLogin;
    private final JButton backButtonRegister;

    private final JPanel textFieldPanel;
    private final JPanel loginPanel;
    private final JPanel registerPanel;

    private final Socket socket;

    public Frame(Socket socket) {

        super("Password Manager Client");
        this.socket = socket;
        setLayout(new FlowLayout());
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Add fields for IP Address and Port
        ipAddressField = new JTextField("localhost", 20);
        portTextField = new JTextField("8080", 5);
        textFieldPanel = new JPanel();
        textFieldPanel.add(new JLabel("IP Address:"));
        textFieldPanel.add(ipAddressField);
        textFieldPanel.add(new JLabel("Port:"));
        textFieldPanel.add(portTextField);
        add(textFieldPanel, BorderLayout.NORTH);

        // Add login and register buttons (hidden by default)
        JPanel regLogPanel = new JPanel();

        loginButton = new JButton("Login");
        loginButton.setSize(new Dimension(100, 20));
        loginButton.setVisible(false);

        registerButton = new JButton("Register");
        registerButton.setSize(new Dimension(100, 20));
        registerButton.setVisible(false);

        regLogPanel.add(loginButton);
        regLogPanel.add(registerButton);
        add(regLogPanel, BorderLayout.CENTER);

        // Back button
        backButtonLogin = new JButton("Back");
        backButtonLogin.setSize(new Dimension(100, 20));

        backButtonRegister = new JButton("Back");
        backButtonRegister.setSize(new Dimension(100, 20));

        // Confirm selection
        loginButtonConfirm = new JButton("Login");
        loginButtonConfirm.setSize(new Dimension(100, 20));

        registerButtonConfirm = new JButton("Register");
        registerButtonConfirm.setSize(new Dimension(100, 20));

        // Create login panel
        loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        usernameFieldLogin = new JTextField(20);
        c.gridx = 0;
        c.gridy = 0;
        loginPanel.add(new JLabel("Username:"), c);
        c.gridx = 1;
        loginPanel.add(usernameFieldLogin, c);

        passwordFieldLogin = new JPasswordField(20);
        c.gridx = 0;
        c.gridy = 1;
        loginPanel.add(new JLabel("Password:"), c);
        c.gridx = 1;
        loginPanel.add(passwordFieldLogin, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        loginPanel.add(loginButtonConfirm, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        loginPanel.add(backButtonLogin, c);

        add(loginPanel, BorderLayout.SOUTH);
        loginPanel.setVisible(false);

        // Create register panel
        registerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(5, 5, 5, 5);

        usernameFieldRegister = new JTextField(20);
        g.gridx = 0;
        g.gridy = 0;
        registerPanel.add(new JLabel("Username:"), g);
        g.gridx = 1;
        registerPanel.add(usernameFieldRegister, g);

        passwordFieldRegister = new JPasswordField(20);
        g.gridx = 0;
        g.gridy = 1;
        registerPanel.add(new JLabel("Password:"), g);
        g.gridx = 1;
        registerPanel.add(passwordFieldRegister, g);

        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = 2;
        g.anchor = GridBagConstraints.CENTER;
        registerPanel.add(registerButtonConfirm, g);

        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 2;
        g.anchor = GridBagConstraints.CENTER;
        registerPanel.add(backButtonRegister, g);

        add(registerPanel, BorderLayout.SOUTH);
        registerPanel.setVisible(false);

        // Create & set connection panel
        JPanel connectionPanel = new JPanel();
        connectionPanel.setLayout(new BoxLayout(connectionPanel, BoxLayout.Y_AXIS));
        connectionPanel.setPreferredSize(new Dimension(WIDTH, 300));

        // Add connect button
        connectButton = new JButton("Connect");
        connectButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(connectButton);

        // Add connection status label
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 100));
        connectionStatusLabel = new JLabel("Status: Not Connected");
        statusPanel.add(connectionStatusLabel);

        // Add button and status panels to the frame
        connectionPanel.add(buttonPanel, BorderLayout.SOUTH);
        connectionPanel.add(statusPanel);
        add(connectionPanel);

        // Show the frame
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            try {

                // Retrieve IP Address and Port from text fields
                String ipAddress = ipAddressField.getText();
                int port = Integer.parseInt(portTextField.getText());

                // Create a new Socket object and connect to the server
                InetSocketAddress socketAddress = new InetSocketAddress(ipAddress, port);
                socket.connect(socketAddress);
                System.out.println("Connected to " + socket.getInetAddress() + ":" + socket.getPort());

                connectionStatusLabel.setText("Connected to " + ipAddress + ":" + port);
                connectionStatusLabel.setForeground(Color.GREEN);

                // Add ActionListener to the login button to show the login panel
                loginButton.addActionListener(e1 -> showLogin());
                registerButton.addActionListener(e2 -> showRegister());
                backButtonLogin.addActionListener(e3 -> goBack());
                backButtonRegister.addActionListener(e4 -> goBack());
                loginButtonConfirm.addActionListener(e5 -> loginInfo());
                registerButtonConfirm.addActionListener(e6 -> registerInfo());

            } catch (Exception ex) {

                connectionStatusLabel.setText("Error: " + ex.getMessage());
                connectionStatusLabel.setForeground(Color.RED);
            }
    }

    public void showRegLogPanels() {

        textFieldPanel.setVisible(false);
        loginButton.setVisible(true);
        registerButton.setVisible(true);
        connectButton.setVisible(false);
    }

    public void showLogin() {

        loginPanel.setVisible(true);
        loginButton.setVisible(false);
        registerButton.setVisible(false);
        backButtonLogin.setVisible(true);
        loginButtonConfirm.setVisible(true);
    }

    public void showRegister() {

        registerPanel.setVisible(true);
        loginButton.setVisible(false);
        registerButton.setVisible(false);
        backButtonLogin.setVisible(true);
        registerButtonConfirm.setVisible(true);
    }

    public void goBack() {

        loginPanel.setVisible(false);
        registerPanel.setVisible(false);
        loginButton.setVisible(true);
        registerButton.setVisible(true);

        // Clears the text fields when going back
        /*usernameFieldLogin.setText("");
        passwordFieldLogin.setText("");
        usernameFieldRegister.setText("");
        passwordFieldRegister.setText("");*/
    }

    public String[] loginInfo() {

        String[] loginInfo = new String[2];
        loginInfo[0] = usernameFieldLogin.getText();
        loginInfo[1] = passwordFieldLogin.getText();
        login = true;
        register = false;
        return loginInfo;
    }

    public String[] registerInfo() {

        String[] registerInfo = new String[2];
        registerInfo[0] = usernameFieldRegister.getText();
        registerInfo[1] = passwordFieldRegister.getText();
        login = false;
        register = true;
        return registerInfo;
    }
}
