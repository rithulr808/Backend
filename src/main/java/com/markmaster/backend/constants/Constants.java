package com.markmaster.backend.constants;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    private  List<String> publicUrls;

    public Constants() {
        publicUrls = new ArrayList<>();
        publicUrls.add("/auth/login");
        publicUrls.add("/auth/register");
        publicUrls.add("/error");
    }

    public  List<String> getPublicUrls() {
        return publicUrls;
    }

}
