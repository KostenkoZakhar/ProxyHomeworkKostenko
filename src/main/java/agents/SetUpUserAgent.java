package agents;

import config.BaseProxyClass;
import net.lightbody.bmp.BrowserMobProxyServer;

public class SetUpUserAgent {
    public static void create(USERAGENT useragent, BrowserMobProxyServer server) {
        switch (useragent) {
            case IPHONE_EN:
                createIPhoneEn(server);
                break;
            case ANDROID_RU:
                createAndroidRu(server);
        }
    }

    private static void createAndroidRu(BrowserMobProxyServer server) {
        server.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().remove("user-agent");
            request.headers().remove("Accept-Language");
            request.headers().remove("Content-Language");


            request.headers().add("User-Agent", "Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv)" +
                    "AppleWebKit/537.36 (KHTML, like Gecko)" +
                    "Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36");
            request.headers().add("Accept-Language", "ru");
            request.headers().add("Content-Language", "ru_RU");

            request.headers().remove("Referer");

            return null;
        });
    }

    private static void createIPhoneEn(BrowserMobProxyServer server) {
        server.addRequestFilter((request, contents, messageInfo) -> {
            request.headers().remove("user-agent");
            request.headers().remove("Accept-Language");
            request.headers().remove("Content-Language");

             request.headers().add("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1");
            request.headers().add("Accept-Language", "en");
            request.headers().add("Content-Language", "en_EN");

            request.headers().remove("Referer");
            return null;
        });

    }
}
