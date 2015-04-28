
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
    private JFrame mainWindow, aboutFrame, deleteBox, minBox, maxBox, searchBox;
    private JPanel north, south, tableAreaPanel, deleteBottom, minBottom, maxBottom, topPanel, bigPanel, minBigPanel,
            maxBigPanel, searchBigPanel, minTopPanel, maxTopPanel, searchTopPanel, searchBottom;
    private JMenu menuFile, menuSort, menuAbout, menuEdit, menuSearch;
    private ActionListener viewAl , delAL, closAL, minDelAL, maxDelAL, closeSearchAL, searchAL, closeMinAL, closeMaxAL;
    private JScrollPane scrolledText;
    private JTextArea textAreaText;
    private Font font, font2, font3;
    private JLabel keyLabel, delLabel, minLabel, maxLabel, searchLabel;
    private JFileChooser fileChooser;
    private JTextField keyInput, searchKeyInput;
    private JButton cancelBTN, delBTN, minDelBTN, maxDelBTN, minCancel, maxCancel, searchCancelBTN, searchBTN, closeAboutButton;

   /**
    * Invokes mainMenu() method creating UI
    */
    public MainView()
    {
        mainMenu();  
        
    }//End of Constructor
    
    
    //=============================WINDOWS======================================
    
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
    public void showAboutWindow()
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
     *  Creates window for deleting by key
     */
    public void showDeleteWindow()
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
        deleteBottom = new JPanel( new FlowLayout());
        cancelBTN = new JButton("Cancel");
        cancelBTN.setActionCommand("CLOSEDELETEBOX");
        cancelBTN.addActionListener(closAL);
        delBTN = new JButton("Delete");
        delBTN.setActionCommand("DELETECONTACT");
        delBTN.addActionListener(delAL);
        
        topPanel.add(delLabel);
        topPanel.add(keyInput);
        deleteBottom.add(delBTN);
        deleteBottom.add(cancelBTN);
        bigPanel.add(topPanel);
        bigPanel.add(deleteBottom);
        deleteBox.add(bigPanel); 
        deleteBox.setVisible(true);
        
    }//End of showDeleteBox() method
    
    
   /**
    * Window for checking if the user is sure they want to delete min
    */
    public void reassuranceMinWindow()
    {
        minBox = new JFrame();
        minBox.setTitle("Delete Min");
        minBox.setLocationRelativeTo(null);
        minBox.setSize(300,100);
        minBox.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        minBox.setResizable(false);
        
        minBigPanel = new JPanel();
        minBigPanel.setLayout(new BoxLayout(minBigPanel,BoxLayout.PAGE_AXIS));
        minTopPanel = new JPanel(new GridLayout(1,1,5,5));
        minLabel = new JLabel("Are you sure you want to delete min?");
        minLabel.setHorizontalAlignment(JLabel.CENTER);
        minBottom = new JPanel( new FlowLayout());
        minCancel = new JButton("Cancel");
        minCancel.setActionCommand("CANCELDELETEMIN");
        minCancel.addActionListener(closeMinAL);
        minDelBTN = new JButton("Delete");
        minDelBTN.setActionCommand("DELETEMINBTN");
        minDelBTN.addActionListener(minDelAL);
        
        minTopPanel.add(minLabel);
        minBottom.add(minDelBTN);
        minBottom.add(minCancel);
        minBigPanel.add(minTopPanel);
        minBigPanel.add(minBottom);
        minBox.add(minBigPanel);
        
        minBox.setVisible(true);
        
    }//End of reassuranceMinWindow
    
    
    /**
     * Window for checking if the user is sure they want to delete max
     */
    public void reassuranceMaxWindow()
    {
        maxBox = new JFrame();
        maxBox.setTitle("Delete Max");
        maxBox.setLocationRelativeTo(null);
        maxBox.setSize(300,100);
        maxBox.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        maxBox.setResizable(false);
        
        maxBigPanel = new JPanel();
        maxBigPanel.setLayout(new BoxLayout(maxBigPanel,BoxLayout.PAGE_AXIS));
        maxTopPanel = new JPanel(new GridLayout(1,1,5,5));
        maxLabel = new JLabel("Are you sure you want to delete max?");
        maxLabel.setHorizontalAlignment(JLabel.CENTER);
        maxBottom = new JPanel( new FlowLayout());
        maxCancel = new JButton("Cancel");
        maxCancel.setActionCommand("CANCELDELETEMAX");
        maxCancel.addActionListener(closeMaxAL);
        maxDelBTN = new JButton("Delete");
        maxDelBTN.setActionCommand("DELETEMAXBTN");
        maxDelBTN.addActionListener(maxDelAL);
        
        maxTopPanel.add(maxLabel);
        maxBottom.add(maxDelBTN);
        maxBottom.add(maxCancel);
        maxBigPanel.add(maxTopPanel);
        maxBigPanel.add(maxBottom);
        maxBox.add(maxBigPanel);
        
        maxBox.setVisible(true);
        
    }//End of incorrectInputMessageBox()
    
    
    /**
     * Window for searching by key
     */
    public void searchByKeyWindow()
    {   
        searchBox = new JFrame();
        searchBox.setTitle("Search By Key");
        searchBox.setLocationRelativeTo(null);
        searchBox.setSize(200,120);
        searchBox.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        searchBox.setResizable(false);
        
        searchBigPanel = new JPanel();
        searchBigPanel.setLayout(new BoxLayout(searchBigPanel,BoxLayout.PAGE_AXIS));
        searchTopPanel = new JPanel(new GridLayout(2,1,5,5));
        searchLabel  = new JLabel("Enter Search Key");
        searchLabel.setHorizontalAlignment(JLabel.CENTER);
        searchKeyInput = new JTextField();
        searchBottom = new JPanel( new FlowLayout());
        searchCancelBTN= new JButton("Cancel");
        searchCancelBTN.setActionCommand("CLOSEDSEARCHBOX");
        searchCancelBTN.addActionListener(closeSearchAL);
        searchBTN = new JButton("Search");
        searchBTN.setActionCommand("SEARCHBYKEYBTN");
        searchBTN.addActionListener(searchAL);
        
        searchTopPanel.add(searchLabel);
        searchTopPanel.add(searchKeyInput);
        searchBottom.add(searchBTN);
        searchBottom.add(searchCancelBTN);
        searchBigPanel.add(searchTopPanel);
        searchBigPanel.add(searchBottom);
        searchBox.add(searchBigPanel);
        
        searchBox.setVisible(true);
        
    }//End of searchByKeyWindow() method
    
    
    /**
     * This function takes the min as a string
     * and places it within a mono-spaced OptionPane
     * 
     * @param message //String representation of contact
     */
    public void findMinWindow(String message)
    {
        font3 = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        UIManager.put("OptionPane.messageFont", font3);
        UIManager.put("OptionPane.buttonFont", font3);
        JOptionPane.showMessageDialog(null, message , "Find Min" ,
        JOptionPane.PLAIN_MESSAGE);
        
    }//End of findMin() method
    
    public void searchWindow(String message)
    {
        font3 = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        UIManager.put("OptionPane.messageFont", font3);
        UIManager.put("OptionPane.buttonFont", font3);
        JOptionPane.showMessageDialog(null, message , "Search By Key" ,
        JOptionPane.PLAIN_MESSAGE);
        
    }//End of findMin() method
    
    
    /**
     * This function takes the max as a string
     * and places it within a mono-spaced OptionPane
     * 
     * @param message  //String representation of contact
     */
    public void findMaxWindow(String message)
    {
        font3 = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        UIManager.put("OptionPane.messageFont", font3);
        UIManager.put("OptionPane.buttonFont", font3);
        JOptionPane.showMessageDialog(null, message , "Find Max",
        JOptionPane.PLAIN_MESSAGE);
        
    }//End of findMaxWindow() method
    
    
    //========================================================================
    //====================Disposing Window Methods============================
    //========================================================================
    
    
   /*
    *Closes the delete Window
    */
    public void closeDeleteBox()
    {
        deleteBox.dispose();
    }//End of closeDeleteBox() method
    
    
   /**
    * This method closes the aboutFrame
    */
    public void closeAbout()
    {
        aboutFrame.dispose();
        
    }//End of closeAbout() method
    
    
    /**
     * Closes Find Min/Max Windows
     */
    public void endMin()
    {
        minBox.dispose();
        
    }//End of end MinMax() method
    
    
    public void endMax()
    {
        maxBox.dispose();
    }
    
    
    /**
     * Closes Search Box
     */
    public void closeSearchBox()
    {
        searchBox.dispose();
        
    }//End of closeSearchBox()
    
    
    
    //========================================================================
    //================================= ETC ==================================
    //========================================================================
    
    
    /**
     * Gets the key entered by user
     * 
     * @return String input
     */
    public String getDeleteString()
    {
        return(keyInput.getText());

    }//End of getDeleteString() method
    
    public String getSearchKey()
    {
        return(searchKeyInput.getText());
    }
    

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
        menuSearchByKey.addActionListener(al);
        sortDescending.addActionListener(al);
        sortAscending.addActionListener(al);
        closeMinAL = al;
        closeMaxAL = al;
        minDelAL = al;
        maxDelAL = al;
        delAL = al;
        closAL = al;
        closeSearchAL = al;
        searchAL = al;

        
    }//End setJButtonListeners method
 
}//End of MainView Class
