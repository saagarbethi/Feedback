package com.feedback.app.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class HelperService {
	public String getDateTime() {
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();
		   return (dtf.format(now));
	}
}
