import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.util.*;
import java.awt.BasicStroke;

public class Visualizer extends JPanel {

    private List<Node> nodes;
    private List<Integer> route;

    private int currentStep = 0;

    public Visualizer(List<Node> nodes, List<Integer> route) {
        this.nodes = nodes;
        this.route = route;

        // 🔥 animación simple
        javax.swing.Timer timer = new javax.swing.Timer(700, e -> {
            if (currentStep < route.size() - 1) {
                currentStep++;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // 🖤 fondo negro
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());

        int margin = 60;
        int scale = 5;

        // 🔵 dibujar nodos
        for (Node n : nodes) {
            int x = margin + (int)n.x * scale;
            int y = margin + (int)n.y * scale;

            g2.setColor(Color.CYAN);
            g2.fillOval(x, y, 10, 10);

            g2.setColor(Color.WHITE);
            g2.drawString("" + n.id, x + 5, y - 5);
        }

        // 🔴 dibujar ruta progresiva
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(2));

        for (int i = 0; i < currentStep; i++) {

            int a = route.get(i);
            int b = route.get(i + 1);

            Node n1 = nodes.get(a);
            Node n2 = nodes.get(b);

            int x1 = margin + (int)n1.x * scale;
            int y1 = margin + (int)n1.y * scale;

            int x2 = margin + (int)n2.x * scale;
            int y2 = margin + (int)n2.y * scale;

            g2.drawLine(x1, y1, x2, y2);
        }

        // 🔵 marcar inicio
        Node start = nodes.get(route.get(0));
        g2.setColor(Color.GREEN);
        g2.fillOval(
            margin + (int)start.x * scale,
            margin + (int)start.y * scale,
            14,
            14
        );

        // 📋 texto con lista de visitados
        g2.setColor(Color.WHITE);
        g2.drawString("Ruta actual:", 20, 20);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= currentStep && i < route.size(); i++) {
            sb.append(route.get(i)).append(" ");
        }

        g2.drawString(sb.toString(), 20, 40);
    }

    public static void show(List<Node> nodes, List<Integer> route) {
        JFrame frame = new JFrame("Route Optimization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);

        frame.add(new Visualizer(nodes, route));
        frame.setVisible(true);
    }
}