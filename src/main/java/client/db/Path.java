package client.db;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Path {
    public static String getUserRootPath(String uid) throws Exception {
        if(uid==null){ throw new Exception("uid==null"); }
        return "/user/" + uid;
    }

    public static String getUserClientRootPath(String uid) throws Exception { return getUserRootPath(uid) + "/client"; }
    public static String getUserClientPath(String uid, String device, String app) throws Exception {
        if(device==null || app==null){ throw new Exception("device==null || app==null"); }
        return getUserClientRootPath(uid) + "/device/" + device + "/" + app;
    }
    
    public static String getUserClientRequestRootPath(String uid) throws Exception { return getUserClientRootPath(uid) + "/request"; }
    public static String getUserClientResponseRootPath(String uid) throws Exception { return getUserClientRootPath(uid) + "/response"; }

    public static String getUserClientRequestPath(String uid, innoticon.ds.Req req) throws Exception { return getUserClientRequestRootPath(uid) + "/" + req.action.key.c.hex(); }

    public static String getUserClientResponsePath(String uid, innoticon.ds.Req req) throws Exception { return getUserClientResponseRootPath(uid) + "/" + req.action.key.c.hex() + "/main"; }
    public static String getUserClientResponsePath(String uid, innoticon.ds.Req req, innoticon.ds.Res.Key key) throws Exception { return getUserClientRequestRootPath(uid) + "/" + req.action.key.c.hex() + "/" + req.action.key.s.hex() + "/" + key.hex(); }

    public static String getUserProfileRootPath(String uid) throws Exception { return getUserRootPath(uid) + "/profile"; }
    public static String getUserProfileMainPath(String uid) throws Exception { return getUserProfileRootPath(uid) + "/main"; }
    public static String getUserProfileMainEmailPath(String uid) throws Exception { return getUserProfileMainPath(uid) + "/email"; }
    public static String getUserProfileMainPhonePath(String uid) throws Exception { return getUserProfileMainPath(uid) + "/phone"; }
    public static String getUserProfileMainNamePath(String uid) throws Exception { return getUserProfileMainPath(uid) + "/phone"; }
    public static String getUserProfilePath(String uid, String provider) throws Exception { return getUserProfileRootPath(uid) + "/" + provider; }

    public static String getUserInboxRootPath(String uid) throws Exception { return getUserRootPath(uid) + "/inbox"; }
    public static String getUserInvitationInboxRootPath(String uid) throws Exception { return getUserInboxRootPath(uid) + "/invitation"; }
    public static String getUserInvitationPath(String uid, String friend) throws Exception { return getUserInvitationInboxRootPath(uid) + "/" + friend; }
    public static String getUserMessageInboxRootPath(String uid) throws Exception { return getUserInboxRootPath(uid) + "/message"; }

    public static String getUserFriendRootPath(String uid) throws Exception { return getUserRootPath(uid) + "/friend"; }
    public static String getUserFriendPath(String uid, String friend) throws Exception { return getUserFriendRootPath(uid) + "/" + friend; }
}