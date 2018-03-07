package com.typelead.gradle.eta.internal;

import java.util.Map;

import groovy.lang.MissingMethodException;

import com.typelead.gradle.utils.ExtensionHelper;
import com.typelead.gradle.eta.api.EtaDependencyHandler;
import com.typelead.gradle.eta.api.EtaDependency;
import com.typelead.gradle.eta.api.EtaDirectDependency;
import com.typelead.gradle.eta.api.EtaConfiguration;

import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;

public class DefaultEtaDependencyHandler implements EtaDependencyHandler {

    private final ConfigurationContainer configurationContainer;

    public DefaultEtaDependencyHandler(ConfigurationContainer configurationContainer) {
        this.configurationContainer = configurationContainer;
    }

    @Override
    public EtaDependency add(String configurationName, String dependencyConstraint) {
        return add(configurationName, DefaultEtaDirectDependency.create(dependencyConstraint));
    }

    public EtaDependency add(Configuration targetConfiguration, String dependencyConstraint) {
        return add(targetConfiguration, DefaultEtaDirectDependency.create(dependencyConstraint));
    }

    @Override
    public EtaDependency add(String configurationName, Map<String, String> dependencyConstraintAttributes) {
        return add(configurationName, DefaultEtaDirectDependency.create(dependencyConstraintAttributes));
    }

    public EtaDependency add(Configuration targetConfiguration, Map<String, String> dependencyConstraintAttributes) {
        return add(targetConfiguration, DefaultEtaDirectDependency.create(dependencyConstraintAttributes));
    }

    public EtaDependency add(String configurationName, EtaDependency dependency) {
        return add(configurationContainer.findByName(configurationName), dependency);
    }

    public EtaDependency add(Configuration targetConfiguration, EtaDependency dependency) {
        ExtensionHelper.getExtension(targetConfiguration, EtaConfiguration.class)
            .getDependencies().add(dependency);
        return dependency;
    }

    public Object methodMissing(final String configurationName, final Object configurationArguments) {
        Object[] configurationParameters = (Object[]) configurationArguments;
        int numConfigurationParameters = configurationParameters.length;
        if (numConfigurationParameters == 1) {
            Configuration targetConfiguration = configurationContainer.findByName(configurationName);
            if (targetConfiguration != null) {
                Object argument = configurationParameters[0];
                if (argument instanceof Map) {
                    return add(targetConfiguration, (Map<String,String>)argument);
                } else if (argument instanceof String) {
                    return add(targetConfiguration, (String)argument);
                }
            }

        }
        throw new MissingMethodException(configurationName, getClass(), configurationParameters);
    }
}