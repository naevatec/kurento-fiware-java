/*
 * (C) Copyright 2018 Kurento (http://kurento.org/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.kurento.tutorial.platedetector.orion;

import org.kurento.orion.connector.OrionConnectorConfiguration;
import org.kurento.orion.connector.entities.device.Device;
import org.kurento.orion.connector.entities.device.DeviceOrionPublisher;
import org.kurento.tutorial.platedetector.models.Camera;

/**
 * Extension of the {@link DeviceOrionPublisher} for accepting a custom
 * {@link Camera}
 * 
 * @author Guiomar Tuñón (guiomar.tunon@gmail.com)
 *
 */
public class CamPublisher extends DeviceOrionPublisher<Camera> {

  public CamPublisher(OrionConnectorConfiguration config) {
	super(config);

  }

  /**
   * Uses the {@link Camera} data to initialize a {@link Device}
   * 
   * @param Camera
   *          the {@link Camera} that should be mapped to a {@link Device}
   * @return Device the initialized {@link Device}
   */
  @Override
  public Device mapEntityToOrionEntity(Camera cam) {

	String[] supportedProtocol = { "WebRTC" };

	Device entity = new Device();

	entity.setControlledAsset(cam.getControlledAsset());
	entity.setDateInstalled(cam.getCreationDate());
	entity.setDeviceState(cam.getState());
	entity._getDeviceCommons().setSupportedProtocol(supportedProtocol);
	entity._getGsmaCommons().setId(cam.getId());
	entity._getGsmaCommons().setDateCreated(cam.getCreationDate());
	entity._getGsmaCommons().setDescription("Plate detector camera example");
	entity._getGsmaCommons().setName(cam.getName());
	entity.setIpAddress(cam.getIp());
	return entity;
  }
}
