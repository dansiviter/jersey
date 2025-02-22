/*
 * Copyright (c) 2022 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package org.glassfish.jersey.apache5.connector;

import java.util.Map;

import org.glassfish.jersey.internal.util.PropertiesClass;
import org.glassfish.jersey.internal.util.PropertiesHelper;

/**
 * Configuration options specific to the Client API that utilizes {@link Apache5ConnectorProvider}.
 *
 * @author jorgeluisw@mac.com
 * @author Paul Sandoz
 * @author Pavel Bucek
 * @author Arul Dhesiaseelan (aruld at acm.org)
 * @author Steffen Nießing
 */
@PropertiesClass
public final class Apache5ClientProperties {

    /**
     * The credential provider that should be used to retrieve
     * credentials from a user. Credentials needed for proxy authentication
     * are stored here as well.
     * <p/>
     * The value MUST be an instance of {@link org.apache.hc.client5.http.auth.CredentialsProvider}.
     * <p/>
     * If the property is absent a default provider will be used.
     * <p/>
     * The name of the configuration property is <tt>{@value}</tt>.
     */
    public static final String CREDENTIALS_PROVIDER = "jersey.config.apache5.client.credentialsProvider";

    /**
     * A value of {@code false} indicates the client should handle cookies
     * automatically using HttpClient's default cookie policy. A value
     * of {@code true} will cause the client to ignore all cookies.
     * <p/>
     * The value MUST be an instance of {@link java.lang.Boolean}.
     * <p/>
     * The default value is {@code false}.
     * <p/>
     * The name of the configuration property is <tt>{@value}</tt>.
     */
    public static final String DISABLE_COOKIES = "jersey.config.apache5.client.handleCookies";

    /**
     * A value of {@code true} indicates that a client should send an
     * authentication request even before the server gives a 401
     * response.
     * <p>
     * This property may only be set prior to constructing Apache connector using {@link Apache5ConnectorProvider}.
     * <p/>
     * The value MUST be an instance of {@link java.lang.Boolean}.
     * <p/>
     * The default value is {@code false}.
     * <p/>
     * The name of the configuration property is <tt>{@value}</tt>.
     */
    public static final String PREEMPTIVE_BASIC_AUTHENTICATION = "jersey.config.apache5.client.preemptiveBasicAuthentication";

    /**
     * Connection Manager which will be used to create {@link org.apache.hc.client5.http.classic.HttpClient}.
     * <p/>
     * The value MUST be an instance of {@link org.apache.hc.client5.http.io.HttpClientConnectionManager}.
     * <p/>
     * If the property is absent a default Connection Manager will be used
     * ({@link org.apache.hc.client5.http.impl.io.BasicHttpClientConnectionManager}).
     * If you want to use this client in multi-threaded environment, be sure you override default value with
     * {@link org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager} instance.
     * <p/>
     * The name of the configuration property is <tt>{@value}</tt>.
     */
    public static final String CONNECTION_MANAGER = "jersey.config.apache5.client.connectionManager";

    /**
     * A value of {@code true} indicates that configured connection manager should be shared
     * among multiple Jersey {@link org.glassfish.jersey.client.ClientRuntime} instances. It means that closing
     * a particular {@link org.glassfish.jersey.client.ClientRuntime} instance does not shut down the underlying
     * connection manager automatically. In such case, the connection manager life-cycle
     * should be fully managed by the application code. To release all allocated resources,
     * caller code should especially ensure {@link org.apache.hc.client5.http.io.HttpClientConnectionManager#close()} gets
     * invoked eventually.
     * <p>
     * This property may only be set prior to constructing Apache connector using {@link Apache5ConnectorProvider}.
     * <p/>
     * The value MUST be an instance of {@link java.lang.Boolean}.
     * <p/>
     * The default value is {@code false}.
     * <p/>
     * The name of the configuration property is <tt>{@value}</tt>.
     *
     * @since 2.18
     */
    public static final String CONNECTION_MANAGER_SHARED = "jersey.config.apache5.client.connectionManagerShared";

