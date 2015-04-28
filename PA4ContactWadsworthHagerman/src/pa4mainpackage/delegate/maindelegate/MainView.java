
package pa4mainpackage.delegate.maindelegate;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * The MainView Class: creates the main user interface window.
 *
 * @author John Hagerman , Ben Wadsworth
 * @version April 26, 2015
 */
public class MainView 
{
   
    private JMenuBar menuBar;
    private JRadioButtonMenuItem sortAscending, sortDescending;
    private JMenuItem menuFileExit, menuFileSave, menuAboutAbout, menuEditDeleteMax, menuEditDeleteMin,
                      menuEditDelete, menuEditAdd, menuSortFindMax, menuSortFindMin, menuFileOpen,
                      menuEditEditEntry, menuSearchByKey;
    private JFrame mainWindow, aboutFrame, deleteBox, minMaxBox;
    private JPanel north, south, tableAreaPanel, deleteBottom, minMaxBottom, topPanel, bigPanel;
    private JMenu menuFile, menuSort, menuAbout, menuEdit, menuSearch;
    private JButton closeAboutButton;
    private ActionListener viewAl , delAL, closAL, closeMinMaxAL, minDelAL, maxDelAL;
    private JScrollPane scrolledText;
    private JTextArea textAreaText;
    private Font font, font2, font3;
    private JLabel keyLabel, delLabel, minMaxLabel;
    private JFileChooser fileChooser;
    private JTextField keyInput;
    private JButton cancelBTN, delBTN, minMaxDelBTN, minMaxCancel;

   /**
    * Invokes mainMenu() method creating UI
    */
    public MainView()
    {
        mainMenu();  
        
    }//End of Constructor
    
