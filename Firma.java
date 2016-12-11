import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Firma extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	Vector<Room> vectors = new Vector<Room>();
	ArrayList<Room> array = new ArrayList<Room>();
	LinkedList<Room> llist = new LinkedList<Room>();
	HashSet<Room> hash = new HashSet<Room>();
	TreeSet<Room> tree = new TreeSet<Room>();
	
	WidokKolekcji widokVector;
	WidokKolekcji widokArray;
	WidokKolekcji widokLinked;
	WidokKolekcji widokHash;
	WidokKolekcji widokTree;
	
	JLabel etykieta_budynek  = new JLabel("Budynek:");
	JTextField pole_budynek  = new JTextField(10);
	JLabel etykieta_pokoj  = new JLabel("Pokój:");
	JTextField pole_pokoj  = new JTextField(10);
	JLabel etykieta_opis  = new JLabel("Opis:");
	JTextField pole_opis  = new JTextField(10);
	JButton przycisk_dodaj   = new JButton("Dodaj");
	JButton przycisk_usun    = new JButton("Usun");
	JButton przycisk_wyczysc = new JButton("Wyczysc");
	JButton przycisk_autor   = new JButton("Autor");
	
	public Firma(){
		super("Zadanie 2");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(830,500);
		
		JPanel panel = new JPanel();
		panel.add(etykieta_budynek);
		panel.add(pole_budynek);
		panel.add(etykieta_pokoj);
		panel.add(pole_pokoj);
		panel.add(etykieta_opis);
		panel.add(pole_opis);
		przycisk_dodaj.addActionListener(this);
		panel.add(przycisk_dodaj);
		
		przycisk_wyczysc.addActionListener(this);
		panel.add(przycisk_wyczysc);
		
		przycisk_usun.addActionListener(this);
		panel.add(przycisk_usun);
		
		przycisk_autor.addActionListener(this);
		panel.add(przycisk_autor);
		
		widokVector = new WidokKolekcji(vectors, 200, 200, "Vector");
		panel.add(widokVector);
		widokArray = new WidokKolekcji(array, 200, 200, "ArreyList");
		panel.add(widokArray);
		widokLinked = new WidokKolekcji(llist, 200, 200, "LinkedList");
		panel.add(widokLinked);
		widokHash = new WidokKolekcji(hash, 200, 200, "HashSet");
		panel.add(widokHash);
		widokTree = new WidokKolekcji(tree, 200, 200, "TreeSet");
		panel.add(widokTree);
		
		setContentPane(panel);
		setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Room wartosc = new Room();
		Object zrodlo = e.getSource();
		
		if (zrodlo == przycisk_dodaj) {
			wartosc.setSymbol(pole_budynek.getText());
			wartosc.setPokoj(Integer.parseInt(pole_pokoj.getText()));
			wartosc.setOpis(pole_opis.getText());
			vectors.add(wartosc);
			array.add(wartosc);
			llist.add(wartosc);
			hash.add(wartosc);
			tree.add(wartosc);
			
		} else

		if (zrodlo == przycisk_wyczysc) {
			vectors.clear();
			array.clear();
			llist.clear();
			hash.clear();
			tree.clear();
		} else

		if (zrodlo == przycisk_usun) {
			/*wartosc = pole_budynek.getText();
			vectors.remove(wartosc);
			array.remove(wartosc);
			llist.remove(wartosc);
			hash.remove(wartosc);
			tree.remove(wartosc);*/
		} else

		if (zrodlo == przycisk_autor) {
			JOptionPane.showMessageDialog(this,
					"Autor: Miko³aj Brukiewicz\nData: 11 grudzien 2016 r.");
		}

		widokVector.refresh();
		widokArray.refresh();
		widokLinked.refresh();
		widokHash.refresh();
		widokTree.refresh();
	}

	class WidokKolekcji extends JScrollPane{
		private static final long serialVersionUID = 1L;
		
		private JTable tabela;
		private DefaultTableModel model;
		private Collection<Room> kolekcja;
		
		WidokKolekcji(Collection<Room> kolekcja, int szerokosc, int wysokosc, String nazwa){
			String[] kolumny = {"Budynek", "Pokój", "Opis"};
			model = new DefaultTableModel(kolumny, 0);
			tabela = new JTable(model);
			tabela.setRowSelectionAllowed(false);
			this.kolekcja = kolekcja;
			setViewportView(tabela);
			setPreferredSize(new Dimension(szerokosc, wysokosc));
			setBorder(BorderFactory.createTitledBorder(nazwa));
			}
		
			void refresh(){
		    	model.setRowCount(0);
				Room[] wartosc = kolekcja.toArray(new Room[0]);
				for(Room x : wartosc){
					String[] wiersz = {x.getSymbol(), Integer.toString(x.getPokoj()), x.getOpis()};
					model.addRow(wiersz);
		    	}
			}
		
	}
	
	public static void main(String [] args){
		new Firma();
	}
}
