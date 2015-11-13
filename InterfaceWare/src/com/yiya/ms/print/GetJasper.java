package com.yiya.ms.print;

import java.io.File;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;

//
public class GetJasper {
	public JasperPrint getJasper(HashMap[] reportRows,File reportFile){
		JRDataSource dataSource = new JRMapArrayDataSource(reportRows);	
		JasperPrint jasperPrint = null;
		try{
			jasperPrint = JasperFillManager.fillReport(reportFile.getPath(),null,dataSource);
		}catch(JRException e){
			e.printStackTrace();
		}
		return jasperPrint;
	}

}
