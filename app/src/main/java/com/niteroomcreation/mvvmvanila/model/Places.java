package com.niteroomcreation.mvvmvanila.model;

import com.niteroomcreation.mvvmvanila.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Septian Adi Wijaya on 01/04/2021.
 * please be sure to add credential if you use people's code
 */
public class Places {

    private String imgUrl;
    private String name;

    public Places(String name) {
        this.imgUrl = "";
        this.name = name;
    }

    public Places(String name, String imgUrl) {
        this.imgUrl = imgUrl;
        this.name = name;
    }

    public static List<Places> constructPlaces(int size, String imgUrl) {

        List<Places> p = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            p.add(new Places(CommonUtil.constructRandomAlphabet(10), imgUrl == null ? constructRandomPickUrlImage() : imgUrl));
        }

        return p;
    }

    public static String constructRandomPickUrlImage() {
        List<String> list = new ArrayList<String>() {{
            add("https://img.buzzfeed.com/buzzfeed-static/static/2016-04/26/1/enhanced/webdr08/enhanced-597-1461649079-8.jpg");
            add("https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fcdn.artwallpaperhi.com%2F1920x1080%2F20180208%2F5a7b97d2a4e9b.jpg&f=1&nofb=1");
            add("https://vignette.wikia.nocookie.net/spongebob/images/e/e2/Squidward_Design_2.jpg/revision/latest?cb=20110911114021");
            add("https://specials-images.forbesimg.com/imageserve/5e48aee9a854780006b17708/960x0.jpg?fit=scale");
            add("https://i.pinimg.com/736x/e0/80/75/e08075ea80008820c3caf6bcfdaf0e66.jpg");
            add("https://s.yimg.com/ny/api/res/1.2/Lw609onc8Ozjz7sRh1fouA--~A/YXBwaWQ9aGlnaGxhbmRlcjtzbT0xO3c9ODAw/https://media-mbst-pub-ue1.s3.amazonaws.com/creatr-uploaded-images/2020-06/76417400-af10-11ea-bfbc-a2ab4e2f19ac");
            add("https://images.hdqwalls.com/download/spongebob-squarepants-4k-4c-1366x768.jpg");
        }};

        return list.get(0 + (int) (Math.random() * (list.size() - 1)));
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Places{" +
                "imgUrl='" + imgUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
