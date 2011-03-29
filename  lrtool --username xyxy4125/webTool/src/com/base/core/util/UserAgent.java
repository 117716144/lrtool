package com.base.core.util;

import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

/**
 * The UserAgent class is a Java server-side browser detection tool. Properties
 * about the client web browser will be available if needed to support browser
 * specific behavior. Output of appropriate error messages is an example of
 * where it may be used.
 * <p/>
 * Construction: call in an appropriate servlet with new UserAgent(request).
 * Class properties are populated by the constructor and thereafter the class
 * has only accessor methods as executable code.
 *
 * @author Mark Marietta, John Akerley
 */

public class UserAgent implements java.io.Serializable {
    /*
      * All the browsers that support a level of JavaScript that we think is
      * acceptable are specified in web.xml and loaded here.
      */
    private static Vector supportedJavaScriptBrowsers = new Vector();

    private String userAgentString = null;

    private boolean isJavaScriptEnabledFlag = false;

    private String browser = "Unknown";

    private String major = "Unknown";

    private String version = "Unknown";

    private boolean is_IE = false;

    private boolean is_IE3 = false;

    private boolean is_IE4 = false;

    private boolean is_IE5 = false;

    private boolean is_IE6 = false;

    private boolean is_IE5up = false;

    private boolean is_Nav = false;

    private boolean is_Nav3 = false;

    private boolean is_Nav4 = false;

    private boolean is_Nav6 = false;

    private boolean is_Nav7 = false;

    private boolean is_Nav6up = false;

    private boolean is_Mozilla = false;

    private boolean is_Mozilla1up = false;

    private boolean is_AOL = false;

    private boolean is_AOL8up = false;

    private boolean is_Opera = false;

    private boolean is_WebTV = false;

    private boolean is_Safari = false;

    private boolean is_Safari8up = false;

    private boolean is_Firefox = false;

    private boolean is_Firefox10up = false;

    private String OS = "Unknown";

    private boolean is_Windows = false;

    private boolean is_Mac = false;

    private boolean is_Unix = false;


    /**
     * spiders
     */
    public final static String[] spiders = new String[]{"googlebot", "baiduspider", "msnbot", "yahoo", "sogou", "bing", "yodaobot", "slurp", "scooter", "googlebot-image", "ia_archiver",
            "gigabot", "jmeter", "alexibot", "lycos_spider", "fast-webcrawler", "webalta", "jetbot", "joocerbot", "searchspider", "gigablast", "grigorbot", "kulokobot","ontospider",
            "slysearch", "peerbot", "adsarobot", "aspseek", "banbots", "bullseye", "deepindex", "easydl", "galaxybot", "geckobot","psbot","polybot","pjspider","nzbot", "wget"};


    /**
     * check spider
     *
     * @param request
     * @return
     */
    public String checkSpider(HttpServletRequest request) {

        String agentSprider = request.getHeader("User-Agent");

        for (String spider : spiders) {

            if (agentSprider.toLowerCase().indexOf(spider.toLowerCase()) != -1) {

                //     System.out.println(">>>>>>>>>Spider:::::::" + spider + ":::::::<<<<<<<<<<<<<<<<<<<<");

                return spider;

            }

        }

        return null;

    }


