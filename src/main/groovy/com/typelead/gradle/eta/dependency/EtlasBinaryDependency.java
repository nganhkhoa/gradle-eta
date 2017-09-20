package com.typelead.gradle.eta.dependency;

public class EtlasBinaryDependency {

    private final String path;
    private final String version;

    EtlasBinaryDependency(String path, String version) {
        this.path = path;
        this.version = version;
    }

    public String getPath() {
        return path;
    }

    public String getVersion() {
        return version;
    }
}
