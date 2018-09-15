package workamerica.contexts.utilities;

import eu.bitwalker.useragentutils.UserAgent;
import workamerica.contexts.reporting.models.shared.DeviceLogs;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Faizan on 8/20/2016.
 */
public class HTTPUtilities {

    public static String getClientUserAgent(HttpServletRequest request) {
        if (request != null) {
            String userAgent = request.getHeader("User-Agent");
            return userAgent != null ? userAgent : "ValarDohaeris";
        }
        return "ValarDohaeris";
    }

    public static DeviceLogs getDevice(HttpServletRequest request) {
        String userAgentString = getClientUserAgent(request);
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
        String browser = userAgent.getBrowser().getName(), browserVersion = userAgent.getBrowserVersion().getMajorVersion(),
                operatingSystem = userAgent.getOperatingSystem().getName(), deviceType = userAgent.getOperatingSystem().getDeviceType().getName(),
                vendor = userAgent.getOperatingSystem().getManufacturer().getName();
        return new DeviceLogs(deviceType, vendor, operatingSystem, browser, browserVersion);
    }

    public static String getClientIP(HttpServletRequest request) {
        if (request != null) {
            String ip = request.getHeader("X-Forwarded-For");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_CLUSTER_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_FORWARDED_FOR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_FORWARDED");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_VIA");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("REMOTE_ADDR");
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
            return ip == null ? "ValarMorghulis" : ip;
        } else {
            return "ValarMorghulis";
        }
    }
}