    /**
     * get the User-Agent and check for the presence of substrings which will
     * tell us browser type and operating system. Populate class properties
     * based on what we find.
     */
    public void checkBrowser(HttpServletRequest request) {
        init();
        if (request == null || request.getHeader("User-Agent") == null) {
            return; // unkown browser
        }

        userAgentString = request.getHeader("User-Agent").toLowerCase();
        int pos = userAgentString.indexOf("webtv");
        if (pos > -1) {
            is_WebTV = true;
            return; // we don't know anything else
        }


        try {
            pos = userAgentString.indexOf("msie");
            if (pos > -1) { // may be IE, may not
                browser = "IE";
                int endPos = userAgentString.indexOf(';', pos);
                if (endPos > 0 && endPos >= (pos + 5)) {
                    version = userAgentString.substring(pos + 5, endPos);
                    major = version.substring(0, 1);
                }
                is_IE = true; // assume for now
                // check if an AOL browser
                pos = userAgentString.indexOf("aol");
                if (pos > -1) { // we know it is really an IE based AOL browser.
                    browser = "AOL";
                    is_AOL = true;
                    is_IE = true;
                    is_Nav = false;
                }


                if (browser == "IE") {
                    if (major.equals("3")) {
                        is_IE3 = true;
                    }
                    if (major.equals("4")) {
                        is_IE4 = true;
                    }
                    if (major.equals("5")) {
                        is_IE5 = true;
                    }
                    if (major.equals("6")) {
                        is_IE6 = true;
                    }

                    int v = getValue(major);
                    if (v >= 5) {
                        is_IE5up = true;
                    }
                } // brower actually is IE

            } // msie string found

            // check if it's the Opera broswer
            pos = userAgentString.indexOf("opera");
            if (pos > -1) { // we know it is really the Opera browser.
                browser = "Opera";
                int endPos = userAgentString.indexOf('[', pos);
                if (endPos > 0 && endPos >= (pos + 6)) {
                    version = userAgentString.substring(pos + 6, endPos);
                    major = version.substring(0, 1);
                }
                is_Opera = true;
                is_IE = false; // not an IE based browser
            }

            // check for Mozilla based AOL browser.
            if ((userAgentString.indexOf("mozilla") > -1) && (userAgentString.indexOf("aol") > -1)
                    && (userAgentString.indexOf("safari") == -1) && (userAgentString.indexOf("firefox") == -1)
                    && (userAgentString.indexOf("opera") == -1) && (userAgentString.indexOf("webtv") == -1)) {
                is_AOL = true; // assume for now
                browser = "AOL";
                // get full string after 'aol' text
                String s = userAgentString.substring(userAgentString.indexOf("aol"), userAgentString.length());
                pos = s.indexOf(";");
                version = s.substring(4, pos);
                pos = version.indexOf(".");
                if (pos == -1)
                    major = version;
                major = version.substring(0, pos);
                String minor = version.substring(pos + 1, version.length());
                // just in case no sub minor version
                pos = minor.indexOf(".");
                if (pos > -1)
                    minor = minor.substring(0, pos);
                int majorVal = getValue(major);
                int minorVal = getValue(minor);
                if (majorVal >= 8) {
                    is_AOL8up = true;
                }
            }

            // check Netscape & Mozilla.
            if ((userAgentString.indexOf("mozilla") > -1) && (userAgentString.indexOf("aol") == -1)
                    && (userAgentString.indexOf("safari") == -1) && (userAgentString.indexOf("firefox") == -1)
                    && (userAgentString.indexOf("msie") == -1) && (userAgentString.indexOf("opera") == -1)
                    && (userAgentString.indexOf("webtv") == -1)) {

                is_Nav = true; // assume for now
                browser = "Navigator";
                pos = userAgentString.indexOf("/");
                version = userAgentString.substring(pos + 1, pos + 4);
                if ((userAgentString.indexOf("gecko") > -1) && (userAgentString.indexOf("mozilla/5.0") > -1)) {
                    if (userAgentString.indexOf("netscape") > -1) {
                        browser = "Netscape";
                        pos = userAgentString.indexOf("netscape");
                        version = userAgentString.substring(pos + 8, userAgentString.length());
                        // System.err.println("Netscape version = '" + version +
                        // "'");
                        if (version.indexOf("/") == 0) {
                            version = version.substring(1, version.length());
                        }
                    } else {
                        // making a leap as it could be another branded browser
                        // based on Mozilla.
                        browser = "Mozilla";
                        is_Mozilla = true;
                        version = userAgentString.substring((userAgentString.indexOf("rv:") + 3), userAgentString
                                .indexOf(")"));
                    }
                }
                major = version.substring(0, 1);
                if (major.equals("3")) { // Mozilla/3.X
                    is_Nav3 = true;
                }
                if (major.equals("4")) { // Mozilla/4.X
                    is_Nav4 = true;
                }
                if (major.equals("6")) { // Mozilla/5.0
                    is_Nav6 = true;
                }
                if (major.equals("7")) { // Mozilla/5.0, Netscape7
                    is_Nav7 = true;
                }
                int v = getValue(major);
                if (is_Mozilla && v >= 1) {
                    is_Mozilla1up = true;
                }
                if ((is_Nav6 || is_Nav7) && v >= 6) {
                    is_Nav6up = true;
                }
            } // check Netscape

            // check Safari.
            // Safari user agent string is "Mozilla/5.0 (Macintosh; U; PPC Mac
            // OS X; en-us) AppleWebKit/XX (KHTML, like Gecko) Safari/YY"
            // where "XX" is the build version of Apple's web technology used by
            // Safari and "YY" is the build version of the Safari application.
            if ((userAgentString.indexOf("mozilla") > -1) && (userAgentString.indexOf("safari") > -1)
                    && (userAgentString.indexOf("aol") == -1) && (userAgentString.indexOf("firefox") == -1)
                    && (userAgentString.indexOf("msie") == -1) && (userAgentString.indexOf("opera") == -1)
                    && (userAgentString.indexOf("webtv") == -1)) {
                is_Safari = true; // assume for now
                browser = "Safari";
                // get full string after 'Safari' text
                String s = userAgentString.substring(userAgentString.indexOf("safari"), userAgentString.length());
                pos = s.indexOf("/");
                version = s.substring(pos + 1, s.length());
                pos = version.indexOf(".");
                if (pos == -1)
                    major = version;
                else
                    major = version.substring(0, pos);
                int v = getValue(major);
                if (v >= 8) {
                    is_Safari8up = true;
                }
            }

            // check Firefox.
            if ((userAgentString.indexOf("mozilla") > -1) && (userAgentString.indexOf("firefox") > -1)
                    && (userAgentString.indexOf("safari") == -1) && (userAgentString.indexOf("aol") == -1)
                    && (userAgentString.indexOf("msie") == -1) && (userAgentString.indexOf("opera") == -1)
                    && (userAgentString.indexOf("webtv") == -1)) {
                is_Firefox = true; // assume for now
                browser = "Firefox";
                // get full string after 'Safari' text
                String s = userAgentString.substring(userAgentString.indexOf("firefox"), userAgentString.length());
                pos = s.indexOf("/");
                version = s.substring(pos + 1, s.length());
                pos = version.indexOf(".");
                if (pos == -1)
                    major = version;
                major = version.substring(0, pos);
                String minor = version.substring(pos + 1, version.length());
                // just in case no sub minor version
                pos = minor.indexOf(".");
                if (pos > -1)
                    minor = minor.substring(0, pos);
                int majorVal = getValue(major);
                int minorVal = getValue(minor);
                if (majorVal >= 1 || majorVal == 0 && minorVal >= 10) {
                    is_Firefox10up = true;
                }
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }

        // check Operating System, we don't care about OS versions.
        if ((userAgentString.indexOf("windows") > -1) || (userAgentString.indexOf("win") > -1)) {
            is_Windows = true;
            OS = "Windows";
        }
        if ((userAgentString.indexOf("macintosh") > -1) || (userAgentString.indexOf("mac") > -1)) {
            is_Mac = true;
            OS = "Mac";
        }

        if ((userAgentString.indexOf("unix") > -1) || (userAgentString.indexOf("x11") > -1)
                || (userAgentString.indexOf("sunos") > -1) || (userAgentString.indexOf("hp-ux") > -1)
                || (userAgentString.indexOf("inux") > -1) || (userAgentString.indexOf("irix") > -1)
                || (userAgentString.indexOf("aix") > -1)) {
            is_Unix = true;
            OS = "Unix/Variant";
        }

    } // end constructor

    // get numeric value of version
    private int getValue(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException ex) {
        }
        return -1;
    }

