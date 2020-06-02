package com.project.demo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.demo.model.User;
import com.project.demo.model.InboxDetails;

@RestController
@RequestMapping("/myApp")
@CrossOrigin(origins="*",allowedHeaders="*")
public class MyAppController {

	@PostMapping("/sentSms")
	public String  getSms(@RequestBody User user) 
	{
		try {
			// Construct data
			String apiKey = "apikey=" + "your apikey";
			String message = "&message=" + "Hi "+user.getFirstName() + ", Welcome to Doot App your otp is 331456.";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "91" + user.getPhoneNo();

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();

			return stringBuffer.toString();
			//return emp.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}

	}

	@PostMapping("/verifyOtp")
	public String  otpValidation(@RequestBody String otp) 
	{
		try {
			if("331456".equalsIgnoreCase(otp)){
				return "Success";
			}
			return "Failed Validation";
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}

	public String getInboxes() {
		try {
			// Construct data
			String apiKey = "apikey=" + "your apikey";

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/get_inboxes/?").openConnection();
			String data = apiKey;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();

			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}

	public String getMessages(Integer id) {
		try {
			// Construct data
			String apiKey = "apikey=" + "your apikey";
			String inbox_id = "&inbox_id=" + id;

			// Send data
			String data = apiKey+inbox_id;
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/get_messages/?").openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();

			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}

	@GetMapping("/receivedSms")
	public String  getReceivedSms() 
	{   try {


		ObjectMapper mapper = new ObjectMapper();
		InboxDetails details = mapper.readValue(getInboxes(),InboxDetails.class);

		return getMessages(details.getInboxes().get(0).getId());
		
	} catch (Exception e) {
		return "Error "+e;
	}
	}
}
