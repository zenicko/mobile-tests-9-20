package ru.zenicko.wikipedia.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/local.properties"})
public interface ProjectConfig extends Config {
    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();
}
