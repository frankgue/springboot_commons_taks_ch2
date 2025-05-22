package com.gkfcsolution.springboot_commons_taks_ch2.exception;

import lombok.Getter;

public class UrlNotAccessibleException extends RuntimeException{
    private String url;

    public UrlNotAccessibleException(String url) {
                this(url, null);
    }

    public UrlNotAccessibleException(String url, Throwable cause) {
        super("URL " + url + " is not accessible", cause);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
