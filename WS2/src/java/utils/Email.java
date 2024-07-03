package utils;

import java.time.LocalDateTime;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;

public class Email {

    private final String eFrom = "lvhhoangg1@gmail.com";
    private final String ePass = "ojlx ohfr qxwd llxx";

    // check email
    public boolean isValidEmail(String email) {
        return Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\\\.[A-Z|a-z]{2,}$", Pattern.CASE_INSENSITIVE).matcher(email).matches();
    }

    private Authenticator getAuthenticator() {
        return new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(eFrom, ePass);
            }
        };
    }

    public void sendEmail(String subject, String messgage, String to) {
        // Properties
        Properties props = new Properties();

        //Su dung server nao de gui mail- smtp host
        props.put("mail.smtp.host", "smtp.gmail.com");

        // TLS 587 SSL 465
        props.put("mail.smtp.port", "smtp.gmail.port");

        // dang nhap
        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.starttls.enable", "true");

        //dang nhap tai khoan
        // phien lam viec
        Session session = Session.getInstance(props, getAuthenticator());

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML, charset=UTF-8");
            msg.setFrom(new InternetAddress("noreply@testsendemail"));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            // tieu de
            msg.setSubject(subject, "UTF-8");
            // Noi dung
            msg.setContent(messgage, "text/html; charset=UTF-8");
            // Gui email
            Transport.send(msg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String subjectContact(String name) {
        return "ClothesShop - Chào " + name + " cảm ơn bạn vì đã liên hệ với chúng tôi";
    }

    public String subjectNewOrder() {
        return "ClothesShop - Đặt hàng thành công";
    }

    public String subjectSubsribe() {
        return "ClothesShop - bạn có thông báo mới";
    }

    public String subjectForgotPass() {
        return "ClothesShop - mã code xác nhận";
    }

    public String messageNewOrder(String name, int sl, double total) {
        return "<!DOCTYPE html>\n"
                + "<html>\n"
                + "    <head>\n"
                + "        <title>Email Contact</title>\n"
                + "        <meta charset=\"UTF-8\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    </head>\n"
                + "    <body style=\"font-family:arial, helvetica, sans-serif;\n"
                + "          font-size:14px;\n"
                + "          line-height:20px;\n"
                + "          color: #444;\n"
                + "          background:#f2f2f2;\">\n"
                + "        <table width=\"100%\" class=\"wrapper\" style=\" margin:20px 0;\">\n"
                + "            <tr>\n"
                + "                <td class=\"container\"> \n"
                + "                    <div class=\"content\" style=\"display: block!important;\n"
                + "                         max-width: 600px!important;\n"
                + "                         margin: 0 auto!important;\n"
                + "                         clear: both!important;\n"
                + "                         background:white;\">\n"
                + "                        <table cellspacing=\"20\" width=\"100%\">\n"
                + "                            <tr>\n"
                + "                                <td>\n"
                + "                                    <p class=\"brand\" style=\"margin:5px 0 0; font-size:30px;\n"
                + "                                       margin:20px 0;\"><span style=\"color:#e67e22;\">Clothes</span>Shop</p> \n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr>\n"
                + "                                <td class=\"border\" style=\"border-top:2px solid #e67e22;\n"
                + "                                    border-bottom:2px solid #e67e22;\">\n"
                + "                                    <h1 style=\" font-size:24px;\n"
                + "                                        color:#e67e22;\n"
                + "                                        margin:30px 0;\">ĐẶT HÀNG THÀNH CÔNG</h1>\n"
                + "                                    <p style=\"margin:5px 0 0\">Khách hàng " + name + ",</p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Cảm ơn bạn đã tin tưởng và sử dụng dịch vụ, chính sách mua hàng của chúng tôi. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Thông tin đến bạn: </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Số lượng sản phẩm: <span style=\"color:#e67e22;font-weight: bold;\"> " + sl + " </span></p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Số tiền sẽ thanh toán: <span style=\"color:#e67e22;font-weight: bold;\">" + total + "</span></p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Đơn hàng dự kiến sẽ giao đến bạn trong vòng 3 - 7 ngày tới. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Nếu bạn cần hỗ trợ gấp hãy liên hệ hotline: 1900 9090. </p>\n"
                + "                                    <p style=\"margin:5px 0 0\">Xin cảm ơn. </p>\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                            <tr class=\"contact\" style=\"font-size:11px; color:#999;\">\n"
                + "                                <td align=\"center\"> \n"
                + "                                    Clothes Shop Ho Chi Minh - 0123 456 789 - clothesshop@gmail.com\n"
                + "                                </td>\n"
                + "                            </tr>\n"
                + "                        </table>\n"
                + "                    </div> \n"
                + "                </td>\n"
                + "            </tr>\n"
                + "        </table>\n"
                + "    </body>\n"
                + "</html>\n"
                + "";
    }

    public static void main(String[] args) {
        Email handleEmail = new Email();
        String email = "hoangclw@gmail.com";
        String sub = "Subject";
        String mess = "Check email";
        handleEmail.sendEmail(sub, handleEmail.messageNewOrder("hello", 1, 3.2), email);
    }
}
