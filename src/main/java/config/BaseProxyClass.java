package config;

import agents.SetUpUserAgent;
import agents.USERAGENT;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class BaseProxyClass extends BaseClass1 {
    public static BrowserMobProxyServer serverBase;

    @BeforeClass
    public void bef() {
        serverBase.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        serverBase.newHar("youtube");
        SetUpUserAgent.create(USERAGENT.ANDROID_RU, serverBase);
    }

    @AfterClass
    public void after() throws IOException {
        Har har = serverBase.getHar();
        har.writeTo(new File("site.har"));
// Some code here ... (close browser, stop server)
        for (HarEntry entry : har.getLog().getEntries()) {
            System.out.println(entry.getRequest().getUrl());
        }
        serverBase.stop();

    }
}
