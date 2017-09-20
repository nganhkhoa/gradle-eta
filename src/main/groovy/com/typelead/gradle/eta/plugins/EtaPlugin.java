package com.typelead.gradle.eta.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.BasePlugin;

/**
 * A {@link Plugin} which sets up an Eta project.
 */
@SuppressWarnings("WeakerAccess")
public class EtaPlugin implements Plugin<Project> {

    public static final String ETA_EXTENSION_NAME = "eta";
    public static final String ETA_RUNTIME_CONFIGURATION_NAME = "etaRuntime";
    public static final String TASK_GROUP_NAME = "EtaPlugin";
    public static final String CLEAN_ETA_TASK_NAME = "cleanEta";
    public static final String COMPILE_ETA_TASK_NAME = "compileEta";
    public static final String RUN_ETA_TASK_NAME = "runEta";
    public static final String TEST_DEPS_ETA_TASK_NAME = "installTestDepsEta";
    public static final String TEST_COMPILE_ETA_TASK_NAME = "testCompileEta";
    public static final String TEST_ETA_TASK_NAME = "testEta";

    public static final boolean DEFAULT_USE_SYSTEM_ETLAS = false;
    public static final String DEFAULT_ETLAS_REPO = "http://88a2a1b21f8e03a6bc8d-8f2e61d843ea88e4f30ab3f81ca0e396.r42.cf5.rackcdn.com";
    public static final boolean DEFAULT_USE_SANDBOX = true;
    public static final String DEFAULT_BUILD_DIR = "build/etlas/dist";
    public static final String DEFAULT_SANDBOX_CONFIG = "cabal.sandbox.config";
    public static final String DEFAULT_ETA_MAIN_CLASS = "eta.main";

    @Override
    public void apply(Project project) {
        project.getPluginManager().apply(EtaBasePlugin.class);
        project.getPluginManager().apply(BasePlugin.class);
    }
}
