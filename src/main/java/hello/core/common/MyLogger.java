package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuId;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuId + "]" + "[" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init() {
        uuId = UUID.randomUUID().toString();
        System.out.println("[" + uuId + "] request scope bean create :" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuId + "] request scope bean close :" + this);
    }
}
