
package pa4mainpackage.delegate;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.BoxLayout;
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
import javax.swing.JTable;
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
    private JPanel panel1, north, south, tableAreaPanel, test;
    private JMenu menuFile, menuSort, menuAbout, menuEdit;
    private JButton closeAboutButton;
    private ActionListener viewAl;
    private JScrollPane scrolledText;
    private JTextArea textAreaText;
    private JLabel piss, piss2;
    private JTextField nameField, lastNameField, organizationField;
    //private static final int LINES = 21;
   // private static final int CHAR_PER_LINE = 15;
    private JScrollPane scrollpane;


    public MainView()
    {
        
        mainMenu();       
        
    }
    
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
        menuBar.add(menuAbout);
        
        //creating text area
        tableAreaPanel = new JPanel();
        tableAreaPanel.setLayout(new BorderLayout());
        tableAreaPanel.setLayout(new BoxLayout(tableAreaPanel,BoxLayout.PAGE_AXIS));
        
        JLabel keyLabel = new JLabel("ID       Last Name        First Name      Organization   "  +
                 "Phone Numbers   Email Addresses \n");
        
        Font font2 = new Font("Courier New", Font.PLAIN, 12);
        keyLabel.setFont(font2);
         
        tableAreaPanel.add(keyLabel);
        
        
        //JPanel textPanel = new JPanel();
        
       // JScrollPane scrollPane = new JScrollPane();
       // scrollpane = new JScrollPane();
    
       // setPreferredSize(new Dimension(450, 110));
     
       // mainWindow.add(scrollpane, BorderLayout.CENTER);

        

//textPanel.setBackground(Color.DARK_GRAY);
        //textAreaText = new JTextArea( LINES, CHAR_PER_LINE);
        textAreaText = new JTextArea( );
        textAreaText.setBackground(Color.WHITE);
        Font font = new Font("Courier New", Font.PLAIN, 12);
        textAreaText.setFont(font );
        textAreaText.setEditable(false);
        scrolledText = new JScrollPane(textAreaText);
        tableAreaPanel.add(scrolledText);
        mainWindow.add(tableAreaPanel, BorderLayout.CENTER);
        

        mainWindow.setVisible(true);  
    }
    

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
    
   // public void updateContactViewPanel(TreeMap contactTreeMap)
    //public void updateContactViewPanel()
   // {

        
        
    //    Set<Integer> keys = contactTreeMap.keySet();
    //    JScrollPane contactContainer = new JScrollPane();
    //   
    //    for(Integer key : keys)
    //   {
     //      JPanel tempPanel = new JPanel();
    //       tempPanel.add(new JLabel("Tits"));
      //     contactContainer.add(tempPanel);
     //  }
      
      //tableAreaPanel.add(contactContainer, BorderLayout.CENTER);
      
     //  mainWindow.getContentPane().add(tableAreaPanel);
     // mainWindow.pack(); 
   // }
    
    
   // public void updateTableArea(JTable table)
   // {
   //     tableAreaPanel.removeAll();
   //     JScrollPane spTable = new JScrollPane(table);
   //     spTable.setSize(tableAreaPanel.getWidth(), tableAreaPanel.getHeight());
    //    tableAreaPanel.add(spTable, BorderLayout.CENTER);
        
       // mainWindow.getContentPane().removeAll();
    //    mainWindow.getContentPane().add(tableAreaPanel);

    ///    mainWindow.pack();
    //}
    
    
    public void updateTextBox(String x)
    {
        textAreaText.removeAll();
        textAreaText.setText(x);
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
        sortDescending.addActionListener(al);
        sortAscending.addActionListener(al);
        
    }//End setJButtonListeners method
 
}
