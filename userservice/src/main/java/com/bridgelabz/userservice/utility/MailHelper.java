package com.bridgelabz.userservice.utility;

public class MailHelper {
	
//	@Value("${sender.email}")
//	 String fromEmail;
//	
//	@Value("${sender.password}")
//	String password;
	
	public static String getUrl(long id) {
		return  TokenUtil.createToken(id);
	}

//	public static void sendEmail(Session session, String toEmail, String subject, String body) {
//		 //producer.sendMessage("hahaha");
//
//		try {
//			System.out.println(body);
////			ProducerRabbitMq producer = new ProducerRabbitMqImplementation();
//			MimeMessage msg = new MimeMessage(session);
//			// set message headers
//			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//			msg.addHeader("format", "flowed");
//			msg.addHeader("Content-Transfer-Encoding", "8bit");
//
//			msg.setFrom(new InternetAddress("no_reply@example.com", "sucessful"));
//
//			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));
//
//			msg.setSubject(subject, "UTF-8");
//
//			msg.setText(body, "UTF-8");
//
//			msg.setSentDate(new Date());
//			
//			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//			 System.out.println("Message is ready");
//					Transport.send(msg);
////			producer.sendMessage(body);
//			System.out.println("EMail Sent Successfully!!");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
	

}
