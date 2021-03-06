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
package org.sakaiproject.scorm.exceptions;

/**
 * Exception related to an unexpected problem in the underlying storage system 
 * @author roland
 *
 */
public class ResourceStorageException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceStorageException() {
	}

	public ResourceStorageException(String message) {
		super(message);
	}

	public ResourceStorageException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceStorageException(Throwable cause) {
		super(cause);
	}

}
