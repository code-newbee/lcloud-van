package lcloud.van.core.constants;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/5/27 16:19
 */
public class AuthConstants {

    /**
     * JWT存储权限前缀
     */
    public static String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    public static String AUTHORITY_CLAIM_NAME = "authorities";

    /**
     * 认证信息Http请求头
     */
    public static String JWT_TOKEN_HEADER = "Authorization";

    /**
     * JWT令牌前缀
     */
    public static String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * JWT载体key
     */
    public static String JWT_PAYLOAD_KEY = "payload";

    /**
     * Redis缓存权限规则key
     */
    public static String RESOURCE_ROLES_KEY = "auth:resourceRoles";

    /**
     * 黑名单token前缀
     */
    public static String TOKEN_BLACKLIST_PREFIX = "auth:token:blacklist:";

    public static String CLIENT_DETAILS_FIELDS = "client_id, CONCAT('{noop}',client_secret) as client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    public static String BASE_CLIENT_DETAILS_SQL = "select " + CLIENT_DETAILS_FIELDS + " from oauth_client_details";

    public static String FIND_CLIENT_DETAILS_SQL = BASE_CLIENT_DETAILS_SQL + " order by client_id";

    public static String SELECT_CLIENT_DETAILS_SQL = BASE_CLIENT_DETAILS_SQL + " where client_id = ?";

    /**
     * 密码加密方式
     */
    public static String BCRYPT = "{bcrypt}";

    public static String JWT_USER_ID_KEY = "id";

    public static String JWT_CLIENT_ID_KEY = "client_id";

    /**
     * 有来商城后台管理客户端ID
     */
    public static String ADMIN_CLIENT_ID="youlai-admin";


    /**
     * 有来商城微信小程序客户端ID
     */
    public static String WEAPP_CLIENT_ID="youlai-mall-weapp";

    /**
     * 后台管理接口路径匹配
     */
    public static String ADMIN_URL_PATTERN ="/youlai-admin/**" ;
}