    // accessors
    public String getBrowser() {
        return browser;
    }

    public String getMajor() {
        return major;
    }

    public String getVersion() {
        return version;
    }

    public boolean is_IE() {
        return is_IE;
    }

    public boolean is_IE3() {
        return is_IE3;
    }

    public boolean is_IE4() {
        return is_IE4;
    }

    public boolean is_IE5() {
        return is_IE5;
    }

    public boolean is_IE6() {
        return is_IE6;
    }

    public boolean is_Nav() {
        return is_Nav;
    }

    public boolean is_Nav3() {
        return is_Nav3;
    }

    public boolean is_Nav4() {
        return is_Nav4;
    }

    public boolean is_Nav6() {
        return is_Nav6;
    }

    public boolean is_Nav7() {
        return is_Nav7;
    }

    public boolean is_Mozilla() {
        return is_Mozilla;
    }

    public boolean is_AOL() {
        return is_AOL;
    }

    public boolean is_Opera() {
        return is_Opera;
    }

    public boolean is_WebTV() {
        return is_WebTV;
    }

    public String getOS() {
        return OS;
    }

    public boolean is_Windows() {
        return is_Windows;
    }

    public boolean is_Mac() {
        return is_Mac;
    }

    public boolean is_Unix() {
        return is_Unix;
    }

