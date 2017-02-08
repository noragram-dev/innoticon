package firebase.db;

/**
 *
 * @author novemberizing, me@novemberizing.net
 * @since 2017. 2. 7.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Path {
    public static String getUserPath(String uid){ return "/users/" + uid; }
    public static String getUserClientPath(String uid, String device, String app){ return getUserPath(uid) + "/devices/" + device + "/" + app; }
    public static String getUserInboxPath(String uid){ return getUserPath(uid) + "/inbox"; }
    public static String getUserProfilePath(String uid){ return getUserPath(uid) + "/profile/main"; }
    public static String getUserProfilePath(String uid, String provider){ return getUserPath(uid) + "/profile/" + provider; }
    public static String getUserInvitationInboxPath(String uid){ return getUserInboxPath(uid) + "/invitation"; }
    public static String getUserInvitationReqPath(String destination, String source){ return getUserInvitationInboxPath(destination) + "/" + source; }
    public static String getUserFriendsPath(String uid){ return getUserPath(uid) + "/friends"; }
    public static String getUserFriendPath(String uid, String friend){ return getUserFriendsPath(uid) + "/" + friend; }
    public static String getUserInvitationMsgPath(String uid){ return getUserInboxPath(uid) + "/msg"; }
    public static String getUserRequestsPath(String uid){ return getUserPath(uid) + "/requests"; }
    public static String getUserRequestPath(String uid, String clientKey, String actionKey){ return getUserRequestsPath(uid) + "/" + clientKey + "/" + actionKey; }
}
