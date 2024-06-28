import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GestionMarcas {
    private static ArrayList<String[]> marcas = new ArrayList<>();

    public static void main(String[] args) {
        // Datos iniciales de las marcas
        marcas.add(new String[]{"1", "Gucci", "Italia"});
        marcas.add(new String[]{"2", "Louis Vuitton", "Francia"});
        marcas.add(new String[]{"3", "Chanel", "Francia"});
        marcas.add(new String[]{"4", "Prada", "Italia"});
        marcas.add(new String[]{"5", "Hermès", "Francia"});
        marcas.add(new String[]{"6", "Ralph Lauren", "EE.UU."});
        marcas.add(new String[]{"7", "Burberry", "Reino Unido"});
        marcas.add(new String[]{"8", "Versace", "Italia"});
        marcas.add(new String[]{"9", "Armani", "Italia"});
        marcas.add(new String[]{"10", "Dior", "Francia"});

        // Crear la interfaz gráfica
        JFrame frame = new JFrame("Gestión de Marcas");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(10, 20, 80, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(100, 20, 165, 25);
        panel.add(idText);

        JLabel nameLabel = new JLabel("Nombre:");
        nameLabel.setBounds(10, 50, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(100, 50, 165, 25);
        panel.add(nameText);

        JLabel countryLabel = new JLabel("País:");
        countryLabel.setBounds(10, 80, 80, 25);
        panel.add(countryLabel);

        JTextField countryText = new JTextField(20);
        countryText.setBounds(100, 80, 165, 25);
        panel.add(countryText);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 150, 560, 200);
        panel.add(textArea);

        JButton searchButton = new JButton("Buscar");
        searchButton.setBounds(10, 110, 80, 25);
        panel.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idText.getText();
                boolean found = false;
                for (String[] marca : marcas) {
                    if (marca[0].equals(id)) {
                        nameText.setText(marca[1]);
                        countryText.setText(marca[2]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Marca no encontrada");
                }
            }
        });

        JButton showButton = new JButton("Mostrar");
        showButton.setBounds(100, 110, 80, 25);
        panel.add(showButton);

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for (String[] marca : marcas) {
                    textArea.append("ID: " + marca[0] + ", Nombre: " + marca[1] + ", País: " + marca[2] + "\n");
                }
            }
        });

        JButton deleteButton = new JButton("Eliminar");
        deleteButton.setBounds(190, 110, 80, 25);
        panel.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idText.getText();
                boolean found = false;
                for (int i = 0; i < marcas.size(); i++) {
                    if (marcas.get(i)[0].equals(id)) {
                        marcas.remove(i);
                        nameText.setText("");
                        countryText.setText("");
                        found = true;
                        break;
                    }
                }
                if (found) {
                    JOptionPane.showMessageDialog(null, "Marca eliminada");
                } else {
                    JOptionPane.showMessageDialog(null, "Marca no encontrada");
                }
            }
        });
    }
}

