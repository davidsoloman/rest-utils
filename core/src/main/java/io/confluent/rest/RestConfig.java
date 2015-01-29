/**
 * Copyright 2014 Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.confluent.rest;

import io.confluent.common.config.AbstractConfig;
import io.confluent.common.config.ConfigDef;
import io.confluent.common.config.ConfigDef.Type;
import io.confluent.common.config.ConfigDef.Importance;

import java.util.Map;
import java.util.TreeMap;

public class RestConfig extends AbstractConfig {
  public static final String DEBUG_CONFIG = "debug";
  protected static final String DEBUG_CONFIG_DOC =
      "Boolean indicating whether extra debugging information is generated in some " +
      "error response entities.";
  protected static final boolean DEBUG_CONFIG_DEFAULT = true;

  public static final String PORT_CONFIG = "port";
  protected static final String PORT_CONFIG_DOC = "Port to listen on for new connections.";
  protected static final int PORT_CONFIG_DEFAULT = 8080;

  public static final String RESPONSE_MEDIATYPE_PREFERRED_CONFIG = "response.mediatype.preferred";
  protected static final String RESPONSE_MEDIATYPE_PREFERRED_CONFIG_DOC =
      "An ordered list of the server's preferred media types used for responses, " +
      "from most preferred to least.";
  protected static final String RESPONSE_MEDIATYPE_PREFERRED_CONFIG_DEFAULT = "application/json";

  public static final String RESPONSE_MEDIATYPE_DEFAULT_CONFIG = "response.mediatype.default";
  protected static final String RESPONSE_MEDIATYPE_DEFAULT_CONFIG_DOC =
      "The default response media type that should be used if no specify types are requested in " +
      "an Accept header.";
  protected static final String RESPONSE_MEDIATYPE_DEFAULT_CONFIG_DEFAULT = "application/json";

  public static final String SHUTDOWN_GRACEFUL_MS_CONFIG = "shutdown.graceful.ms";
  protected static final String SHUTDOWN_GRACEFUL_MS_DOC =
      "Amount of time to wait after a shutdown request for outstanding requests to complete.";
  protected static final String SHUTDOWN_GRACEFUL_MS_DEFAULT = "1000";

  public static final String REQUEST_LOGGER_NAME_CONFIG = "request.logger.name";
  protected static final String REQUEST_LOGGER_NAME_DOC =
      "Name of the SLF4J logger to write the NCSA Common Log Format request log.";
  protected static final String REQUEST_LOGGER_NAME_DEFAULT = "io.confluent.rest-utils.requests";

  public static ConfigDef baseConfigDef() {
    return new ConfigDef()
        .define(DEBUG_CONFIG, Type.BOOLEAN,
                DEBUG_CONFIG_DEFAULT, Importance.HIGH, DEBUG_CONFIG_DOC)
        .define(PORT_CONFIG, Type.INT, PORT_CONFIG_DEFAULT, Importance.HIGH,
                PORT_CONFIG_DOC)
        .define(RESPONSE_MEDIATYPE_PREFERRED_CONFIG, Type.LIST,
                RESPONSE_MEDIATYPE_PREFERRED_CONFIG_DEFAULT, Importance.HIGH,
                RESPONSE_MEDIATYPE_PREFERRED_CONFIG_DOC)
        .define(RESPONSE_MEDIATYPE_DEFAULT_CONFIG, Type.STRING,
                RESPONSE_MEDIATYPE_DEFAULT_CONFIG_DEFAULT, Importance.HIGH,
                RESPONSE_MEDIATYPE_DEFAULT_CONFIG_DOC)
        .define(SHUTDOWN_GRACEFUL_MS_CONFIG, Type.INT,
                SHUTDOWN_GRACEFUL_MS_DEFAULT, Importance.LOW,
                SHUTDOWN_GRACEFUL_MS_DOC)
        .define(REQUEST_LOGGER_NAME_CONFIG, Type.STRING,
                REQUEST_LOGGER_NAME_DEFAULT, Importance.LOW,
                REQUEST_LOGGER_NAME_DOC);
  }

  public RestConfig(ConfigDef definition, Map<?, ?> originals) {
    super(definition, originals);
  }

  public RestConfig(ConfigDef definition) {
    super(definition, new TreeMap<Object,Object>());
  }
}