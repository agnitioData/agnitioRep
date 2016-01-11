package com.hrms.action;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import com.opensymphony.xwork2.ActionSupport;

public class EmpHRPolicyAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String result = "error";
	public String execute()
	{
		File file = null;
        WordExtractor extractor = null;
        try
        {

            file = new File("C:\\HRPolicy\\Maximum Demand Design Document_V00R01.doc");
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            extractor = new WordExtractor(document);
            String[] fileData = extractor.getParagraphText();
            for (int i = 0; i < fileData.length; i++)
            {
                if (fileData[i] != null)
                    System.out.println(fileData[i]);
            }
           result = "success";
        }
        catch (Exception exep)
        {
            exep.printStackTrace();
        }
	        
	     return result;
		
	}
	

}
