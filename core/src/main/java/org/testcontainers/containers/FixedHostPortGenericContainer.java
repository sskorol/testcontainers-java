package org.testcontainers.containers;

import org.jetbrains.annotations.NotNull;

/**
 * Variant of {@link GenericContainer} that allows a fixed port on the docker host to be mapped to a container port.
 *
 * <p><strong>Normally this should not be required, and Docker should be allowed to choose a free host port instead</strong>.
 * However, when a fixed host port is absolutely required for some reason, this class can be used to set it.</p>
 *
 * <p>Callers are responsible for ensuring that this fixed port is actually available; failure will occur if it is
 * not available - which could manifest as flaky or unstable tests.</p>
 */
public class FixedHostPortGenericContainer extends GenericContainer {
    public FixedHostPortGenericContainer(@NotNull String dockerImageName) {
        super(dockerImageName);
    }

    /**
     * Bind a fixed port on the docker host to a container port
     * @param hostPort          a port on the docker host, which must be available
     * @param containerPort     a port in the container
     * @return                  this container
     */
    public FixedHostPortGenericContainer withFixedExposedPort(int hostPort, int containerPort) {

        super.addFixedExposedPort(hostPort, containerPort);

        return this;
    }
}
