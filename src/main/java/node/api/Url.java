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
    private static final String __protocol = "http";

    private static final String __noragramUrl = __protocol + "://" + "127.0.0.1:3000/noragram";

    private static final String __hiddenUrl = __protocol + "://" + "127.0.0.1:3000/hidden";

    private static final String __hiddenGenerateClientKeyUrl = __hiddenUrl + "/generate.client.key";

    private static final String __userUrl  = __noragramUrl + "/user";

    private static final String __SignupUrl = __userUrl + "/auth/email/signup";
    private static final String __SigninUrl = __userUrl + "/auth/email/signin";
    private static final String __SignoutUrl = __userUrl + "/auth/signout";
    private static final String __helloUrl = __userUrl + "/hello";
    private static final String __setProfileNameUrl = __userUrl + "/set/profile/name";
    private static final String __addEmailUrl = __userUrl + "/add/email";
    private static final String __addPhoneUrl = __userUrl + "/add/phone";
    private static final String __inviteByEmailUrl = __userUrl + "/invite/by/email";
    private static final String __inviteByPhoneUrl = __userUrl + "/invite/by/phone";
    private static final String __acceptToInviteUrl = __userUrl + "/invite/accept";
    private static final String __rejectToInviteUrl = __userUrl + "/invite/reject";

    public static String getHiddenGenerateClientKeyUrl(String uid, String device, String app) {
        try {
            return String.format("%s?uid=%s&device=%s&app=%s",
                    __hiddenGenerateClientKeyUrl,
                    URLEncoder.encode(uid,"UTF-8"),
                    URLEncoder.encode(device,"UTF-8"),
                    URLEncoder.encode(app,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getNoragramUrl(){ return __noragramUrl; }

    public static String getSignupUrl(String email, String password) {
        try {
            return String.format("%s?email=%s&password=%s",
                    __SignupUrl,
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
                    __SigninUrl,
                    URLEncoder.encode(email,"UTF-8"),
                    URLEncoder.encode(password,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSignoutUrl() {
        return __SignoutUrl;
    }

    public static String getHelloUrl(String device, String app) {
        try {
            return String.format("%s?device=%s&app=%s",
                    __helloUrl,
                    URLEncoder.encode(device, "UTF-8"),
                    URLEncoder.encode(app, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
//        return __helloUrl; }

    public static String getSetProfileNameUrl(){ return __setProfileNameUrl; }


    public static String getAddPhoneUrl(){ return __addPhoneUrl; }
    public static String getAddEmailUrl(){ return __addEmailUrl; }

    public static String getInviteByPhoneUrl(){ return __inviteByPhoneUrl; }
    public static String getInviteByEmailUrl(){ return __inviteByEmailUrl; }

    public static String getAcceptToInviteUrl(){ return __acceptToInviteUrl; }
    public static String getRejectToInviteUrl(){ return __rejectToInviteUrl; }
}
