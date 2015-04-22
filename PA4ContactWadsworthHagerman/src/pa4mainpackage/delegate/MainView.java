
package pa4mainpackage.delegate;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import pa4mainpackage.model.ModelHandler;


public class MainView 
{
   
    private JMenuBar menuBar;
    private JRadioButtonMenuItem sortAscending, sortDescending;
    private JMenuItem menuFileExit, menuFileSave, menuAboutAbout, menuEditDeleteMax, menuEditDeleteMin,
                      menuEditDelete, menuEditAdd, menuSortFindMax, menuSortFindMin, menuFileOpen,
                      menuEditEditEntry;
    private JFrame mainWindow, aboutFrame, addFrame;
    private JPanel panel1, north, south;
    private JMenu menuFile, menuSort, menuAbout, menuEdit;
    private JButton closeAboutButton;
    private ActionListener viewAl;
    private JScrollPane scrolledText;
    private JTextArea textAreaText;
    private JTextField nameField, lastNameField, organizationField;
    private static final int LINES = 21;
    private static final int CHAR_PER_LINE = 61;


    public MainView()
    {
        mainMenu();            
    }
    
    private void mainMenu()
    {
        mainWindow = new JFrame();
        mainWindow.setTitle("Assignment IV: Directory");
        mainWindow.setSize( 750, 400);
        mainWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout( new BorderLayout());
        

        //File Tab
        menuFile = new JMenu("File");
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
        menuEditEditEntry = new JMenuItem("Edit Entry");
        menuEditEditEntry.setActionCommand("EDITENTRY");
     
        menuEdit.add(menuEditEditEntry);
        menuEditAdd = new JMenuItem("Add");
        menuEditAdd.setActionCommand("ADD");
    
        menuEdit.add(menuEditAdd);
        menuEditDelete = new JMenuItem("Delete");
      
        menuEdit.add(menuEditDelete);
        menuEdit.addSeparator();
        menuEditDeleteMax = new JMenuItem("Delete Max");
       
        menuEdit.add( menuEditDeleteMax);
        menuEditDeleteMin = new JMenuItem("Delete Min");
       
        menuEdit.add(menuEditDeleteMin);
        

        
        //Sort Tab
        menuSort = new JMenu("Sort Directory");
        ButtonGroup group = new ButtonGroup();
        sortAscending = new JRadioButtonMenuItem("Ascending");
        sortAscending.setSelected(true);
        
        group.add(sortAscending);
        menuSort.add(sortAscending);
        sortDescending = new JRadioButtonMenuItem("Descending");
        
        group.add(sortDescending);
        menuSort.add(sortDescending);
        menuSort.addSeparator();
        menuSortFindMax = new JMenuItem("Find Max");
       
        menuSort.add(menuSortFindMax);
        menuSortFindMin = new JMenuItem("Find Min");
        
        menuSort.add(menuSortFindMin);
        
        
        //About Tab
        menuAbout = new JMenu("About");
        menuAboutAbout = new JMenuItem("About");
        
        menuAbout.add(menuAboutAbout);
        
        //adding menu bar
        menuBar = new JMenuBar();
        mainWindow.setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuSort);
        menuBar.add(menuAbout);
        
        //creating text area
        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.DARK_GRAY);
        textAreaText = new JTextArea( LINES, CHAR_PER_LINE);
        textAreaText.setBackground(Color.WHITE);
        //Font font = new Font("Courier New", Font.PLAIN, 12);
        //textAreaText.setFont(font );
        scrolledText = new JScrollPane(textAreaText);
        textPanel.add(scrolledText);
        mainWindow.add(textPanel,BorderLayout.CENTER);
        

        mainWindow.setVisible(true);  
    }
    
//JOHN! LEGACY CODE BELOW??
    
//    private void addEntry()
//    {
//        addFrame = new JFrame();
//        addFrame.setTitle("Add Entry");
//        addFrame.setLocationRelativeTo(null);
//        addFrame.setSize(500,410);
//        addFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
//        addFrame.setResizable(false);
//      //  addFrame.setLayout( new BorderLayout() ); 
//        
//        nameField = new JTextField();
//        lastNameField = new JTextField();
//        addFrame.add(nameField);
//        addFrame.add(lastNameField);
//        
//        addFrame.setVisible(true);
//    }
    
    
    public void showAbout()
    {
        aboutFrame = new JFrame();
        aboutFrame.setTitle("About");
        aboutFrame.setLocationRelativeTo(null);
        aboutFrame.setSize(260,110);
        aboutFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        aboutFrame.setResizable(false);
        aboutFrame.setLayout( new BorderLayout() ); 
       
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
    
  
    public void openFile()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(mainWindow);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }
    }
    
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
    }//End setJButtonListeners method
 
}
