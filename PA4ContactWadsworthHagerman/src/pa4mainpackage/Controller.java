
package pa4mainpackage;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

/**
 *   Sets up the GUI
 * 
 * @author John Thomas Hagerman
 * @author Benjamin Awesomesauce Wadsworth
 */
public class Controller 
{
    private JMenuBar menuBar;
    private JRadioButtonMenuItem sortAscending, sortDescending;
    private JMenuItem menuFileExit, menuFileSave, menuAboutAbout, menuEditDeleteMax, menuEditDeleteMin,
                      menuEditDelete, menuEditAdd, menuSortFindMax, menuSortFindMin;
    private JFrame mainWindow, aboutFrame;
    private JPanel panel1, north, south;
    private JMenu menuFile, menuSort, menuAbout, menuEdit;
    private JButton closeAboutButton;

    
    
    public Controller()
    {
        mainMenu();
                
    }
    
    private void mainMenu()
    {
        mainWindow = new JFrame();
        mainWindow.setTitle("Assignment IV: Directory");
        mainWindow.setSize( 600, 400);
        mainWindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        mainWindow.setLayout( new BorderLayout());
        

        //File Tab
        menuFile = new JMenu("File");
        menuFileSave = new JMenuItem("Save");
        menuFileSave.addActionListener(new Controller.AllWidgetListener());
        menuFile.add(menuFileSave);
        menuFile.addSeparator();
        menuFileExit = new JMenuItem("Quit");
        menuFileExit.addActionListener(new Controller.AllWidgetListener());
        menuFile.add(menuFileExit);
        
        
        //Edit Tab
        menuEdit = new JMenu("Edit");
        menuEditAdd = new JMenuItem("Add");
        menuEditAdd.addActionListener(new Controller.AllWidgetListener());
        menuEdit.add(menuEditAdd);
        menuEditDelete = new JMenuItem("Delete");
        menuEditDelete.addActionListener(new Controller.AllWidgetListener());
        menuEdit.add(menuEditDelete);
        menuEdit.addSeparator();
        menuEditDeleteMax = new JMenuItem("Delete Max");
        menuEditDeleteMax.addActionListener(new Controller.AllWidgetListener());
        menuEdit.add( menuEditDeleteMax);
        menuEditDeleteMin = new JMenuItem("Delete Min");
        menuEditDeleteMin.addActionListener(new Controller.AllWidgetListener());
        menuEdit.add(menuEditDeleteMin);
        

        
        //Sort Tab
        menuSort = new JMenu("Sort Directory");
        ButtonGroup group = new ButtonGroup();
        sortAscending = new JRadioButtonMenuItem("Ascending");
        sortAscending.setSelected(true);
        sortAscending.addActionListener(new Controller.AllWidgetListener());
        group.add(sortAscending);
        menuSort.add(sortAscending);
        sortDescending = new JRadioButtonMenuItem("Descending");
        sortDescending.addActionListener(new Controller.AllWidgetListener());
        group.add(sortDescending);
        menuSort.add(sortDescending);
        menuSort.addSeparator();
        menuSortFindMax = new JMenuItem("Find Max");
        menuSortFindMax.addActionListener(new Controller.AllWidgetListener());
        menuSort.add(menuSortFindMax);
        menuSortFindMin = new JMenuItem("Find Min");
        menuSortFindMin.addActionListener(new Controller.AllWidgetListener());
        menuSort.add(menuSortFindMin);
        
        
        //About Tab
        menuAbout = new JMenu("About");
        menuAboutAbout = new JMenuItem("About");
        menuAboutAbout.addActionListener(new Controller.AllWidgetListener());
        menuAbout.add(menuAboutAbout);
        

        menuBar = new JMenuBar();
        mainWindow.setJMenuBar(menuBar);
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuSort);
        menuBar.add(menuAbout);
        
        mainWindow.setVisible(true);
        
    }
    
    private void showAbout()
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
        closeAboutButton.addActionListener(new AllWidgetListener() );
        south.add(closeAboutButton);
        
        aboutFrame.add(north, BorderLayout.NORTH);
        aboutFrame.add(south, BorderLayout.SOUTH);  
        
        aboutFrame.setVisible(true);     
    
    }//End of showAbout() method
    
     /**
     * This method closes the aboutFrame
     */
    private void closeAbout()
    {
        aboutFrame.dispose();
    
    }//End of closeAbout() method
  
    
    
    private class AllWidgetListener implements ActionListener
    {
         @Override
        public void actionPerformed( ActionEvent e)
        {
            String actionCommand = e.getActionCommand();
            
            if (actionCommand.equals( "Quit" ))
            {
                System.exit( 0 );
            }
            else if (actionCommand.equals( "Save"))
            {
                //Save action
            }
            else if (actionCommand.equals( "Ascending"))
            {
                System.exit( 0 );
            }
            else if (actionCommand.equals( "Descending"))
            {
                //Sort Action
            }
            else if (actionCommand.equals( "Add"))
            {
                //
            }
            else if (actionCommand.equals( "Delete"))
            {
                //
            }
            else if (actionCommand.equals( "Find Min"))
            {
                //
            }
            else if (actionCommand.equals( "Find Max"))
            {
                //
            }
            else if (actionCommand.equals( "About"))
            {
                showAbout();
            }
            if(e.getSource() == closeAboutButton)
            {
                closeAbout();  
            }
        
        }
 
    }

}
