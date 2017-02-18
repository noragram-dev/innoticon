package node.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 5.
 */
@SuppressWarnings("unused")
public class Url {
    private static String __protocol = "http";
    private static String __host = "127.0.0.1";

    public static void Host(String v){ __host = v; }

    public static String getHiddenUrl(){ return __protocol + "://" +  __host + ":3000/hidden"; }
    public static String getUserUrl(){ return getNoragramUrl() + "/user"; }
    public static String getSignupUrl(){ return getUserUrl() + "/auth/email/signup"; }
    public static String getSigninUrl(){ return getUserUrl() + "/auth/email/signin"; }
    public static String getSignoutUrl(){ return getUserUrl() + "/auth/signout"; }
    public static String getHelloUrl(){ return getUserUrl() + "/hello"; }

    public static String getTokenParam(){
        String v = "";
        innoticon.Client client = innoticon.Client.Get();
        if(client!=null && client.token()!=null){
            v = "token=" + client.token();
        }
        return v;
    }
    public static String getSetProfileNameUrl(){ return getUserUrl() + "/set/profile/name"; }
    public static String getSetProfileNameUrl(String token){ return getUserUrl() + "/set/profile/name&token=" + token; }
    public static String getAddEmailUrl() { return getUserUrl() + "/add/email"; }
    public static String getAddEmailUrl(String token) { return getUserUrl() + "/add/email&token=" + token; }
    public static String getAddPhoneUrl() { return getUserUrl() + "/add/phone"; }
    public static String getAddPhoneUrl(String token) { return getUserUrl() + "/add/phone&token=" + token; }
    public static String getInviteByPhoneUrl(){ return getUserUrl() + "/invite/by/phone"; }
    public static String getInviteByPhoneUrl(String token){ return getUserUrl() + "/invite/by/phone&token=" + token; }
    public static String getInviteByEmailUrl(){ return getUserUrl() + "/invite/by/email";  }
    public static String getInviteByEmailUrl(String token){ return getUserUrl() + "/invite/by/email&token=" + token;  }

    public static String getAcceptToInviteUrl(){ return getUserUrl() + "/invite/accept"; }
    public static String getAcceptToInviteUrl(String token){ return getUserUrl() + "/invite/accept&token=" + token; }
    public static String getRejectToInviteUrl(){ return getUserUrl() + "/invite/reject"; }
    public static String getRejectToInviteUrl(String token){ return getUserUrl() + "/invite/reject&token=" + token; }

    public static String getNoragramUrl(){ return __protocol + "://" + __host + ":3000/noragram"; }


    public static String getHiddenGenerateClientKeyUrl(){ return getHiddenUrl() + "/generate.client.key"; }

    public static String getHiddenGenerateClientKeyUrl(String uid, String device, String app) {
        try {
            String v = "";
            innoticon.Client client = innoticon.Client.Get();
            if(client!=null && client.token()!=null){
                v = "&token=" + client.token();
            }
            return String.format("%s?uid=%s&device=%s&app=%s",
                    getHiddenGenerateClientKeyUrl(),
                    URLEncoder.encode(uid,"UTF-8"),
                    URLEncoder.encode(device,"UTF-8"),
                    URLEncoder.encode(app,"UTF-8")) + v;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getSignupUrl(String email, String password) {
        try {
            return String.format("%s?email=%s&password=%s",
                    getSigninUrl(),
                    URLEncoder.encode(email,"UTF-8"),
                    URLEncoder.encode(password,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSigninUrl(String email, String password) {
        try {
            return String.format("%s?email=%s&password=%s",
                    getSigninUrl(),
                    URLEncoder.encode(email,"UTF-8"),
                    URLEncoder.encode(password,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getHelloUrl(String device, String app) {
        try {
            String v = "";
            innoticon.Client client = innoticon.Client.Get();
            if(client!=null && client.token()!=null){
                v = "&token=" + client.token();
            }
            return String.format("%s?device=%s&app=%s",
                    getHelloUrl(),
                    URLEncoder.encode(device, "UTF-8"),
                    URLEncoder.encode(app, "UTF-8")) + v;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
