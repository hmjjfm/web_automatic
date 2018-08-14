package pri.hmj.util;


import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.testng.annotations.Test;

public class EmailSenderTest {

	private JavaMailSender mailSender;

	@Test
	public void sendSimpleEmail() throws MessagingException {
		// SimpleMailMessage message = new SimpleMailMessage();//消息构造器
		RootConfig config = new RootConfig();
		mailSender = config.mailSender();
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		 // message.setFrom("15759675251@163.com");//发件人
		 // message.setTo("easyeye@163.com");//收件人
		  message.setSubject("sss");
		 
		helper.setFrom("15759675251@163.com");
		helper.setTo("huanfuan@163.com");
		helper.setSubject("我在用发送邮件");// 主题
		helper.setText("成功了吗!");// 正文
		File file1 =new File(System.getProperty("user.dir")+"\\log\\log.log");  
		//注意文件名
		helper.addAttachment("log.log", file1);
		
		mailSender.send(message);
		System.out.println("邮件发送完毕");
	}

}
