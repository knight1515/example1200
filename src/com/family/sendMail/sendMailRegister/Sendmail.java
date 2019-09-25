package com.family.sendMail.sendMailRegister;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件是一件非常耗时的事情，因此这里设计一个线程类来发送邮件
 * @author: gzb
 * @date  : 2019年8月16日 上午10:51:32
 *
 */
public class Sendmail extends Thread {
    //用于给用户发送邮件的邮箱
    private String from="daguozb@163.com";
  //邮箱的用户名
    private String username="daguozb";
  //邮箱的密码
    private String password="q1w2e3r4,";
  //发送邮件的服务器地址
    private String host="smtp.163.com";
    
    private User user;
    
    public Sendmail(User user) {
        this.user=user;
    }

    
    /* 重写run方法的实现，在run方法中发送邮件给指定的用户
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        try{
            Properties prop = new Properties();
            prop.setProperty("mail.host", host);
            prop.setProperty("mail.transport.protocol", "smtp");
            prop.setProperty("mail.smtp.auth", "true");
            Session session = Session.getInstance(prop);
            session.setDebug(true);
            Transport ts = session.getTransport();
            ts.connect(host, username, password);
            Message message = createEmail(session,user);
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
    * @Method: createEmail
    * @Description: 创建要发送的邮件
    * @Anthor:孤傲苍狼
    *
    * @param session
    * @param user
    * @return
    * @throws Exception
    */ 
    public Message createEmail(Session session,User user) throws Exception{
        
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
        message.setSubject("用户注册邮件");
        
        String info = "恭喜您注册成功，您的用户名：" + user.getUsername() + ",您的密码：" + user.getPassword() + "，请妥善保管，如有问题请联系网站客服!!";
        message.setContent(info, "text/html;charset=UTF-8");
        message.saveChanges();
        return message;
    }
    
}


