   /**
    *  Creates and shows main user interface
    */
    private void mainMenu()
    {
        mainWindow = new JFrame();
        mainWindow.setTitle("Assignment IV: Directory");
        mainWindow.setSize( 800, 400);
        mainWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        mainWindow.setLayout( new BorderLayout());
        
        
        //File Tab
        menuFile = new JMenu("File");
        menuFile.setBackground(Color.gray);
        menuFileOpen = new JMenuItem("Open");
        menuFileOpen.setActionCommand("OPEN");
        
        menuFile.add(menuFileOpen);
        menuFileSave = new JMenuItem("Save");
        menuFileSave.setActionCommand("SAVE");
     
        menuFile.add(menuFileSave);
        menuFile.addSeparator();
        menuFileExit = new JMenuItem("Quit");
        menuFileExit.setActionCommand("QUIT");
     
        menuFile.add(menuFileExit);
        

        //Edit Tab
        menuEdit = new JMenu("Edit");
        menuEdit.setBackground(Color.gray);
        menuEditEditEntry = new JMenuItem("Edit Entry");
        menuEditEditEntry.setActionCommand("EDITENTRY");
     
        menuEdit.add(menuEditEditEntry);
        menuEditAdd = new JMenuItem("Add Entry");
        menuEditAdd.setActionCommand("ADD");
    
        menuEdit.add(menuEditAdd);
        menuEditDelete = new JMenuItem("Delete");
        menuEditDelete.setActionCommand("DELETE");
      
        menuEdit.add(menuEditDelete);
        menuEdit.addSeparator();
        menuEditDeleteMax = new JMenuItem("Delete Max");
        menuEditDeleteMax.setActionCommand("DELETEMAX");
                
        menuEdit.add( menuEditDeleteMax);
        menuEditDeleteMin = new JMenuItem("Delete Min");
        menuEditDeleteMin.setActionCommand("DELETEMIN");
        menuEdit.add(menuEditDeleteMin);
        
        
        //Sort Tab
        menuSort = new JMenu("Sort Directory");
        menuSort.setBackground(Color.gray);
        ButtonGroup group = new ButtonGroup();
        sortAscending = new JRadioButtonMenuItem("Ascending");
        sortAscending.setActionCommand("ASCENDING");
        sortAscending.setSelected(true);
        
        group.add(sortAscending);
        menuSort.add(sortAscending);
        sortDescending = new JRadioButtonMenuItem("Descending");
        sortDescending.setActionCommand("DESCENDING");
        
        group.add(sortDescending);
        menuSort.add(sortDescending);
        menuSort.addSeparator();
        menuSortFindMax = new JMenuItem("Find Max");
        menuSortFindMax.setActionCommand("FINDMAX");
       
        menuSort.add(menuSortFindMax);
        menuSortFindMin = new JMenuItem("Find Min");
        menuSortFindMin.setActionCommand("FINDMIN");
        
        menuSort.add(menuSortFindMin);
        
        
        //Search Tab
        menuSearch = new JMenu("Search");
        menuSearch.setBackground(Color.gray);
        menuSearchByKey = new JMenuItem("By Key");
        menuSearchByKey.setActionCommand("SEARCHBYKEY");
        menuSearch.add(menuSearchByKey);
        

        //About Tab
        menuAbout = new JMenu("About");
        menuAbout.setBackground(Color.gray);
        menuAboutAbout = new JMenuItem("About");
        menuAboutAbout.setActionCommand("ABOUT");
        
        menuAbout.add(menuAboutAbout);
        
        
        //adding menu bar
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.gray);
        mainWindow.setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuSort);
        menuBar.add(menuSearch);
        menuBar.add(menuAbout);
        
        //creating text area
        tableAreaPanel = new JPanel();
        tableAreaPanel.setLayout(new BorderLayout());
        tableAreaPanel.setLayout(new BoxLayout(tableAreaPanel,BoxLayout.PAGE_AXIS));
        
        //Label above text area
        keyLabel = new JLabel("ID       Last Name        First Name      Organization   "  +
                 "Phone Numbers   Email Addresses \n");  
        font2 = new Font("Courier New", Font.PLAIN, 12);
        keyLabel.setFont(font2);
         
        tableAreaPanel.add(keyLabel);
        
        //Settingof TextArea for output
        textAreaText = new JTextArea( );
        textAreaText.setBackground(Color.WHITE);
        font = new Font("Courier New", Font.PLAIN, 12);
        textAreaText.setFont(font );
        textAreaText.setEditable(false);
        scrolledText = new JScrollPane(textAreaText);
        tableAreaPanel.add(scrolledText);
        mainWindow.add(tableAreaPanel, BorderLayout.CENTER);
        
        mainWindow.setVisible(true);  
        
    }//End of mainMenu() method
    
    
    /**
     * This method creates and shows the about frame
     */
    public void showAbout()
    {
        //Setting up aboutFrame
        aboutFrame = new JFrame();
        aboutFrame.setTitle("About");
        aboutFrame.setLocationRelativeTo(null);
        aboutFrame.setSize(260,110);
        aboutFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        aboutFrame.setResizable(false);
        aboutFrame.setLayout( new BorderLayout() ); 
       
        //Setting layout and adding content
        north = new JPanel( new GridLayout(3,1));
        north.add(new JLabel(""));
        north.add(new JLabel("                   Ben Wadsworth"));
        north.add(new JLabel("                   John Hagerman"));
        
        south = new JPanel( new FlowLayout());
        closeAboutButton = new JButton("Close");
        closeAboutButton.setActionCommand("CLOSEABOUTWINDOW");
        closeAboutButton.addActionListener(viewAl);
        south.add(closeAboutButton);
        
        aboutFrame.add(north, BorderLayout.NORTH);
        aboutFrame.add(south, BorderLayout.SOUTH);  
        
        aboutFrame.setVisible(true);     
    
    }//End of showAbout() method
    
    
    /**
     * This method closes the aboutFrame
     */
    public void closeAbout()
    {
        aboutFrame.dispose();
        
    }//End of closeAbout() method
    
    
    /**
     *  Creates window for deleting by key
     */
    public void showDeleteBox()
    {
        deleteBox = new JFrame();
        deleteBox.setTitle("Delete By Key");
        deleteBox.setLocationRelativeTo(null);
        deleteBox.setSize(200,120);
        deleteBox.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        deleteBox.setResizable(false);
        
        bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel,BoxLayout.PAGE_AXIS));
        
        topPanel = new JPanel(new GridLayout(2,1,5,5));
        
        delLabel  = new JLabel("Enter Key");
        delLabel.setHorizontalAlignment(JLabel.CENTER);
        keyInput = new JTextField();
        
        topPanel.add(delLabel);
        topPanel.add(keyInput);
        
        
        
        deleteBottom = new JPanel( new FlowLayout());
        cancelBTN = new JButton("Cancel");
        cancelBTN.setActionCommand("CLOSEDELETEBOX");
        cancelBTN.addActionListener(closAL);
        delBTN = new JButton("Delete");
        delBTN.setActionCommand("DELETECONTACT");
        delBTN.addActionListener(delAL);
        
        deleteBottom.add(delBTN);
        deleteBottom.add(cancelBTN);
        
        bigPanel.add(topPanel);
        bigPanel.add(deleteBottom);
        
        deleteBox.add(bigPanel);
        
        deleteBox.setVisible(true);
        
    }//End of showDeleteBox() method
    
    
    public void endMinMAx()
    {
        minMaxBox.dispose();
    }
    
    public void reassuranceMin()
    {

        minMaxBox = new JFrame();
        minMaxBox.setTitle("Delete Min");
        minMaxBox.setLocationRelativeTo(null);
        minMaxBox.setSize(300,100);
        minMaxBox.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        minMaxBox.setResizable(false);
        
        bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel,BoxLayout.PAGE_AXIS));
        
        topPanel = new JPanel(new GridLayout(1,1,5,5));
        
        minMaxLabel = new JLabel("Are you sure you want to delete min?");
        minMaxLabel.setHorizontalAlignment(JLabel.CENTER);
        
        topPanel.add(minMaxLabel);

        
        minMaxBottom = new JPanel( new FlowLayout());
        minMaxCancel = new JButton("Cancel");
        minMaxCancel.setActionCommand("CANCELDELETEMINMAX");
        minMaxCancel.addActionListener(closeMinMaxAL);
        minMaxDelBTN = new JButton("Delete");
        minMaxDelBTN.setActionCommand("DELETEMINBTN");
        minMaxDelBTN.addActionListener(minDelAL);
        
        minMaxBottom.add(minMaxDelBTN);
        minMaxBottom.add(minMaxCancel);
        
        bigPanel.add(topPanel);
        bigPanel.add(minMaxBottom);
        
        minMaxBox.add(bigPanel);
        
        minMaxBox.setVisible(true);
        
    }
    
    public void reassuranceMax()
    {

        minMaxBox = new JFrame();
        minMaxBox.setTitle("Delete Max");
        minMaxBox.setLocationRelativeTo(null);
        minMaxBox.setSize(300,100);
        minMaxBox.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        minMaxBox.setResizable(false);
        
        bigPanel = new JPanel();
        bigPanel.setLayout(new BoxLayout(bigPanel,BoxLayout.PAGE_AXIS));
        
        topPanel = new JPanel(new GridLayout(1,1,5,5));
        
        minMaxLabel = new JLabel("Are you sure you want to delete max?");
        minMaxLabel.setHorizontalAlignment(JLabel.CENTER);
        
        topPanel.add(minMaxLabel);

        
        minMaxBottom = new JPanel( new FlowLayout());
        minMaxCancel = new JButton("Cancel");
        minMaxCancel.setActionCommand("CANCELDELETEMINMAX");
        minMaxCancel.addActionListener(closeMinMaxAL);
        minMaxDelBTN = new JButton("Delete");
        minMaxDelBTN.setActionCommand("DELETEMAXBTN");
        minMaxDelBTN.addActionListener(maxDelAL);
        
        minMaxBottom.add(minMaxDelBTN);
        minMaxBottom.add(minMaxCancel);
        
        bigPanel.add(topPanel);
        bigPanel.add(minMaxBottom);
        
        minMaxBox.add(bigPanel);
        
        minMaxBox.setVisible(true);
        
    }//End of incorrectInputMessageBox()
    
    /**
     * Gets the key entered by user
     * 
     * @return String input
     */
    public String getDeleteString()
    {
        return(keyInput.getText());

    }//End of getDeleteString() method
    
    
    /*
    *Closes the delete Window
    */
    public void closeDeleteBox()
    {
        
        deleteBox.dispose();
    }//End of closeDeleteBox() method
    
    
    /**
     *
     */
    public File openFile()
    {
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        File selectedFile = fileChooser.getSelectedFile();
        int result = fileChooser.showOpenDialog(mainWindow);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            selectedFile = fileChooser.getSelectedFile();
            return(selectedFile);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Cannot write to that file!", "alert", JOptionPane.ERROR_MESSAGE);
            return(null);
        }
    }//End of openFile() method
    
    public File saveFileName() throws IOException
    {
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        File selectedFile;
        
        int result = fileChooser.showSaveDialog(mainWindow);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            selectedFile = fileChooser.getSelectedFile();
            if(selectedFile.createNewFile())
                return(selectedFile);

            return(selectedFile);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Cannot write to that file!", "alert", JOptionPane.ERROR_MESSAGE);
            return(null);
        }
    }
    

    
    /**
     * This function takes the min as a string
     * and places it within a mono-spaced OptionPane
     * 
     * @param message //String representation of contact
     */
    public void findMin(String message)
    {
        font3 = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        UIManager.put("OptionPane.messageFont", font3);
        UIManager.put("OptionPane.buttonFont", font3);
        JOptionPane.showMessageDialog(null, message , "Find Min" ,
        JOptionPane.PLAIN_MESSAGE);
        
    }//End of findMin() method
    
    
    /**
     * This function takes the max as a string
     * and places it within a mono-spaced OptionPane
     * 
     * @param message  //String representation of contact
     */
    public void findMax(String message)
    {
        font3 = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        UIManager.put("OptionPane.messageFont", font3);
        UIManager.put("OptionPane.buttonFont", font3);
        JOptionPane.showMessageDialog(null, message , "Find Max",
        JOptionPane.PLAIN_MESSAGE);
        
    }//End of findMax() method
    
    

    
    /**
     * This method clears and updates the TextArea
     * 
     * @param x     //String representation of TreeMap
     */
    public void updateTextBox(String x)
    {
        textAreaText.removeAll();
        textAreaText.setText(x);
        
    }//End of updateTextBox() method
    
    
    /**
     * Method sets up listeners
     * 
     * @param al
     */
    public void setActionListeners(ActionListener al)
    {
        viewAl = al;
        menuFileOpen.addActionListener(al);
        menuFileSave.addActionListener(al);
        menuFileExit.addActionListener(al);
        menuAboutAbout.addActionListener(al);
        menuEditDeleteMax.addActionListener(al); 
        menuEditDeleteMin.addActionListener(al);          
        menuEditDelete.addActionListener(al);
        menuEditAdd.addActionListener(al);
        menuSortFindMax.addActionListener(al);
        menuSortFindMin.addActionListener(al);    
        menuEditEditEntry.addActionListener(al);
        sortDescending.addActionListener(al);
        sortAscending.addActionListener(al);
        closeMinMaxAL = al;
        minDelAL = al;
        maxDelAL = al;
        delAL = al;
        closAL = al;


        
    }//End setJButtonListeners method
 
}//End of MainView Class
