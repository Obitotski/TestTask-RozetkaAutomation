package test.task.fluix.utils;

import com.typesafe.config.Config;

import static com.typesafe.config.ConfigFactory.load;

public interface DataProvider {

    static Config readConfig() {
        return load("data.conf");
    }

    String URL_ROZETKA_HOMEPAGE = readConfig().getString("urls.rozetka");
    String SEARCH_VALUE = readConfig().getString("searchValue");
}