    /*
      * Return the list of browsers that have a level of JavaScript that we
      * accept. - John Akerley
      */

//    private static Vector getSupportedJavaScriptBrowsers() {
//        synchronized (supportedJavaScriptBrowsers) {
//            if (supportedJavaScriptBrowsers != null && supportedJavaScriptBrowsers.size() == 0) {
//                String browserString = PropertiesManager.getProperty("JAVASCRIPT_ENABLED_BROWSERS");
//                if (browserString != null) {
//                    StringTokenizer t = new StringTokenizer(browserString, ";");
//                    while (t.hasMoreElements()) {
//                        String token = (String) t.nextElement();
//                        supportedJavaScriptBrowsers.addElement(token);
//                    }
//                }
//            }
//        }
//        return supportedJavaScriptBrowsers;
//    }

//    public boolean isSupportedJavaScriptBrowser() {
//        boolean retValue = false;
//        for (int i = 0; getSupportedJavaScriptBrowsers() != null && i < getSupportedJavaScriptBrowsers().size(); i++) {
//            String browser = (String) getSupportedJavaScriptBrowsers().elementAt(i);
//            if (userAgentString != null && userAgentString.toUpperCase().startsWith(browser.toUpperCase())) {
//                retValue = true;
//                break;
//            }
//        }
//        return retValue;
//    }

    public void setJavaScriptEnabled(boolean isEnabled) {
        isJavaScriptEnabledFlag = isEnabled;
    }

    public boolean isJavaScriptEnabled() {
        return isJavaScriptEnabledFlag;
    }

    public boolean isSupportedBrowser() {
        if (is_AOL8up || is_IE5up || is_Nav6up || is_Safari8up || is_Firefox10up || is_Mozilla1up)
            return true;
        return false;
    }

    /**
     * Create a user agent based on HTTP request
     */
    public UserAgent(HttpServletRequest request) {
        checkBrowser(request);
    }


    public UserAgent() {

    }

    public boolean isMacIE() {
        if (is_IE() && is_Mac())
            return true;
        return false;
    }

    private void init() {
        isJavaScriptEnabledFlag = false;

        browser = "Unknown";
        major = "Unknown";
        version = "Unknown";

        is_IE = false;
        is_IE3 = false;
        is_IE4 = false;
        is_IE5 = false;
        is_IE6 = false;
        is_IE5up = false;
        is_Nav = false;
        is_Nav3 = false;
        is_Nav4 = false;
        is_Nav6 = false;
        is_Nav7 = false;
        is_Nav6up = false;

        is_Mozilla = false;
        is_Mozilla1up = false;

        is_AOL = false;
        is_Opera = false;
        is_WebTV = false;
        is_Safari = false;
        is_Safari8up = false;
        is_Firefox = false;
        is_Firefox10up = false;

        OS = "Unknown";
        is_Windows = false;
        is_Mac = false;
        is_Unix = false;
    }
} // class
