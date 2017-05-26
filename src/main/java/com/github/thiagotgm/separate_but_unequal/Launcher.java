package com.github.thiagotgm.separate_but_unequal;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.github.thiagotgm.separate_but_unequal.gui.GamePanel;
import com.github.thiagotgm.separate_but_unequal.resource.ResourceManager;

/**
 * Class that launches the game on startup.
 *
 * @version 1.0
 * @author Thiago
 * @since 2017-05-23
 */
public class Launcher {
    
    private static final double WIDTH_MULTIPLIER = 0.5;
    private static final double HEIGHT_MULTIPLIER = 0.8;
    private static final int FONT_DIVISOR = 70;
    
    public static int resolution;
    public static float fontMultiplier;

    public static void main( String[] args ) {

        ResourceManager.load();
        
        JFrame program = new JFrame( "Separate but UnEqual" );
        program.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Toolkit defKit = Toolkit.getDefaultToolkit();
        Dimension screenSize = defKit.getScreenSize();
        program.setSize( (int) ( screenSize.getWidth() * WIDTH_MULTIPLIER ),
                         (int) ( screenSize.getHeight() * HEIGHT_MULTIPLIER ) );
        resolution = defKit.getScreenResolution();
        fontMultiplier = resolution / FONT_DIVISOR;
        
        GamePanel panel = new GamePanel();
        panel.addActionListener( (e) -> {
            switch ( e.getActionCommand() ) {
                
                case GamePanel.SKIP_COMMAND:
                    System.out.println("Skip");
                    break;
                case GamePanel.UP_COMMAND:
                    System.out.println("Up");
                    break;
                case GamePanel.SELECT_COMMAND:
                    System.out.println("Select");
                    break;
                case GamePanel.DOWN_COMMAND:
                    System.out.println("Down");
                    break;
                
            }
        });
        program.add( panel );
        program.setVisible( true );
        GameManager manager = new GameManager( panel );
        manager.start( "Char 1 Start" );

    }

}
