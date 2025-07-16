
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
import java.awt.geom.Line2D;
import java.sql.*;
import java.util.*;
import java.util.List;

public class SchulstockwerkMitEtagen extends JFrame {
    private final String[] etagenNamen      = { "1. Obergeschoss", "2. Obergeschoss" };
    private final String[] stockwerkBilder  = { "stockwerk1.jpg", "stockwerk2.jpg" };

    private JComboBox<String> stundenAuswahl, etagenAuswahl;
    private JLayeredPane      layeredPane;
    private JLabel            backgroundLabel;
    private JPanel            raumPanel1, raumPanel2;
    private ArrowPanel        arrowPanel;
    private Map<String, JButton> raumButtons = new HashMap<>();

    public SchulstockwerkMitEtagen() {
        super("Schulplan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        stundenAuswahl = new JComboBox<>();
        for (int i = 1; i <= 9; i++) {
            stundenAuswahl.addItem("Stunde " + i);
        }
        etagenAuswahl = new JComboBox<>(etagenNamen);
        top.add(new JLabel("Stunde:")); top.add(stundenAuswahl);
        top.add(Box.createHorizontalStrut(20));
        top.add(new JLabel("Etage:"));  top.add(etagenAuswahl);
        add(top, BorderLayout.NORTH);

        layeredPane     = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1000, 700));

        backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 1000, 700);
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        raumPanel1 = createRaumPanel(1);
        raumPanel2 = createRaumPanel(2);
        layeredPane.add(raumPanel1, Integer.valueOf(1));
        layeredPane.add(raumPanel2, Integer.valueOf(1));

        arrowPanel = new ArrowPanel();
        arrowPanel.setBounds(0, 0, 1000, 700);
        layeredPane.add(arrowPanel, Integer.valueOf(2));

        add(layeredPane, BorderLayout.CENTER);

    
        etagenAuswahl.addActionListener(e -> {
            ladeEtage(etagenAuswahl.getSelectedIndex());
            markiereAktuelleStunde();
        });
        stundenAuswahl.addActionListener(e -> markiereAktuelleStunde());

        ladeEtage(0);
        setVisible(true);
    }

    private void ladeEtage(int idx) {
        ImageIcon icon = new ImageIcon(stockwerkBilder[idx]);
        Image img = icon.getImage()
                       .getScaledInstance(-1, 700, Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(img));

        raumPanel1.setVisible(idx == 0);
        raumPanel2.setVisible(idx == 1);
    }

    private JPanel createRaumPanel(int floor) {
        JPanel panel = new JPanel(null);
        panel.setOpaque(false);
        panel.setBounds(0, 0, 1000, 700);

        String[][] basis = {
            {"A120","30","60","120","80"},{"A121","150","60","120","80"},
            {"Treppe","260","60","60","80"},{"A101","320","60","140","80"},
            {"A102","460","60","120","80"},{"A103","570","60","120","80"},
            {"A104","680","60","120","80"},{"A105","800","60","100","140"},
            {"A106","800","200","100","100"},{"A107","800","300","100","100"},
            {"A119","30","140","120","80"},{"A118","30","220","120","80"},
            {"A117","30","300","120","80"},{"A116","30","380","120","80"},
            {"A115","30","460","120","80"},{"WC","30","540","200","80"},
            {"Durchgang","220","540","60","80"},{"A114","280","540","120","80"},
            {"A113","400","540","120","80"},{"A112","520","540","180","80"},
            {"A111","680","540","120","80"},{"A110","800","500","100","120"},
            {"A108","800","400","100","100"}
        };

        for (String[] r : basis) {
            String id = r[0];
            String label;
            if (id.matches("A\\d{3}")) {
                int num = Integer.parseInt(id.substring(1));
                label = "Raum A" + (floor * 100 + num % 100);
            } else {
                label = id;
            }
            int x = Integer.parseInt(r[1]),
                y = Integer.parseInt(r[2]),
                w = Integer.parseInt(r[3]),
                h = Integer.parseInt(r[4]);

            JButton btn = new JButton(label.equals("Durchgang") ? "" : label);
            btn.setBounds(x, y, w, h);
            btn.setOpaque(true);
            btn.addActionListener(e -> markiereRaumUndWeg(label));
            panel.add(btn);
            raumButtons.put(label, btn);
        }
        return panel;
    }

    private void markiereAktuelleStunde() {
        int st = stundenAuswahl.getSelectedIndex() + 1;
        String ziel = holeRaumAusStundenplan(st);
        if (ziel != null) {
            markiereRaumUndWeg(ziel);
        }
    }

    private void markiereRaumUndWeg(String ziel) {
        raumButtons.values().forEach(b -> b.setBackground(null));
        arrowPanel.clearArrows();

        
        List<String> pfad = Arrays.asList("Treppe", ziel);
        for (int i = 0; i < pfad.size(); i++) {
            JButton cur = raumButtons.get(pfad.get(i));
            if (cur != null) {
                cur.setBackground(Color.RED);
                if (i > 0) {
                    JButton prev = raumButtons.get(pfad.get(i - 1));
                    if (prev != null) {
                        Point p1 = getBoundaryPoint(prev, cur);
                        Point p2 = getBoundaryPoint(cur, prev);
                        arrowPanel.addArrow(p1, p2);
                    }
                }
            }
        }
        arrowPanel.repaint();
    }

    private Point getBoundaryPoint(JButton from, JButton to) {
        Rectangle a = from.getBounds();
        Rectangle b = to.getBounds();
        double dx = b.getCenterX() - a.getCenterX();
        double dy = b.getCenterY() - a.getCenterY();
        if (Math.abs(dx) > Math.abs(dy)) {
            int x = dx > 0 ? a.x + a.width : a.x;
            int y = a.y + a.height / 2;
            return new Point(x, y);
        } else {
            int x = a.x + a.width / 2;
            int y = dy > 0 ? a.y + a.height : a.y;
            return new Point(x, y);
        }
    }

    private String holeRaumAusStundenplan(int stunde) {
        String raum = null;
        int key = 100 + stunde;
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:datenbank.db");
             Statement s = c.createStatement()) {
            s.setQueryTimeout(30);
            ResultSet rs = s.executeQuery("SELECT room FROM Timetable WHERE time=" + key);
            if (rs.next()) raum = rs.getString("room");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return raum;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SchulstockwerkMitEtagen::new);
    }

    private static class ArrowPanel extends JPanel {
        private final List<Line2D.Double> arrows = new ArrayList<>();

        ArrowPanel() {
            setOpaque(false);
        }

        void addArrow(Point from, Point to) {
            arrows.add(new Line2D.Double(from.x, from.y, to.x, to.y));
        }

        void clearArrows() {
            arrows.clear();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(3));
            g2.setColor(Color.RED);
            for (Line2D.Double line : arrows) {
                drawArrow(g2,
                          new Point((int)line.getX1(), (int)line.getY1()),
                          new Point((int)line.getX2(), (int)line.getY2()));
            }
            g2.dispose();
        }

        private void drawArrow(Graphics2D g2, Point p1, Point p2) {
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            double phi = Math.toRadians(20);
            int barb = 10;
            double dx = p2.x - p1.x, dy = p2.y - p1.y;
            double theta = Math.atan2(dy, dx);
            for (int j = 0; j < 2; j++) {
                double rho = theta + (j == 0 ? phi : -phi);
                int x = (int) (p2.x - barb * Math.cos(rho));
                int y = (int) (p2.y - barb * Math.sin(rho));
                g2.drawLine(p2.x, p2.y, x, y);
            }
        }
    }
}