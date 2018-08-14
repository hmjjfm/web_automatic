package pri.hmj.util;


import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@ContextConfiguration(classes = { RootConfig.class })
@WebAppConfiguration
public class EmailSenderTest {

	@Autowired
	private JavaMailSender mailSender;

	@Test
	public void sendSimpleEmail() throws MessagingException {
		// SimpleMailMessage message = new SimpleMailMessage();//消息构造器
		RootConfig config = new RootConfig();
		mailSender = config.mailSender();
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		/*
		 * message.setFrom("15759675251@163.com");//发件人
		 * message.setTo("easyeye@163.com");//收件人
		 */ 
		helper.setFrom("15759675251@163.com");
		helper.setTo("easyeye@163.com");
		helper.setSubject("Spring Email Test");// 主题
		helper.setText("hello world!!");// 正文
		File file1 =new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\index.html");  
		//注意文件名
		helper.addAttachment("index.html", file1);
		
		mailSender.send(message);
		System.out.println("邮件发送完毕");
	}

}
