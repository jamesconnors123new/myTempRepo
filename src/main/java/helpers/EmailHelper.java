package helpers;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.MessageListParams;
import com.mailosaur.models.MessageListResult;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class EmailHelper {

    public static String apiKey = "YOUR_API_KEY";
    public static String serverId = "SERVER_ID";
    public static String serverDomain = "SERVER_DOMAIN";
    public static MailosaurClient mailosaurClient;


    public MailosaurClient getEmailClient() {
        trustCertificate();
        mailosaurClient = new MailosaurClient(apiKey);
        return mailosaurClient;
    }

    public MessageListResult getAllEmails() throws MailosaurException, IOException {
        MessageListParams params = new MessageListParams().withServer(serverId);
        MailosaurClient mailosaurClient1 = getEmailClient();
        return mailosaurClient1.messages().list(params);
    }

    public void deleteEmail (String messageId) throws MailosaurException {
        mailosaurClient.messages().delete(messageId);
    }

    public void deleteAllEmails() throws MailosaurException {
        mailosaurClient.messages().deleteAll(serverId);
    }

    //Search mail with sentto
    //Search mail with getDetailsFromMailBody
    private void trustCertificate() {
        TrustManager[] trustAllCerts =
                new TrustManager[]{
                        new X509TrustManager() {
                            public void checkClientTrusted(X509Certificate[] certificates, String authType)
                                    throws CertificateException {
                                if (certificates.length == 0) {
                                    throw new CertificateException();
                                }
                            }

                            public void checkServerTrusted(X509Certificate[] certificates, String authType)
                                    throws CertificateException {
                                if (certificates.length == 0) {
                                    throw new CertificateException();
                                }
                            }

                            public X509Certificate[] getAcceptedIssuers() {
                                return new X509Certificate[0];
                            }
                        }
                };
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
