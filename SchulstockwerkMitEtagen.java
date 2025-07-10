
/**
 * Man kann das Schulstockwerk erzeugen (beide A-Stockwerke)
 * 
 * @author (Fabian/Besian) 
 * @version (09.07.2025)
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SchulstockwerkMitEtagen extends JFrame {
    
    private final String[] etagenNamen = {
        "1. Obergeschoss", "2. Obergeschoss"
    };
    
    private final String[] stockwerkBilder = {
        "stockwerk1.jpg", "stockwerk2.jpg"
    };

    private JComboBox<String> etagenAuswahl;
    private JLayeredPane layeredPane;
    private JLabel backgroundLabel;
    private JPanel raumPanel1;   
    private JPanel raumPanel2;   

    public SchulstockwerkMitEtagen() {
        setTitle("Schulplan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        etagenAuswahl = new JComboBox<>(etagenNamen);
        topPanel.add(new JLabel("Etage:"));
        topPanel.add(etagenAuswahl);
        add(topPanel, BorderLayout.NORTH);

        
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1000, 700));

        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 1000, 700);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        
        raumPanel1 = createRaumPanel(1);
        raumPanel2 = createRaumPanel(2);
        layeredPane.add(raumPanel1, Integer.valueOf(1));
        layeredPane.add(raumPanel2, Integer.valueOf(1));

        add(layeredPane, BorderLayout.CENTER);

        
        etagenAuswahl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idx = etagenAuswahl.getSelectedIndex();
                ladeEtage(idx);
            }
        });

        
        ladeEtage(0);
        setVisible(true);
    }

    
    private void ladeEtage(int index) {
        ladeBild(stockwerkBilder[index]);
        
        raumPanel1.setVisible(index == 0);
        raumPanel2.setVisible(index == 1);
    }

    
    private void ladeBild(String pfad) {
        ImageIcon icon = new ImageIcon(pfad);
        Image scaled = icon.getImage()
                           .getScaledInstance(-1, 700, Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(scaled));
    }

    /**
     * Baut ein transparentes Panel mit Raum-Buttons auf.
     * floor=1 → Raumnummern A1xx, floor=2 → Raumnummern A2xx
     */
    private JPanel createRaumPanel(int floor) {
        JPanel panel = new JPanel(null);
        panel.setOpaque(false);
        panel.setBounds(0, 0, 1000, 700);

        
        String[][] basis = {
            {"A120","30","60","120","80"},  {"A121","150","60","120","80"},
            {"Treppe","260","60","60","80"}, {"A101","320","60","140","80"},
            {"A102","460","60","120","80"},  {"A103","570","60","120","80"},
            {"A104","680","60","120","80"},  {"A105","800","60","100","140"},
            {"A106","800","200","100","100"},{"A107","800","300","100","100"},
            {"A119","30","140","120","80"},  {"A118","30","220","120","80"},
            {"A117","30","300","120","80"},  {"A116","30","380","120","80"},
            {"A115","30","460","120","80"},  {"WC","30","540","200","80"},
            {"Durchgang","220","540","60","80"},{"A114","280","540","120","80"},
            {"A113","400","540","120","80"},{"A112","520","540","180","80"},
            {"A111","680","540","120","80"},{"A110","800","500","100","120"},
            {"A108","800","400","100","100"}
        };

        for (String[] r : basis) {
            final String id = r[0];
            
            final String roomLabel;
            if (id.matches("A\\d{3}")) {
                int num = Integer.parseInt(id.substring(1));  
                int newNum = floor * 100 + (num % 100);
                roomLabel = "Raum A" + newNum;
            } else {
                roomLabel = id;  
            }

            int x = Integer.parseInt(r[1]);
            int y = Integer.parseInt(r[2]);
            int w = Integer.parseInt(r[3]);
            int h = Integer.parseInt(r[4]);

            JButton btn = new JButton(roomLabel.equals("Durchgang") ? "" : roomLabel);
            btn.setBounds(x, y, w, h);
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    zeigeInfo(roomLabel);
                }
            });
            panel.add(btn);
        }

        return panel;
    }

    private void zeigeInfo(String text) {
        JOptionPane.showMessageDialog(
            this,
            text,
            "Rauminfo",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SchulstockwerkMitEtagen();
            }
        });
    }
}