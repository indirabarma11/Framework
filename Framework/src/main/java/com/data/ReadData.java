package com.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.basic.ReadPropertyFile;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadData {

	public static Map getTestData(String testCaseName,String sheetName ) {
		Fillo fillo = new Fillo();
		Connection connection;
		Map<String, String> testData = new HashMap<String, String>();
		try {
			connection = fillo.getConnection(ReadPropertyFile.getProperty("PageDataPath"));

			String strQuery = "Select * from " + sheetName+ " where TestCaseID='" + testCaseName + "' ";

			Recordset recordset = connection.executeQuery(strQuery);
			ArrayList<String> header = recordset.getFieldNames();
			Iterator iterator = header.iterator();
			while (recordset.next()) {
				while (iterator.hasNext()) {
					String headerName = (String) iterator.next();
					String value = recordset.getField(headerName);

					testData.put(headerName, value);
				}
			}
			recordset.close();
			connection.close();
			return testData;
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static Map getPageElements(String sheetName) {
		Fillo fillo = new Fillo();
		Connection connection;
		Map<String, String> pageObject = new HashMap<String, String>();
		try {
			connection = fillo.getConnection(ReadPropertyFile.getProperty("PageObjectPath"));

			String strQuery = "Select * from " + sheetName;

			Recordset recordset = connection.executeQuery(strQuery);

			while (recordset.next()) {
				String eleName = recordset.getField("ElementName");
				String elePath = recordset.getField("ElementPath");
				pageObject.put(eleName, elePath);
			}

			recordset.close();
			connection.close();
			return pageObject;
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}

