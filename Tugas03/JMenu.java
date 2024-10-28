package Tugas03;

	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	import java.awt.*;
	import java.awt.event.*;

	public class JMenu extends JFrame {
	    private JTextField txtNama;
	    private JTextArea txtAlamat;
	    private JRadioButton rbPria, rbWanita;
	    private JCheckBox cbMembaca, cbOlahraga, cbMusik;
	    private JComboBox<String> cbPendidikan;
	    private JList<String> listHobi;
	    private JSlider sliderUsia;
	    private JSpinner spinnerTahunLahir;
	    private JTable table;
	    private DefaultTableModel tableModel;

	    public JMenu() {
	        setTitle("Form Input Data");
	        setSize(800, 600);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        // Panel untuk form input
	        JPanel formPanel = new JPanel(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(5, 5, 5, 5);

	        // Komponen-komponen form
	        gbc.gridx = 0; gbc.gridy = 0;
	        formPanel.add(new JLabel("Nama:"), gbc);
	        gbc.gridx = 1;
	        txtNama = new JTextField(20);
	        formPanel.add(txtNama, gbc);

	        // Text Area untuk Alamat
	        gbc.gridx = 0; gbc.gridy = 1;
	        formPanel.add(new JLabel("Alamat:"), gbc);
	        gbc.gridx = 1;
	        txtAlamat = new JTextArea(3, 20);
	        formPanel.add(new JScrollPane(txtAlamat), gbc);

	        // Radio Button untuk Jenis Kelamin
	        gbc.gridx = 0; gbc.gridy = 2;
	        formPanel.add(new JLabel("Jenis Kelamin:"), gbc);
	        gbc.gridx = 1;
	        ButtonGroup bgGender = new ButtonGroup();
	        rbPria = new JRadioButton("Pria");
	        rbWanita = new JRadioButton("Wanita");
	        bgGender.add(rbPria);
	        bgGender.add(rbWanita);
	        JPanel genderPanel = new JPanel();
	        genderPanel.add(rbPria);
	        genderPanel.add(rbWanita);
	        formPanel.add(genderPanel, gbc);

	        // Checkbox untuk Hobi
	        gbc.gridx = 0; gbc.gridy = 3;
	        formPanel.add(new JLabel("Hobi:"), gbc);
	        gbc.gridx = 1;
	        JPanel hobiPanel = new JPanel();
	        cbMembaca = new JCheckBox("Membaca");
	        cbOlahraga = new JCheckBox("Olahraga");
	        cbMusik = new JCheckBox("Musik");
	        hobiPanel.add(cbMembaca);
	        hobiPanel.add(cbOlahraga);
	        hobiPanel.add(cbMusik);
	        formPanel.add(hobiPanel, gbc);

	        // ComboBox untuk Pendidikan
	        gbc.gridx = 0; gbc.gridy = 4;
	        formPanel.add(new JLabel("Pendidikan:"), gbc);
	        gbc.gridx = 1;
	        String[] pendidikan = {"SD", "SMP", "SMA", "D3", "S1", "S2", "S3"};
	        cbPendidikan = new JComboBox<>(pendidikan);
	        formPanel.add(cbPendidikan, gbc);

	        // List untuk Hobi
	        gbc.gridx = 0; gbc.gridy = 5;
	        formPanel.add(new JLabel("Minat:"), gbc);
	        gbc.gridx = 1;
	        String[] minat = {"Teknologi", "Seni", "Bisnis", "Kesehatan", "Pendidikan"};
	        listHobi = new JList<>(minat);
	        listHobi.setVisibleRowCount(4);
	        formPanel.add(new JScrollPane(listHobi), gbc);

	        // Slider untuk Usia
	        gbc.gridx = 0; gbc.gridy = 6;
	        formPanel.add(new JLabel("Usia:"), gbc);
	        gbc.gridx = 1;
	        sliderUsia = new JSlider(JSlider.HORIZONTAL, 17, 60, 25);
	        sliderUsia.setMajorTickSpacing(10);
	        sliderUsia.setMinorTickSpacing(1);
	        sliderUsia.setPaintTicks(true);
	        sliderUsia.setPaintLabels(true);
	        formPanel.add(sliderUsia, gbc);

	        // Spinner untuk Tahun Lahir
	        gbc.gridx = 0; gbc.gridy = 7;
	        formPanel.add(new JLabel("Tahun Lahir:"), gbc);
	        gbc.gridx = 1;
	        SpinnerModel yearModel = new SpinnerNumberModel(2000, 1950, 2024, 1);
	        spinnerTahunLahir = new JSpinner(yearModel);
	        formPanel.add(spinnerTahunLahir, gbc);

	        // Tombol Submit
	        gbc.gridx = 1; gbc.gridy = 8;
	        JButton btnSubmit = new JButton("Submit");
	        formPanel.add(btnSubmit, gbc);

	        // Tabel
	        String[] columns = {"Nama", "Alamat", "Jenis Kelamin", "Hobi", "Pendidikan", "Minat", "Usia", "Tahun Lahir"};
	        tableModel = new DefaultTableModel(columns, 0);
	        table = new JTable(tableModel);
	        JScrollPane scrollPane = new JScrollPane(table);

	        // Action Listener untuk tombol submit
	        btnSubmit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String nama = txtNama.getText();
	                String alamat = txtAlamat.getText();
	                String jenisKelamin = rbPria.isSelected() ? "Pria" : "Wanita";
	                
	                StringBuilder hobi = new StringBuilder();
	                if(cbMembaca.isSelected()) hobi.append("Membaca ");
	                if(cbOlahraga.isSelected()) hobi.append("Olahraga ");
	                if(cbMusik.isSelected()) hobi.append("Musik");
	                
	                String pendidikan = (String) cbPendidikan.getSelectedItem();
	                String minat = listHobi.getSelectedValue();
	                int usia = sliderUsia.getValue();
	                int tahunLahir = (Integer) spinnerTahunLahir.getValue();

	                Object[] row = {nama, alamat, jenisKelamin, hobi.toString(), 
	                              pendidikan, minat, usia, tahunLahir};
	                tableModel.addRow(row);
	                
	                // Reset form
	                txtNama.setText("");
	                txtAlamat.setText("");
	                bgGender.clearSelection();
	                cbMembaca.setSelected(false);
	                cbOlahraga.setSelected(false);
	                cbMusik.setSelected(false);
	                cbPendidikan.setSelectedIndex(0);
	                listHobi.clearSelection();
	                sliderUsia.setValue(25);
	                spinnerTahunLahir.setValue(2000);
	            }
	        });

	        // Menambahkan komponen ke frame
	        add(formPanel, BorderLayout.NORTH);
	        add(scrollPane, BorderLayout.CENTER);

	        setLocationRelativeTo(null);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            new JMenu().setVisible(true);
	        });
	    }
	}



