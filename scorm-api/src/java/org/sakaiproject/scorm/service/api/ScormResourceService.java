/*
 * #%L
 * SCORM API
 * %%
 * Copyright (C) 2007 - 2016 Sakai Project
 * %%
 * Licensed under the Educational Community License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *             http://opensource.org/licenses/ecl2
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.sakaiproject.scorm.service.api;

import java.io.InputStream;
import java.util.List;

import org.sakaiproject.scorm.exceptions.InvalidArchiveException;
import org.sakaiproject.scorm.exceptions.ResourceNotDeletedException;
import org.sakaiproject.scorm.exceptions.ResourceStorageException;
import org.sakaiproject.scorm.model.api.Archive;
import org.sakaiproject.scorm.model.api.ContentPackageResource;

public interface ScormResourceService {

	public String convertArchive(String resourceId, String title) throws InvalidArchiveException, ResourceStorageException;

	public Archive getArchive(String resourceId) throws ResourceStorageException;

	public InputStream getArchiveStream(String resourceId) throws ResourceStorageException;

	public int getMaximumUploadFileSize();

	public String getResourcePath(String resourceId, String launchLine);

	public List<ContentPackageResource> getResources(String archiveResourceId) throws ResourceStorageException;

	public List<Archive> getUnvalidatedArchives() throws ResourceStorageException;

	public String putArchive(InputStream stream, String name, String mimeType, boolean isHidden, int priority) throws ResourceStorageException;

	public void removeResources(String collectionId) throws ResourceNotDeletedException;

}
