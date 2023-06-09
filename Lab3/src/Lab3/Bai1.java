package Lab3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Bai1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtFullName;
	private JTextField txtMark;
	private JTextField txtHocLuc;
	private JTable table;
	private ArrayList<Student> list = new ArrayList<>();
	private DefaultTableModel modelTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai1 frame = new Bai1();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void rest() {
		txtFullName.setText("");
		txtHocLuc.setText("");
		txtMark.setText("");

	}

	private void initTable() {
		modelTable = (DefaultTableModel) table.getModel();
		String[] cols = { "HỌ VÀ TÊN", "ĐIỂM", "NGÀNH", "HỌC LỰC", "THƯỞNG" };
		modelTable.setColumnIdentifiers(cols);
		table.setModel(modelTable);
	}

	private void initList() {
		list.add(new Student("Huỳnh Ngọc Hoài Thương", 8, "Phát triển phần mềm"));
		list.add(new Student("Khủng Long", 5, "Lập trình Web"));
		list.add(new Student("Bạch Khởi", 10, "Lập trình Mobile"));
		list.add(new Student("Cá mập", 9, "Phát triển phần mềm"));
		list.add(new Student("Cá cắn cáp", 6.6, "Ứng dụng phần mềm"));
	}

	private void fillTable() {
		// thiết lập số lượng dòng trong bảng thành 0
		modelTable = (DefaultTableModel) table.getModel();
		modelTable.setRowCount(0);
		for (Student st : list) {
			Object[] row = new Object[] { st.getFullname(), st.getMark(), st.getNganh(), st.hocLuc(), st.isBonus() };
			modelTable.addRow(row);
		}
//		table.setModel(modelTable);
	}

	/**
	 * Create the frame.
	 */
	public Bai1() {
		initTable();
		initList();
		fillTable();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQLSV = new JLabel("QUẢN LÝ SINH VIÊN");
		lblQLSV.setForeground(new Color(255, 0, 0));
		lblQLSV.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblQLSV.setBounds(177, -20, 255, 68);
		contentPane.add(lblQLSV);

		JLabel lblFullName = new JLabel("HỌ VÀ TÊN");
		lblFullName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFullName.setBounds(20, 70, 89, 22);
		contentPane.add(lblFullName);

		txtFullName = new JTextField();
		txtFullName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtFullName.setBounds(125, 65, 385, 33);
		contentPane.add(txtFullName);
		txtFullName.setColumns(10);

		JLabel lblMark = new JLabel("ĐIỂM");
		lblMark.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblMark.setBounds(20, 124, 51, 29);
		contentPane.add(lblMark);

		txtMark = new JTextField();
		txtMark.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMark.setBounds(125, 120, 385, 33);
		contentPane.add(txtMark);
		txtMark.setColumns(10);

		JLabel lnlNganh = new JLabel("NGÀNH");
		lnlNganh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lnlNganh.setBounds(20, 173, 74, 36);
		contentPane.add(lnlNganh);

		JComboBox cboNganh = new JComboBox();
		cboNganh.setModel(new DefaultComboBoxModel(
				new String[] { "Phát triển phần mềm", "Ứng dụng phần mềm", "Lập trình Mobile", "Lập trình Web" }));
		cboNganh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cboNganh.setBounds(125, 170, 182, 39);
		contentPane.add(cboNganh);

		JLabel lblHocLuc = new JLabel("HỌC LỰC");
		lblHocLuc.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHocLuc.setBounds(20, 220, 89, 30);
		contentPane.add(lblHocLuc);

		txtHocLuc = new JTextField();
		txtHocLuc.setEnabled(false);
		txtHocLuc.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtHocLuc.setText("");
		txtHocLuc.setBounds(125, 217, 385, 33);
		contentPane.add(txtHocLuc);
		txtHocLuc.setColumns(10);

		JCheckBox chkPhanThuong = new JCheckBox("Có phần thưởng?");
		chkPhanThuong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		chkPhanThuong.setHorizontalAlignment(SwingConstants.LEFT);
		chkPhanThuong.setBounds(125, 276, 144, 22);
		contentPane.add(chkPhanThuong);

		JButton btnDe = new JButton("XÓA");
		btnDe.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDe.setBounds(220, 327, 85, 21);
		contentPane.add(btnDe);

		JButton btnUp = new JButton("CẬP NHẬT");
		btnUp.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnUp.setBounds(315, 327, 105, 19);
		contentPane.add(btnUp);

		JButton btnNew = new JButton("NHẬP MỚI");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFullName.setText(null);
				txtMark.setText(null);
				txtMark.setText(null);
				cboNganh.setSelectedIndex(0);
				chkPhanThuong.setSelected(false);
			}
		});
		btnNew.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNew.setBounds(430, 326, 105, 21);
		contentPane.add(btnNew);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 370, 559, 177);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "HỌ VÀ TÊN", "ĐIỂM", "NGÀNH", "HỌC LỰC", "THƯỞNG" }));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		JButton btnAdd = new JButton("THÊM");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(btnAdd, "Thêm");
				if (txtFullName.getText().equals("")) {
					JOptionPane.showMessageDialog(btnAdd, "Bạn chưa nhập tên!", "ERROR", JOptionPane.WARNING_MESSAGE);
					txtFullName.setBackground(Color.red);
				} else if (txtMark.getText().equals("")) {
					JOptionPane.showMessageDialog(btnAdd, "Bạn chưa nhập điểm!", "ERROR", JOptionPane.WARNING_MESSAGE);
					txtMark.setBackground(Color.red);
				} else if (Double.parseDouble(txtMark.getText()) <= 10
						&& (Double.parseDouble(txtMark.getText()) >= 0)) {
					Student sv = new Student();
					sv.setFullname(txtFullName.getText());
					sv.setMark(Double.parseDouble(txtMark.getText()));
					sv.setNganh((String) cboNganh.getSelectedItem());
					list.add(sv);

					txtHocLuc.setText(sv.hocLuc());
					chkPhanThuong.setSelected(sv.isBonus());
					JOptionPane.showMessageDialog(btnAdd, "Thêm thành công!", "SUCCESS",
							JOptionPane.INFORMATION_MESSAGE);
					rest();
				} else {
					txtMark.setBackground(Color.red);
					JOptionPane.showMessageDialog(btnAdd, "Điểm không hợp lệ (0-10)!", "ERROR",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAdd.setBounds(107, 327, 105, 21);
		contentPane.add(btnAdd);
	}
}