    /**
     * Request configuration for the {@link org.apache.hc.client5.http.classic.HttpClient}.
     * Http parameters which will be used to create {@link org.apache.hc.client5.http.classic.HttpClient}.
     * <p/>
     * The value MUST be an instance of {@link org.apache.hc.client5.http.config.RequestConfig}.
     * <p/>
     * If the property is absent default request configuration will be used.
     * <p/>
     * The name of the configuration property is <tt>{@value}</tt>.
     *
     * @since 2.5
     */
    public static final String REQUEST_CONFIG = "jersey.config.apache5.client.requestConfig";

    /**
     * HttpRequestRetryHandler which will be used to create {@link org.apache.hc.client5.http.classic.HttpClient}.
     * <p/>
     * The value MUST be an instance of {@link org.apache.hc.client5.http.HttpRequestRetryStrategy}.
     * <p/>
     * If the property is absent a default retry handler will be used
     * ({@link org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy}).
     * <p/>
     * The name of the configuration property is <tt>{@value}</tt>.
     */
    public static final String RETRY_STRATEGY = "jersey.config.apache5.client.retryStrategy";

    /**
     * ConnectionReuseStrategy for the {@link org.apache.hc.client5.http.classic.HttpClient}.
     * <p/>
     * The value MUST be an instance of {@link org.apache.hc.core5.http.ConnectionReuseStrategy}.
     * <p/>
     * If the property is absent the default reuse strategy of the Apache HTTP library will be used
     * <p/>
     * The name of the configuration property is <tt>{@value}</tt>.
     */
    public static final String REUSE_STRATEGY = "jersey.config.apache5.client.reuseStrategy";

    /**
     * ConnectionKeepAliveStrategy for the {@link org.apache.hc.client5.http.classic.HttpClient}.
     * <p/>
     * The value MUST be an instance of {@link org.apache.hc.client5.http.ConnectionKeepAliveStrategy}.
     * <p/>
     * If the property is absent the default keepalive strategy of the Apache HTTP library will be used
     * <p/>
     * The name of the configuration property is <tt>{@value}</tt>.
     */
    public static final String KEEPALIVE_STRATEGY = "jersey.config.apache5.client.keepAliveStrategy";


    /**
     * Strategy that closes the Apache Connection. Accepts an instance of {@link Apache5ConnectionClosingStrategy}.
     *
     * @see Apache5ConnectionClosingStrategy
     * @since 2.30
     */
    public static final String CONNECTION_CLOSING_STRATEGY = "jersey.config.apache5.client.connectionClosingStrategy";

    /**
     * A value of {@code false} indicates the client will use default ApacheConnector params. A value
     * of {@code true} will cause the client to take into account the system properties
     * {@code https.protocols}, {@code https.cipherSuites}, {@code http.keepAlive},
     * {@code http.maxConnections}.
     * <p/>
     * The value MUST be an instance of {@link java.lang.Boolean}.
     * <p/>
     * The default value is {@code false}.
     * <p/>
     * The name of the configuration property is <tt>{@value}</tt>.
     */
    public static final String USE_SYSTEM_PROPERTIES = "jersey.config.apache5.client.useSystemProperties";

    /**
     * Get the value of the specified property.
     *
     * If the property is not set or the actual property value type is not compatible with the specified type, the method will
     * return {@code null}.
     *
     * @param properties    Map of properties to get the property value from.
     * @param key           Name of the property.
     * @param type          Type to retrieve the value as.
     * @param <T>           Type of the property value.
     * @return Value of the property or {@code null}.
     *
     * @since 2.8
     */
    public static <T> T getValue(final Map<String, ?> properties, final String key, final Class<T> type) {
        return PropertiesHelper.getValue(properties, key, type, null);
    }

    /**
     * Prevents instantiation.
     */
    private Apache5ClientProperties() {
        throw new AssertionError("No instances allowed.");
    }
}
