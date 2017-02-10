package client.db;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Path {
    public static String getUserRootPath(String uid){ return "/user/" + uid; }

    public static String getUserClientRootPath(String uid){ return getUserRootPath(uid) + "/client"; }
    public static String getUserClientPath(String uid, String device, String app){ return getUserClientRootPath(uid) + "/" + device + "/" + app; }
    
    public static String getUserClientRequestRootPath(String uid){ return getUserClientRootPath(uid) + "/request"; }
    public static String getUserClientResponseRootPath(String uid){ return getUserClientRootPath(uid) + "/response"; }

    public static String getUserClientRequestPath(String uid, innoticon.ds.Req req){ return getUserClientRequestRootPath(uid) + "/" + req.action.key.c.hex(); }

    public static String getUserClientResponsePath(String uid, innoticon.ds.Req req){ return getUserClientResponseRootPath(uid) + "/" + req.action.key.c.hex() + "/main"; }
    public static String getUserClientResponsePath(String uid, innoticon.ds.Req req, innoticon.ds.Res.Key key){ return getUserClientRequestRootPath(uid) + "/" + req.action.key.c.hex() + "/" + req.action.key.s.hex() + "/" + key.hex(); }

    public static String getUserProfileRootPath(String uid){ return getUserRootPath(uid) + "/profile"; }
    public static String getUserProfileMainPath(String uid){ return getUserProfileRootPath(uid) + "/main"; }
    public static String getUserProfileMainEmailPath(String uid){ return getUserProfileMainPath(uid) + "/email"; }
    public static String getUserProfileMainPhonePath(String uid){ return getUserProfileMainPath(uid) + "/phone"; }
    public static String getUserProfileMainNamePath(String uid){ return getUserProfileMainPath(uid) + "/phone"; }
    public static String getUserProfilePath(String uid, String provider){ return getUserProfileRootPath(uid) + "/" + provider; }

    public static String getUserInboxRootPath(String uid){ return getUserRootPath(uid) + "/inbox"; }
    public static String getUserInvitationInboxRootPath(String uid){ return getUserInboxRootPath(uid) + "/invitation"; }
    public static String getUserMessageInboxRootPath(String uid){ return getUserInboxRootPath(uid) + "/message"; }

    public static String getUserFriendRootPath(String uid){ return getUserRootPath(uid) + "/friend"; }
    public static String getUserFriendPath(String uid, String friend){ return getUserFriendRootPath(uid) + "/" + friend; }
}