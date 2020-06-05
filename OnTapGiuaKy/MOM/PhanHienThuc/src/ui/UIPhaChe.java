package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.google.gson.Gson;

import dao.OrderDAO;
import dao.ProductDAO;
import entities.Order;
import entities.OrderDetail;
import entities.Product;

public class UIPhaChe  extends JFrame implements MessageListener, ActionListener{
	private TopicConnection tConnect = null;
	private TopicSession tSession = null;
	private Topic topic = null;
	OrderDAO orderDAO = new OrderDAO();
	ProductDAO productDAO = new ProductDAO();
	JTable tableDsDoUong, tableDsHoaDon;
	JButton btnOK;
	DefaultTableModel tableDsDoUongModel,tableDsHoaDonModel;
	public UIPhaChe() throws NamingException, JMSException {
		Context ctx = new InitialContext();
		TopicConnectionFactory factory = (TopicConnectionFactory) ctx.lookup("cfName");
		
		tConnect = factory.createTopicConnection();
		tSession = tConnect.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ctx.lookup("MyTopic");	
		tConnect.start();
		TopicSubscriber tSubscribrer =tSession.createSubscriber(topic);
		tSubscribrer.setMessageListener(this);
		
		setTitle("Danh Sách Pha Chế");
		setSize(600,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Box bc,b1;
		bc = Box.createVerticalBox();
		add(bc);

		bc.add(b1 = Box.createHorizontalBox());
			b1.setBorder(BorderFactory.createTitledBorder("Danh Sách Hoá Đơn"));
			String[] tieuDe = "STT Hoá Đơn;Ngày Tạo;Bàn Số;Tổng Tiền".split(";");
			tableDsHoaDonModel = new DefaultTableModel(tieuDe,0);
			tableDsHoaDon = new JTable(tableDsHoaDonModel) {
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
			b1.add(new JScrollPane(tableDsHoaDon));
			tableDsHoaDon.getTableHeader().setReorderingAllowed(false);
			tableDsHoaDon.setAutoCreateRowSorter(true);
		bc.add(b1 = Box.createHorizontalBox());
			b1.add(Box.createHorizontalStrut(100));
			b1.add(btnOK = new JButton("Pha Chế Hoàn Thành"));
			b1.add(Box.createHorizontalStrut(100));
			
		bc.add(b1 = Box.createHorizontalBox());
			b1.setBorder(BorderFactory.createTitledBorder("Danh Sách Đồ Uống Trong Hoá Đơn"));
			String[] tieuDe2 = "STT Hoá Đơn;Bàn Số;Mã Đồ Uống;Tên Đồ Uống;Số Lượng".split(";");
			tableDsDoUongModel = new DefaultTableModel(tieuDe2,0);
			tableDsDoUong = new JTable(tableDsDoUongModel) {
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
			b1.add(new JScrollPane(tableDsDoUong));
			tableDsDoUong.getTableHeader().setReorderingAllowed(false);
			tableDsDoUong.setAutoCreateRowSorter(true);
			
		btnOK.addActionListener(this);
		setVisible(true);
	}
	public static void main(String[] args) throws NamingException, JMSException {
		new UIPhaChe();
	}
	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		if(msg instanceof TextMessage) {
			try {
				TextMessage tmsg =(TextMessage) msg;
				String json = tmsg.getText();
				Order o = gson.fromJson(json, Order.class);
				int row = tableDsHoaDon.getRowCount();
				int stt;
				if(row<=0) {
					stt = 1;
				}else {
					stt= Integer.parseInt(tableDsHoaDon.getValueAt(row-1, 0).toString())+1;
				}
				String[] rowData  = {stt+"",o.getNgayTao()+"",o.getBanSo()+"",o.getTongTien()+""};
				tableDsHoaDonModel.addRow(rowData);
				tableDsHoaDon.setModel(tableDsHoaDonModel);
				
				List<OrderDetail> list = o.getListCthd();
				for(OrderDetail x: list) {
					String[] rowData2 = {stt+"",o.getBanSo()+"",x.getDoUong().getId()+"",x.getDoUong().getTen(),x.getSoLuong()+""};
					tableDsDoUongModel.addRow(rowData2);
					tableDsDoUong.setModel(tableDsDoUongModel);
				};
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if(src.equals(btnOK)) {
			int row = tableDsHoaDon.getSelectedRow();
			if(row!=-1) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				//convert String to LocalDate
				LocalDate localDate = LocalDate.parse(tableDsHoaDon.getValueAt(row, 1).toString(), formatter);
				int banSo = Integer.parseInt(tableDsHoaDon.getValueAt(row, 2).toString());
				double tongTien = Double.parseDouble(tableDsHoaDon.getValueAt(row, 3).toString());
				
				String stt = tableDsHoaDon.getValueAt(row, 0).toString();
				List<OrderDetail> list = new ArrayList<OrderDetail>();
				for(int i =0;i <tableDsDoUong.getRowCount();i++) {
					if(stt.equals(tableDsDoUong.getValueAt(i, 0))) {
						int soLuong = Integer.parseInt(tableDsDoUong.getValueAt(i,4).toString());
						Product p = productDAO.tim1DoUong(Integer.parseInt(tableDsDoUong.getValueAt(i, 2).toString()));
						OrderDetail ord = new OrderDetail(soLuong, p);
						list.add(ord);
					}
				}
				Order o = new Order(localDate, banSo, tongTien, list);
				if(orderDAO.orderDoUong(o)!=null) {
					JOptionPane.showMessageDialog(this, "Đã Thanh Toán!");
					xoaTableDSHoaDon(row);
				}
			}else {
				JOptionPane.showMessageDialog(this, "Chưa chọn hoá đơn!");
				return;
			}
			
		}
	}
	private void xoaTableDSHoaDon(int row) {
		int sttHD =Integer.parseInt(tableDsHoaDon.getValueAt(row, 0).toString());
		for(int i=0;i<tableDsDoUong.getRowCount();) {
			int maHD = Integer.parseInt(tableDsDoUong.getValueAt(i, 0).toString());
			if(maHD==sttHD) {
				tableDsDoUongModel.removeRow(i);
			}else i++;
		}

		tableDsHoaDonModel.removeRow(row);
	}

}
