import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

 public class login
{
  public static String consumerKey;
     public static String consumersecret,accesstoken,accesstokensecret;
     
    login()
    {
         consumerKey="X8esL6Zk9kJ3AmUB0nTQGQOCl";
         consumersecret="SxDHPZ1BkmCpJ5lEDUuRMKccOM2XTon7ekXHhx42ySXsKKlJLL";
         accesstoken="1014900686092414980-jPngpvNDyzqsLKnijtFRnYawZB09Dv";
         accesstokensecret="exvaimialmF2VYAs0jLOCl3pBVf7YnEYVRASa2Jc3g8Y1";
    }
    public static void main(String[] args) {
   try{
       ConfigurationBuilder cb=new ConfigurationBuilder();
       cb.setOAuthConsumerKey(consumerKey)
               .setOAuthConsumerSecret(consumersecret)
               .setOAuthAccessToken(accesstoken)
               .setOAuthAccessTokenSecret(accesstokensecret)
                .setDebugEnabled(true);
       Configuration build=cb.build();
       TwitterFactory factory=new TwitterFactory(build);
       Twitter twitter=factory.getInstance();
       User user=twitter.verifyCredentials();
       System.out.println("keys"+user.getName());
   }
   catch(Exception e)
   {
       System.out.println("wrong details");
       e.printStackTrace();
   }
}
}