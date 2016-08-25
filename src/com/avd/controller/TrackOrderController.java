package com.avd.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avd.common.util.PdfInvoicesBasic;
import com.avd.service.CustomerService;

@Controller
public class TrackOrderController {

	@Autowired
	CustomerService customerServc;

	@RequestMapping("/trackOrder")
	public ModelAndView trackOrder(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> dat = new ArrayList<Object[]>();

		String cartProduct = "0";

		String view = "";
		if (session != null && session.getAttribute("loginId") != null) {
			String loginId = session.getAttribute("loginId").toString();
			map.put("loginId", loginId);
			map.put("flag", "1");
			dat = customerServc.getOrderDetails(map);
			map.put("cartProductsDesc", dat);
			cartProduct = customerServc.getCartProducts(map);
			map.put("productInCart", cartProduct);

			view = "trackCart";
		} else {
			view = "trackOrder";
		}

		return new ModelAndView(view, "map", map);
	}

	@RequestMapping("/trackOrderSpecific")
	public ModelAndView trackOrderSpecific(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> dat = new ArrayList<Object[]>();
		String orderId = req.getParameter("orderId");
		map.put("orderId", orderId);
		map.put("flag", "2");

		dat = customerServc.getOrderDetails(map);
		map.put("cartProductsDesc", dat);
		String cartProduct = "0";
		if (session != null && session.getAttribute("logId") != null) {
			String loginId = session.getAttribute("logId").toString();
			map.put("loginId", loginId);
			cartProduct = customerServc.getCartProducts(map);
			map.put("productInCart", cartProduct);

		}

		String view = "trackCart";
		return new ModelAndView(view, "map", map);
	}

	@RequestMapping("/trackOrderDetails")
	public ModelAndView trackOrderDetails(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> dat = new ArrayList<Object[]>();
		List<Object[]> dat1 = new ArrayList<Object[]>();
		String orderId = req.getParameter("orderId");
		String nextStatus = null;
		map.put("orderId", orderId);
		map.put("flag", "2");

		dat = customerServc.getOrderDetails(map);
		dat1 = customerServc.getTrackDesc(map);
		map.put("cartProductsDesc", dat);
		map.put("cartProductsDesc1", dat1);

		String cartProduct = "0";
		if (session != null && session.getAttribute("logId") != null && session.getAttribute("loginName") != null) {
			System.out.println("inside if block" + session.getAttribute("logId").toString());
			String loginId = session.getAttribute("logId").toString();
			map.put("loginId", loginId);
		} else if (session != null && session.getAttribute("sellerId") != null) {
			System.out.println("inside else block");
			map.put("sellerId", session.getAttribute("sellerId").toString());
			nextStatus = customerServc.getNextStatus(orderId);
			map.put("nextStatusId", nextStatus.split(",")[0]);
			map.put("nextStatusDesc", nextStatus.split(",")[1]);
		}

		String view = "trackOrderDetails";
		return new ModelAndView(view, "map", map);
	}

	@RequestMapping("/updateOrderStatus")
	public ModelAndView updateOrderStatus(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession(false);
		String statusId = req.getParameter("statusId");
		String orderId = req.getParameter("orderId");
		String statusDesc = req.getParameter("statusDescd");
		String result = null;
		try {
			result = customerServc.updateOrderStatus(statusId, orderId, statusDesc);
			System.out.println("order updation status is "+result);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		session.setAttribute("orderUpdateStatus", result);
		return new ModelAndView("redirect:getOrdersList");
	}

	
	
	
	
	@RequestMapping("/generateBill")
	public void generateBill(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String orderId = req.getParameter("orderId");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> dat = new ArrayList<Object[]>();
		Properties props = new Properties();
		props.load(req.getServletContext().getResourceAsStream("/WEB-INF/path.properties"));
		String filePath = props.getProperty("filePath");
		
		map.put("orderId", orderId);
		map.put("flag", "2");
		
		dat = customerServc.getOrderDetails(map);
		map.put("generalDetails", dat);
		
		dat = customerServc.getTrackDesc(map);
		map.put("orderDetails", dat);
		PdfInvoicesBasic.DEST=filePath+orderId+".pdf";
		PdfInvoicesBasic.FONT=filePath+"Fonts//OpenSans-Regular.ttf";
		PdfInvoicesBasic.FONTB=filePath+"Fonts//OpenSans-Regular.ttf";
		PdfInvoicesBasic bill =new PdfInvoicesBasic();
		bill.createPdf(map);
		map=null;
		dat=null;
		bill=null;
		
		 FileInputStream baos = new FileInputStream(PdfInvoicesBasic.DEST);
	      
	        res.setHeader("Expires", "0");
	        res.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
	        res.setHeader("Content-Disposition", "attachment;filename="+orderId+".pdf");
	        
	        res.setContentType("application/pdf;charset=UTF-8");
	        res.setCharacterEncoding("UTF-8");
	       
	        res.setContentLength((int) new File(PdfInvoicesBasic.DEST).length());
	        OutputStream os1 = res.getOutputStream();

	        copy(baos, os1);
	        os1.flush();
	        os1.close();
	        baos.close();
	        String target=PdfInvoicesBasic.DEST.replace("\\", "/");
	        File file = new File(target);
	      
	        if (file.exists()) {
				file.delete();
			}
	}
	
	
	
	
	 private static void copy(InputStream is, OutputStream os)
	            throws IOException {
	        byte buffer[] = new byte[8192];
	        int bytesRead, i;

	        while ((bytesRead = is.read(buffer)) != -1) {
	            os.write(buffer, 0, bytesRead);
	        }
	    }
	
	
}