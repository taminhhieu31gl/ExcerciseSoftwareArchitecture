package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.QueueSender;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.google.gson.Gson;

import dao.ProductDAO;
import entities.Order;
import entities.OrderDetail;
import entities.Product;

public class UIOrder extends JFrame implements ActionListener{
	private TopicConnection tConnect = null;
	private TopicSession qSession = null;
	private Topic topic = null;
	JTable tableDsDoUong,tableDsDoUongDaDat;
	DefaultTableModel tableDsDoUongModel,tableDsDoUongDaDatModel;
	JTextField txtSoLuong, txtSoBan;
	JButton btnOK, btnOK2;
	ProductDAO productDAO = new ProductDAO();
	public UIOrder() throws NamingException, JMSException {
		Context ctx = new InitialContext();
		TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup("cfName");
		
		tConnect = factory.createTopicConnection();
		qSession = tConnect.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ctx.lookup("MyTopic");	
		tConnect.start();
		
		setTitle("Dat Do Uong");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Box bc,b1;
		bc = Box.createVerticalBox();
		add(bc);
		bc.add(b1 = Box.createHorizontalBox());
			b1.add(Box.createHorizontalStrut(150));
			b1.add(new JLabel("Bàn Số"));
			b1.add(txtSoBan = new JTextField());
			b1.add(Box.createHorizontalStrut(150));
		bc.add(b1 = Box.createHorizontalBox());
			b1.setBorder(BorderFactory.createTitledBorder("Danh Sách Đồ Uống"));
			String[] tieuDe = "Mã Đồ Uống;Tên Đồ Uống; Số Lượng Có;Đơn Giá".split(";");
			tableDsDoUongModel = new DefaultTableModel(tieuDe,0);
			tableDsDoUong = new JTable(tableDsDoUongModel) {
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
			b1.add(new JScrollPane(tableDsDoUong));
			tableDsDoUong.getTableHeader().setReorderingAllowed(false);
			tableDsDoUong.setAutoCreateRowSorter(true);
		bc.add(b1 = Box.createHorizontalBox());
			b1.add(Box.createHorizontalStrut(100));
			b1.add(new JLabel("Nhập Số Lượng"));
			b1.add(Box.createHorizontalStrut(20));
			b1.add(txtSoLuong = new JTextField());
			b1.add(Box.createHorizontalStrut(20));
			b1.add(btnOK = new JButton("Xác Nhận"));
			b1.add(Box.createHorizontalStrut(100));
		bc.add(b1 = Box.createHorizontalBox());
			b1.setBorder(BorderFactory.createTitledBorder("Hoá Đơn Đã Đặt"));
			String[] tieuDe1 = "Mã Đồ Uống;Tên Đồ Uống; Số Lượng Đặt ;Đơn Giá; Tổng Tiền".split(";");
			tableDsDoUongDaDatModel = new DefaultTableModel(tieuDe1,0);
			tableDsDoUongDaDat = new JTable(tableDsDoUongDaDatModel) {
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
			b1.add(new JScrollPane(tableDsDoUongDaDat));
			tableDsDoUongDaDat.getTableHeader().setReorderingAllowed(false);
			tableDsDoUongDaDat.setAutoCreateRowSorter(true);
		bc.add(b1 = Box.createHorizontalBox());
			b1.add(Box.createHorizontalStrut(100));
			b1.add(btnOK2 = new JButton("Xác Nhận Đặt Danh Sách Đồ Uống Này!"));
			b1.add(Box.createHorizontalStrut(100));
			//đăng ký sự kiện
			btnOK.addActionListener(this);
			btnOK2.addActionListener(this);
		docDSDoUong();
		setVisible(true);
	}
	private void xoaTableDSDoUong() {
		while(tableDsDoUongModel.getRowCount()>0) {
			tableDsDoUongModel.removeRow(0);
		}
	}
	private void docDSDoUong() {
		xoaTableDSDoUong();
		List<Product> list = productDAO.dsDoUong();
		list.forEach(x->{
			String[] rowData = {x.getId()+"",x.getTen(),x.getSoLuong()+"",x.getDonGia()+""};
			tableDsDoUongModel.addRow(rowData);
			tableDsDoUong.setModel(tableDsDoUongModel);
		});
		
	}
	
	
	public static void main(String[] args) {
		try {
			new UIOrder();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void xacNhanDatDoUong() {
		if(txtSoBan.getText().trim()==null || txtSoBan.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this,"Nhập Số Bàn");
			txtSoBan.requestFocus();
			return;
		}
		if(txtSoLuong.getText().trim()==null || txtSoLuong.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this,"Nhập Số Lượng");
			txtSoLuong.requestFocus();
			return;
		}
		if(tableDsDoUong.getSelectedRow()==-1) {
			JOptionPane.showMessageDialog(this,"Chọn Đồ Uống");
			return;
		}
		int row = tableDsDoUong.getSelectedRow();
		String soLuongDat = txtSoLuong.getText().toString();
		String ma = tableDsDoUong.getValueAt(row, 0).toString();
		String donGia = tableDsDoUong.getValueAt(row, 3).toString();
		boolean flag = true;
		for(int i=0;i<tableDsDoUongDaDat.getRowCount();i++) {
			if(ma.equals(tableDsDoUongDaDat.getValueAt(i, 0).toString())) {
				tableDsDoUongDaDat.setValueAt(soLuongDat, i, 2);
				tableDsDoUongDaDat.setValueAt(Integer.parseInt(soLuongDat)*Double.parseDouble(donGia), i, 4);
				flag = false;
			}
		}
		if(flag == true) {
			String ten = tableDsDoUong.getValueAt(row, 1).toString();
			double tongTien = Integer.parseInt(soLuongDat)*Double.parseDouble(donGia);
			Product p = new Product(Integer.parseInt(ma),ten,Integer.parseInt(soLuongDat), Double.parseDouble(donGia));
			String[] rowData = {ma, ten,soLuongDat,donGia,tongTien+""};
			tableDsDoUongDaDatModel.addRow(rowData);
			tableDsDoUongDaDat.setModel(tableDsDoUongDaDatModel);
		}
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if(src.equals(btnOK)) {
			xacNhanDatDoUong();
		}else if(src.equals(btnOK2)) {
			List<OrderDetail> list = new ArrayList<OrderDetail>();
			double tongTien = 0;
			if(tableDsDoUongDaDat.getRowCount()>0) {
				for(int i=0;i<tableDsDoUongDaDat.getRowCount();i++) {
					int soLuong = Integer.parseInt(tableDsDoUongDaDat.getValueAt(i,2).toString());
					int id = Integer.parseInt(tableDsDoUongDaDat.getValueAt(i, 0).toString());
					OrderDetail o = new OrderDetail(soLuong, productDAO.tim1DoUong(id));
					tongTien += productDAO.tim1DoUong(id).getDonGia()*soLuong;
					list.add(o);
				}
				
				Order or = new Order(LocalDate.now(), Integer.parseInt(txtSoBan.getText().toString()),tongTien , list);
				try {
					Gson gson = new Gson();
					String json = gson.toJson(or);
					TopicPublisher topicPublisher = qSession.createPublisher(topic);
					Message msg = qSession.createTextMessage(json);
					topicPublisher.send(msg);
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
	}
}
